package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Domain.OrderType;
import com.Dhiraj.Exception.WalletException;
import com.Dhiraj.Models.WalletTransaction;
import com.Dhiraj.Repository.WalletRepository;
import com.Dhiraj.Models.Order;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Repository.WalletTransactionRepository;
import com.Dhiraj.Service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImp implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletTransactionRepository walletTransactionRepository;

    public Wallet generateWallet(User user){
        Wallet wallet=new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }
    @Override
    public Wallet getUserWallet(User user) throws WalletException {
        Wallet wallet=walletRepository.findByUserId(user.getId());
        if(wallet!=null) return wallet;
        wallet=generateWallet(user);
        return wallet;
    }

    @Override
    public Wallet addBalanceToWallet(Wallet wallet, Long money) throws WalletException {
        wallet.setBalance(wallet.getBalance().add(BigDecimal.valueOf(money)));
        walletRepository.save(wallet);
        return wallet;
    }

    @Override
    public Wallet findWalletById(Long id) throws WalletException {
        Optional<Wallet> wallet=walletRepository.findById(id);
        if(wallet.isPresent()) return wallet.get();
        throw new WalletException("Wallet not found with id "+ id);
    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws WalletException {
        Wallet senderWallet=getUserWallet(sender);
        if(senderWallet.getBalance().compareTo(BigDecimal.valueOf(amount))<0) throw new WalletException("Insufficient balance....");
        BigDecimal senderBalance=senderWallet.getBalance().subtract(BigDecimal.valueOf(amount));
        senderWallet.setBalance(senderBalance);
        return walletRepository.save(senderWallet);
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) throws WalletException {
        Wallet wallet=getUserWallet(user);
        WalletTransaction walletTransaction=new WalletTransaction();
        walletTransaction.setWallet(wallet);
        walletTransaction.setPurpose(order.getOrderType()+" "+order.getOrderItem().getCoin().getId());

        walletTransaction.setDate(LocalDate.now());
        walletTransaction.setTransferID(order.getOrderItem().getCoin().getSymbol());

        if(order.getOrderType().equals(OrderType.BUY)){
            walletTransaction.setAmount(-order.getPrice().longValue());
            BigDecimal newBalance=wallet.getBalance().subtract(order.getPrice());
            if(newBalance.compareTo(order.getPrice())<0) throw new WalletException("Insufficient fund for this transaction..");
        } else if (order.getOrderType().equals(OrderType.SELL)) {
            walletTransaction.setAmount(order.getPrice().longValue());
            BigDecimal newBalance=wallet.getBalance().add(order.getPrice());
            wallet.setBalance(newBalance);
        }
        walletTransactionRepository.save(walletTransaction);
        walletRepository.save(wallet);
        return wallet;
    }
}
