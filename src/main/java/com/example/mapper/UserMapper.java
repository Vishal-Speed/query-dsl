package com.example.mapper;

import com.example.dto.CreateUserRequest;
import com.example.dto.UserDto;
import com.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {AddressMapper.class,OrderMapper.class,DepartmentMapper.class})
public interface UserMapper {

    @Mapping(source = "department.departmentId", target = "departmentId")
    UserDto toDto(User user);


    User toEntity(CreateUserRequest createUserRequest);

    User toEntity(UserDto userDto);



}

