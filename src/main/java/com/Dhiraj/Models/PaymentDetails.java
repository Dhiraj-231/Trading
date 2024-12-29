package com.Dhiraj.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;
    private String accountHolderName;
    private String ifsc;
    private String bankName;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private User user;
}
