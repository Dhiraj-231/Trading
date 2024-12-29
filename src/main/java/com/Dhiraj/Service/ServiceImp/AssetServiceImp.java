package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Models.Asset;
import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.User;
import com.Dhiraj.Repository.AssetsRepository;
import com.Dhiraj.Service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImp implements AssetService {
    private final AssetsRepository assetsRepository;
    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        Asset asset=new Asset();
        asset.setBuyPrice(coin.getCurrentPrice());
        asset.setQuantity(quantity);
        asset.setCoin(coin);
        asset.setUser(user);
        return assetsRepository.save(asset);
    }

    @Override
    public Asset getAssetById(Long assetId) {
        return assetsRepository.findById(assetId).orElseThrow(()-> new IllegalArgumentException("Asset not found"));
    }

    @Override
    public Asset getAssetByUserAndAssetId(Long userId, Long id) {
        return assetsRepository.findByAssetIdAndUserId(id,userId);
    }

    @Override
    public List<Asset> getUsersAssets(Long userId) {

        return assetsRepository.findByUserId(userId) ;
    }

    @Override
    public Asset updateAsset(Long assetId, double quantity) throws Exception {
        Asset oldAsset=getAssetById(assetId);
        if(oldAsset==null){
            throw new Exception("Asset not found...");
        }
        oldAsset.setQuantity(quantity+oldAsset.getQuantity());

        return assetsRepository.save(oldAsset);
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) throws Exception {

        return assetsRepository.findByUserIdAndCoinId(userId,coinId);
    }

    @Override
    public void deleteAsset(Long assetId) {
        assetsRepository.deleteById(assetId);
    }
}
