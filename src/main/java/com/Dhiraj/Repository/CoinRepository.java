package com.Dhiraj.Repository;

import com.Dhiraj.Models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin,String> {
}
