package com.Dhiraj.Service;
import com.Dhiraj.Models.Withdrawal;
import com.Dhiraj.Models.User;

import java.util.List;

public interface WithdrawalService {
    Withdrawal requestWithdrawal(Long amount,User user);
    Withdrawal procedWithdrawal(Long withdrawalId,boolean accept) throws Exception;
    List<Withdrawal> getUsersWithdrawalHistory(User user);
    List<Withdrawal> getAllWithdrawalRequest();
}
