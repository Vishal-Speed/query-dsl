package com.example.mapper;

import com.example.dto.AddressDto;
import com.example.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "user.userId",target = "userId")
    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);
}
