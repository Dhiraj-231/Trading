package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Domain.WalletTransactionType;
import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Models.WalletTransaction;
import com.Dhiraj.Repository.WalletTransactionRepository;
import com.Dhiraj.Service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImp implements WalletTransactionService {
    private final WalletTransactionRepository walletTransactionRepository;
    @Override
    public List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type) {

        return walletTransactionRepository.findByWalletOrderByDateDesc(wallet);
    }

    @Override
    public WalletTransaction createTransaction(Wallet wallet, WalletTransactionType type, String transferId, String purpose, Long amount) {
        WalletTransaction transaction = new WalletTransaction();
        transaction.setWallet(wallet);
        transaction.setDate(LocalDate.now());
        transaction.setType(type);
        transaction.setTransferID(transferId);
        transaction.setPurpose(purpose);
        transaction.setAmount(amount);

        return walletTransactionRepository.save(transaction);
    }
}
