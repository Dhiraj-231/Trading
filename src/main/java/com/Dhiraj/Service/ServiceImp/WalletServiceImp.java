package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Exception.WalletException;
import com.Dhiraj.Models.Order;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Wallet;
import com.Dhiraj.Service.WalletService;

public class WalletServiceImp implements WalletService {
    @Override
    public Wallet getUserWallet(User user) throws WalletException {
        return null;
    }

    @Override
    public Wallet addBalanceToWallet(Wallet wallet, Long money) throws WalletException {
        return null;
    }

    @Override
    public Wallet findWalletById(Long id) throws WalletException {
        return null;
    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws WalletException {
        return null;
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) throws WalletException {
        return null;
    }
}
