package com.Dhiraj.Service;

import com.Dhiraj.Models.CoinDTO;
import com.Dhiraj.Response.ApiResponse;

public interface ChatBotService {
    
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}
