package com.Dhiraj.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TradingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double sellingPrice;
    private double buyingPrice;

    @Embedded
    private Coin coin;

    @ManyToOne
    private User user;
}
