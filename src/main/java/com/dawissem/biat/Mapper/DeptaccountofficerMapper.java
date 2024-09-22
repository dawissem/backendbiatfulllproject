package com.dawissem.biat.Mapper;

import com.dawissem.biat.Dto.DeptaccountofficerDto;
import com.dawissem.biat.Dto.UserDto;
import com.dawissem.biat.Entity.Deptaccountofficer;
import com.dawissem.biat.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DeptaccountofficerMapper {
   DeptaccountofficerDto toDeptaccountofficerDto(Deptaccountofficer deptaccountofficer);
   Deptaccountofficer toDeptaccountofficer(DeptaccountofficerDto deptaccountofficerDto );
}
