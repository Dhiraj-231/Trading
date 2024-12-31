package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Watchlist;
import com.Dhiraj.Service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService {
    @Override
    public Watchlist findUserWatchList(Long userId) throws Exception {
        return null;
    }

    @Override
    public Watchlist createWatchList(User user) {
        return null;
    }

    @Override
    public Watchlist findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Coin addItemToWatchList(Coin coin, User user) throws Exception {
        return null;
    }
}
