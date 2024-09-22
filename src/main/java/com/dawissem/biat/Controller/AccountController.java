package com.dawissem.biat.Controller;

import com.dawissem.biat.Dto.AccountDto;
import com.dawissem.biat.Entity.Account;
import com.dawissem.biat.Entity.User;
import com.dawissem.biat.Enum.CategoryAccount;
import com.dawissem.biat.Exception.AlreadyExistsException;
import com.dawissem.biat.Exception.UserNotFoundException;
import com.dawissem.biat.Mapper.AccountMapper;
import com.dawissem.biat.Mapper.CustomerMapper;
import com.dawissem.biat.Repository.AccountRepository;
import com.dawissem.biat.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {
    private final AccountRepository accountRepo;
    private final AccountMapper accountMapper;


    @GetMapping("/all")
    public List<AccountDto> getAllAccounts() {

        return  accountRepo.findAll().stream().map(accountMapper::toAccountDto).toList();
    }
    @GetMapping("/filter")
    public List<AccountDto> filterAccounts(
            @RequestParam(required = false) String accountTitle,
            @RequestParam(required = false) CategoryAccount category,
            @RequestParam(required = false) Date openingDate) {

        return accountRepo.findByCriteria(accountTitle, category, openingDate).stream().map(accountMapper::toAccountDto).toList();

    }
    @PostMapping("/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        Optional<Account> existingAccount = accountRepo.findByAccountTitle(account.getAccountTitle());
        if (existingAccount.isPresent()) {
            throw new AlreadyExistsException("account Already Exists");
        }
        accountRepo.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account added successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        Optional<Account >o= accountRepo.findById(id);
        if(o.isEmpty())
            throw new UserNotFoundException("Account not found");
        Account account=o.get();
        Optional<Account> existingAccount = accountRepo.findByAccountTitle(accountDetails.getAccountTitle());
        if (existingAccount.isPresent()  && !Objects.equals(account.getAccountTitle(), accountDetails.getAccountTitle())) {
            throw new AlreadyExistsException("account Already Exists");
        }

        account.setAccountTitle(accountDetails.getAccountTitle());
        account.setCategory(accountDetails.getCategory());
        account.setWorkingBalance(accountDetails.getWorkingBalance());
        account.setOpeningDate(accountDetails.getOpeningDate());
        account.setClosureDate(accountDetails.getClosureDate());
        account.setCustomer(accountDetails.getCustomer());
        account.setAccountOfficer(accountDetails.getAccountOfficer());
        account.setCurrency(accountDetails.getCurrency());




        accountRepo.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account updated successfully");



    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        Optional<Account> account = accountRepo.findById(id);
        if (account.isEmpty()) {
            throw new UserNotFoundException("Account not found");
        }
        accountRepo.deleteById(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
