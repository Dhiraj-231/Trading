package com.Dhiraj.Repository;

import com.Dhiraj.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    public Wallet findByUserId(Long userId);
}
