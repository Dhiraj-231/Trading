package com.Dhiraj.Repository;

import com.Dhiraj.Models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist,Long> {
    Watchlist findUserId(Long userId);
}
