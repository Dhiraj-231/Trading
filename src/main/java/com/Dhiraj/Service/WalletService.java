package com.Dhiraj.Service;

import com.Dhiraj.Exception.WalletException;
import com.Dhiraj.Models.Order;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Wallet;

public interface WalletService {
    Wallet getUserWallet(User user) throws WalletException;
    Wallet addBalanceToWallet(Wallet wallet,Long money) throws WalletException;
    Wallet findWalletById(Long id) throws WalletException;
    Wallet walletToWalletTransfer(User sender,Wallet receiverWallet,Long amount) throws WalletException;
    Wallet payOrderPayment(Order order,User user) throws WalletException;
}
