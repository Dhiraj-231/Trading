package com.Dhiraj.Service.ServiceImp;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Dhiraj.Config.JwtProvider;
import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Exception.UserException;
import com.Dhiraj.Models.TwoFactorAuth;
import com.Dhiraj.Models.User;
import com.Dhiraj.Repository.UserRepository;
import com.Dhiraj.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User enabledTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user)
            throws UserException {
        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);

        user.setTwoFactorAuth(twoFactorAuth);
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) throws UserException {
        User user = userRepository.findByEmail(email);

        if (user != null) {

            return user;
        }

        throw new UserException("user not exist with username " + email);
    }

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> opt = userRepository.findById(userId);

        if (opt.isEmpty()) {
            throw new UserException("user not found with id " + userId);
        }
        return opt.get();
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = JwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserException("user not exist with email " + email);
        }
        return user;
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }

    @Override
    public User verifyUser(User user) throws UserException {
        user.setVerified(true);
        return userRepository.save(user);
    }

}
