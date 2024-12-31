package com.Dhiraj.Controllers;

import com.Dhiraj.Domain.WalletTransactionType;
import com.Dhiraj.Models.*;
import com.Dhiraj.Response.PaymentResponse;
import com.Dhiraj.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;
    private final UserService userService;
    private final OrderService orderService;
    private final WalletTransactionService walletTransactionService;
    private final PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<?> getUserWallet(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    @GetMapping("/transaction")
    public ResponseEntity<List<WalletTransaction>> getWalletTransaction(@RequestHeader("Authorization") String jwt)
            throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);
        List<WalletTransaction> transactions = walletTransactionService.getTransactions(wallet, null);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PutMapping("/deposit/amount/{amount}")
    public ResponseEntity<PaymentResponse> depositMoney(@RequestHeader("Authorization") String jwt,
            @PathVariable Long amount) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPayment_url("deposite Success...");
        walletService.addBalanceToWallet(wallet, amount);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public ResponseEntity<Wallet> addMoneyToWallet(@RequestHeader("Authorization") String jwt,
            @RequestParam(name = "order_id") Long orderId,
            @RequestParam(name = "payment_id") String paymentId) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);

        PaymentOrder order = paymentService.getPaymentOrderById(orderId);
        Boolean status = paymentService.processPaymentOrder(order, paymentId);
        PaymentResponse response = new PaymentResponse();
        response.setPayment_url("Deposit SuccessFully..");

        if (status) {
            wallet = walletService.addBalanceToWallet(wallet, order.getAmount());
        }

        return new ResponseEntity<>(wallet, HttpStatus.OK);

    }

    @PutMapping("/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(@RequestHeader("Authorization") String jwt,
            @PathVariable Long walletId,
            @RequestBody WalletTransaction req) throws Exception {
        User senderUser = userService.findUserProfileByJwt(jwt);

        Wallet reciverWallet = walletService.findWalletById(walletId);

        Wallet wallet = walletService.walletToWalletTransfer(senderUser, reciverWallet, req.getAmount());
        WalletTransaction walletTransaction = walletTransactionService.createTransaction(
                wallet,
                WalletTransactionType.WALLET_TRANSFER, reciverWallet.getId().toString(),
                req.getPurpose(),
                -req.getAmount());

        return new ResponseEntity<>(wallet, HttpStatus.OK);

    }

    @PutMapping("/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(@PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Order order = orderService.getOrderById(orderId);

        Wallet wallet = walletService.payOrderPayment(order, user);

        return new ResponseEntity<>(wallet, HttpStatus.OK);

    }
}