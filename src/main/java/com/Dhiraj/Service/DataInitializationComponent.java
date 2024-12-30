package com.Dhiraj.Service;

import com.Dhiraj.Domain.USER_ROLE;
import com.Dhiraj.Models.User;
import com.Dhiraj.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializationComponent implements CommandLineRunner{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        intitializeAdminUser();
    }
    private void intitializeAdminUser(){
        String adminUsername="dk194945@gmail.com";
        if(userRepository.findByEmail(adminUsername)==null){
            User adminUser=new User();
            adminUser.setPassword(passwordEncoder.encode("Dhiraj@123"));
            adminUser.setFullName("Dheeraj");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(USER_ROLE.ROLE_ADMIN);
            User admin=userRepository.save(adminUser);
        }
    }
}
