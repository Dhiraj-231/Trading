package com.Dhiraj.Service;

import com.Dhiraj.Domain.WalletTransactionType;
import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Models.WalletTransaction;

import java.util.List;

public interface WalletTransactionService {
    List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type);
    WalletTransaction createTransaction(Wallet wallet,
                                        WalletTransactionType type,
                                        String transferId,
                                        String purpose,
                                        Long amount
    );
}
