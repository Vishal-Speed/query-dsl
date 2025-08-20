package com.example.dto;


import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequest {
    private String name;
    private int age;

    private Long departmentId;
    private List<AddressDto> addresses;
}
