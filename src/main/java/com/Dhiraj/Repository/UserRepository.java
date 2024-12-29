package com.Dhiraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dhiraj.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
