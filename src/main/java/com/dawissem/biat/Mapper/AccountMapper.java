package com.dawissem.biat.Mapper;

import com.dawissem.biat.Dto.AccountDto;
import com.dawissem.biat.Dto.CustomerDto;
import com.dawissem.biat.Entity.Account;
import com.dawissem.biat.Entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AccountMapper {
    AccountDto toAccountDto(Account account);
    Account toAccount(AccountDto accountDto );
}
