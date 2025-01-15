package com.Dhiraj.Controllers;

import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Models.Withdrawal;
import com.Dhiraj.Service.UserService;
import com.Dhiraj.Service.WalletService;
import com.Dhiraj.Service.WalletTransactionService;
import com.Dhiraj.Service.WithdrawalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping("/api/withdrawal")
@RestController
@RequiredArgsConstructor
public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    private final WalletService walletService;
    private final UserService userService;
    private final WalletTransactionService walletTransactionService;

    @PostMapping("/{amount}")
    public ResponseEntity<?> withdrawalRequest(@PathVariable Long amount,
            @RequestHeader("Authorization") String jwt)
            throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet userWallet = walletService.getUserWallet(user);

        Withdrawal withdrawal = withdrawalService.requestWithdrawal(amount, user);
        walletService.addBalanceToWallet(userWallet, -withdrawal.getAmount());
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @PatchMapping("/admin/{id}/proceed/{accept}")
    public ResponseEntity<?> proceedWithdrawal(
            @PathVariable Long id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        Withdrawal withdrawal = withdrawalService.procedWithdrawal(id, accept);

        Wallet userWallet = walletService.getUserWallet(user);
        if (!accept) {
            walletService.addBalanceToWallet(userWallet, withdrawal.getAmount());
        }

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @GetMapping("/withdrawal/history")
    public ResponseEntity<List<Withdrawal>> getWithdrawalHistory(

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        List<Withdrawal> withdrawal = withdrawalService.getUsersWithdrawalHistory(user);

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Withdrawal>> getAllWithdrawalRequest(

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        List<Withdrawal> withdrawal = withdrawalService.getAllWithdrawalRequest();

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }
}
