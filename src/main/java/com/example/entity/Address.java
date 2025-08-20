package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)   // Many addresses can belong to one user
    @JoinColumn(name = "user_id")
    private User user;
}

