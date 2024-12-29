package com.Dhiraj.Repository;

import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Models.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {
    List<WalletTransaction> findByWalletOrderByDateDesc(Wallet wallet);
}
