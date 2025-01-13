package com.Dhiraj.Service.ServiceImp;

import org.springframework.stereotype.Service;

import com.Dhiraj.Models.PaymentDetails;
import com.Dhiraj.Models.User;
import com.Dhiraj.Repository.PaymentDetailsRepository;
import com.Dhiraj.Service.PaymentDetailsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentDetailsServiceImp implements PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderNumber, String ifscCode,
            String bankName, User user) throws Exception {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAccountHolderName(accountHolderNumber);
        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setIfsc(ifscCode);
        paymentDetails.setBankName(bankName);
        paymentDetails.setUser(user);
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails getUsersPaymentDetails(User user) {
        return paymentDetailsRepository.getPaymentDetailsByUserId(user.getId());
    }

}
