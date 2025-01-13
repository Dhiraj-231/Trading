package com.Dhiraj.Service;

import com.Dhiraj.Models.PaymentDetails;
import com.Dhiraj.Models.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderNumber, String ifscCode,
            String bankName, User user) throws Exception;

    public PaymentDetails getUsersPaymentDetails(User user);

}
