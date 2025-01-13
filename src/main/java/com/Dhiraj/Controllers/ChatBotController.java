package com.Dhiraj.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dhiraj.Models.CoinDTO;
import com.Dhiraj.Request.PromptBody;
import com.Dhiraj.Response.ApiResponse;
import com.Dhiraj.Service.ChatBotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatBotService chatBotService;

    @GetMapping("/coin/{coinName}")
    public ResponseEntity<CoinDTO> getCoinDetails(@PathVariable String coinName) {

        CoinDTO coinDTO = chatBotService.getCoinByName(coinName);
        return new ResponseEntity<>(coinDTO, HttpStatus.OK);
    }

    @PostMapping("/bot")
    public ResponseEntity<String> simpleChat(@RequestBody PromptBody promptBody) {

        String res = chatBotService.simpleChat(promptBody.getPrompt());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/bot/coin")
    public ResponseEntity<ApiResponse> getCoinRealtimeTime(@RequestBody PromptBody promptBody) {

        ApiResponse res = chatBotService.getCoinDetails(promptBody.getPrompt());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
