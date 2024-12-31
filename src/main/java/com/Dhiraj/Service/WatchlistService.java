package com.Dhiraj.Service;

import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Watchlist;

public interface WatchlistService {
    Watchlist findUserWatchList(Long userId) throws Exception;
    Watchlist createWatchList(User user);
    Watchlist findById(Long id) throws Exception;
    Coin addItemToWatchList(Coin coin,User user) throws Exception;
}
