package com.Dhiraj.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Exception.UserException;
import com.Dhiraj.Models.User;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws UserException;

    public User findUserByEmail(String email) throws UserException;

    public User findUserById(Long userId) throws UserException;

    public User verifyUser(User user) throws UserException;

    public User enabledTwoFactorAuthentication(VerificationType verificationType,
            String sendTo, User user) throws UserException;

    User updatePassword(User user, String newPassword);

}
