package com.Dhiraj.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long assetId;
    private double quantity;
    private double buyPrice;

    @ManyToOne
    private Coin coin;

    @ManyToOne
    private User user;
}
