package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Watchlist;
import com.Dhiraj.Repository.WatchlistRepository;
import com.Dhiraj.Service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService {
    private final WatchlistRepository watchlistRepository;
    @Override
    public Watchlist findUserWatchList(Long userId) throws Exception {
        Watchlist watchlist=watchlistRepository.findByUserId(userId);
        if(watchlist==null) throw new Exception("Watch not found..");
        return watchlist;
    }

    @Override
    public Watchlist createWatchList(User user) {
        Watchlist watchlist=new Watchlist();
        watchlist.setUser(user);
        return watchlistRepository.save(watchlist);
    }

    @Override
    public Watchlist findById(Long id) throws Exception {
        Optional<Watchlist> optionalWatchlist=watchlistRepository.findById(id);
        if (optionalWatchlist.isEmpty()) throw new Exception("Watch List not Found...");
        return optionalWatchlist.get();
    }

    @Override
    public Coin addItemToWatchList(Coin coin, User user) throws Exception {
        Watchlist watchlist=findUserWatchList(user.getId());
        if(watchlist.getCoins().contains(coin)){
            watchlist.getCoins().remove(coin);
        } else watchlist.getCoins().add(coin);
        watchlistRepository.save(watchlist);
        return coin;
    }
}
