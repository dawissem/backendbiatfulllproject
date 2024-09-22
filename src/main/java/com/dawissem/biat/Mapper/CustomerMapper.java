package com.dawissem.biat.Mapper;

import com.dawissem.biat.Dto.CustomerDto;
import com.dawissem.biat.Dto.UserDto;
import com.dawissem.biat.Entity.Customer;
import com.dawissem.biat.Entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
    Customer toCustomer(CustomerDto customerDto );
}
