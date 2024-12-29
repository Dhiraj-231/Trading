package com.Dhiraj.Repository;

import com.Dhiraj.Models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetsRepository extends JpaRepository<Asset, Long> {
    public List<Asset> findByUserId(Long userId);

    Asset findByUserIdAndCoinId(Long userId, String coinId);

    Asset findByAssetIdAndUserId(Long assetId, Long userId);
}
