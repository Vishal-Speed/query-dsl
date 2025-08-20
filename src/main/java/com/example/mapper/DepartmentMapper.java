package com.example.mapper;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;

public interface DepartmentMapper {

    DepartmentDto toDto(Department department);

    Department toEntity(DepartmentDto departmentDto);
}
