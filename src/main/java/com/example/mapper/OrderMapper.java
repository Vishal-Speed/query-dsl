package com.example.mapper;

import com.example.dto.OrderDto;
import com.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "user.userId", target = "userId")
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);

}
