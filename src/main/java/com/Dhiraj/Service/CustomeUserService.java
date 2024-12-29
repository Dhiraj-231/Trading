package com.Dhiraj.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomeUserService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
