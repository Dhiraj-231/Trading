package com.Dhiraj.Controllers;

import com.Dhiraj.Models.Coin;
import com.Dhiraj.Service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coins")
@RequiredArgsConstructor
public class CoinController {
    private final CoinService coinService;
    private final ObjectMapper objectMapper;

    @GetMapping
    ResponseEntity<List<Coin>> getCoinList(@RequestParam("page") int page) throws Exception{
        List<Coin>coins=coinService.getCoinList(page);
        return new ResponseEntity<>(coins, HttpStatus.OK);
    }
    @GetMapping("/{coinId}/chart")
    ResponseEntity<JsonNode> getMarkedChart(@PathVariable String coinId,@RequestParam("days") int days) throws Exception{
        String coins=coinService.getMarketChart(coinId,days);
        JsonNode jsonNode=objectMapper.readTree(coins);
        return ResponseEntity.ok(jsonNode);
    }
    @GetMapping("/search")
    ResponseEntity<JsonNode> searchCoin(@RequestParam("q") String keywords) throws JsonProcessingException{
        String coin=coinService.searchCoin(keywords);
        JsonNode jsonNode=objectMapper.readTree(coin);
        return ResponseEntity.ok(jsonNode);
    }
    @GetMapping("/top50")
    ResponseEntity<JsonNode> getTop50CoinByMarketCapRank() throws Exception {
        String coins=coinService.getTop50CoinsByMarketCapRank();
        JsonNode jsonNode=objectMapper.readTree(coins);

        return ResponseEntity.ok(jsonNode);
    }
    @GetMapping("/trending")
    ResponseEntity<JsonNode> getTrendingCoin() throws JsonProcessingException,Exception{
        String coins=coinService.getTrendingCoin();
        JsonNode jsonNode=objectMapper.readTree(coins);
        return ResponseEntity.ok(jsonNode);
    }
    @GetMapping("/details/{coinId}")
    ResponseEntity<JsonNode> getCoinDetails(@PathVariable String coinId) throws JsonProcessingException {
        String coin=coinService.getCoinDetails(coinId);
        JsonNode jsonNode = objectMapper.readTree(coin);

        return ResponseEntity.ok(jsonNode);
    }
}
