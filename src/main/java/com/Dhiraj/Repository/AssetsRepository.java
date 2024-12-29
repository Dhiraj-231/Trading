package com.Dhiraj.Repository;

import com.Dhiraj.Models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetsRepository extends JpaRepository<Asset, Long> {
    public List<Asset> findByUserId(Long userId);

    Asset findByUserIdAndCoinId(Long userId, String coinId);
    @Query("SELECT a FROM Asset a WHERE a.assetId = :assetId AND a.user.id = :userId")
    Asset findByAssetIdAndUserId(Long assetId, Long userId);

}
