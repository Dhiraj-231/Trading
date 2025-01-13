package com.Dhiraj.Service.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.Dhiraj.Domain.WithdrawalStatus;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.Withdrawal;
import com.Dhiraj.Repository.WithdrawalRepository;
import com.Dhiraj.Service.WithdrawalService;

@Service
@AllArgsConstructor
public class WithdrawalServiceImpl implements WithdrawalService {

    private final WithdrawalRepository withdrawalRepository;

    @Override
    public List<Withdrawal> getAllWithdrawalRequest() {
        return withdrawalRepository.findAll();
    }

    @Override
    public List<Withdrawal> getUsersWithdrawalHistory(User user) {

        return withdrawalRepository.findByUserId(user.getId());
    }

    @Override
    public Withdrawal procedWithdrawal(Long withdrawalId, boolean accept) throws Exception {
        Optional<Withdrawal> withdrawalOptional = withdrawalRepository.findById(withdrawalId);
        if (withdrawalOptional.isEmpty())
            throw new Exception("Withdrawal Id is Wrong.....");

        Withdrawal withdrawal = withdrawalOptional.get();
        withdrawal.setDate(LocalDateTime.now());

        if (accept) {
            withdrawal.setStatus(WithdrawalStatus.SUCCESS);
        } else {
            withdrawal.setStatus(WithdrawalStatus.DECLINE);
        }
        return withdrawalRepository.save(withdrawal);
    }

    @Override
    public Withdrawal requestWithdrawal(Long amount, User user) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(amount);
        withdrawal.setStatus(WithdrawalStatus.PENDING);
        withdrawal.setDate(LocalDateTime.now());
        withdrawal.setUser(user);
        return withdrawalRepository.save(withdrawal);
    }

}
