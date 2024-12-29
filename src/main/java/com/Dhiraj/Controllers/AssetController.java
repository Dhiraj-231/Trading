package com.Dhiraj.Controllers;

import com.Dhiraj.Exception.UserException;
import com.Dhiraj.Models.Asset;
import com.Dhiraj.Models.User;
import com.Dhiraj.Service.AssetService;
import com.Dhiraj.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;
    private final UserService userService;

    @GetMapping("/{assetId}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long assetId){
        Asset asset=assetService.getAssetById(assetId);
        return ResponseEntity.ok().body(asset);
    }

    @GetMapping("/coin/{coinId}/user")
    public ResponseEntity<Asset> getAssetByUserIdAndCoinId(@PathVariable String coinId, @RequestHeader("Authorization") String jwt) throws Exception{
        User user=userService.findUserProfileByJwt(jwt);
        Asset asset=assetService.findAssetByUserIdAndCoinId(user.getId(),coinId);
        return ResponseEntity.ok().body(asset);
    }
    @GetMapping()
    public ResponseEntity<List<Asset>> getAssetsForUser(@RequestHeader("Authorization") String jwt) throws UserException {
        User user=userService.findUserProfileByJwt(jwt);
        List<Asset> assets=assetService.getUsersAssets(user.getId());
        return ResponseEntity.ok().body(assets);
    }
}
