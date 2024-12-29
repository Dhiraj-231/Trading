package com.Dhiraj.Models;

import com.Dhiraj.Domain.USER_ROLE;
import com.Dhiraj.Domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private String mobile;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private UserStatus status = UserStatus.PENDING;

    private boolean isVerified = false;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

    private String picture;

    private USER_ROLE role = USER_ROLE.ROLE_USER;

}
