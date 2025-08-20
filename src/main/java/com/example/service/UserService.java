package com.example.service;

import com.example.dto.CreateUserRequest;
import com.example.dto.UserDto;
import com.example.entity.Department;
import com.example.entity.User;
import com.example.entity.QUser;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.UserMapper;
import com.example.repository.AddressRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;

    public UserDto saveUser(CreateUserRequest createUserRequest) {
        Long departmentId = createUserRequest.getDepartmentId();
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        User entity = userMapper.toEntity(createUserRequest);
        entity.setDepartment(department);
        log.info("Saving user: {}", entity);
        return userMapper.toDto(userRepository.save(entity));
    }

    public List<UserDto> findUserByNameAndMinAge(String name, Integer minAge) {
       return userRepository.findUserByNameAndAge(name, minAge).stream().map(userMapper::toDto).toList();
    }

    public List<UserDto> findByName(String name) {
        return userRepository.findByName(name).stream().map(userMapper::toDto).toList();
    }

    public List<UserDto> findAdults(){
        return userRepository.findAdults().stream().map(userMapper::toDto).toList();
    }
}
