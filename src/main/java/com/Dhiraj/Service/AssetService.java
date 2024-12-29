package com.Dhiraj.Service;

import com.Dhiraj.Models.Asset;
import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.User;

import java.util.List;

public interface AssetService {
    Asset createAsset(User user, Coin coin,double quantity);
    Asset getAssetById(Long assetId);
    Asset getAssetByUserAndAssetId(Long userId,Long assetId);
    List<Asset> getUsersAssets(Long userId);
    Asset updateAsset(Long assetId,double quantity) throws Exception;
    Asset findAssetByUserIdAndCoinId(Long userId,String coinId) throws Exception;
    void deleteAsset(Long assetId);
}
