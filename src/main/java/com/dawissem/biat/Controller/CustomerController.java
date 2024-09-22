package com.dawissem.biat.Controller;

import com.dawissem.biat.Dto.CustomerDto;
import com.dawissem.biat.Dto.UserDto;
import com.dawissem.biat.Entity.Customer;
import com.dawissem.biat.Entity.User;
import com.dawissem.biat.Enum.CustomerEnum;
import com.dawissem.biat.Enum.GenderEnum;
import com.dawissem.biat.Exception.AlreadyExistsException;
import com.dawissem.biat.Exception.UserNotFoundException;
import com.dawissem.biat.Mapper.CustomerMapper;
import com.dawissem.biat.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
@AllArgsConstructor

public class CustomerController {

    private final CustomerRepository customerRepo;
    private final CustomerMapper customerMapper;

    @GetMapping("/all")
    public List<CustomerDto> getAllCustomers() {

        return  customerRepo.findAll().stream().map(customerMapper::toCustomerDto).toList();
    }
    @GetMapping("/filter")
    public List<CustomerDto> filterCustomers(
            @RequestParam(required = false) String shortName,
            @RequestParam(required = false) String legalId,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) GenderEnum gender,
            @RequestParam(required = false) CustomerEnum customerType) {

        return customerRepo.findByCriteria(shortName, legalId, nationality, gender, customerType).stream().map(customerMapper::toCustomerDto).toList();

    }
    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerRepo.findByLegalId(customer.getLegalId());
        if (existingCustomer.isPresent()) {
            throw new AlreadyExistsException("customer Already Exists");
        }
        customerRepo.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer added successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer>o= customerRepo.findById(id);
        if(o.isEmpty())
            throw new UserNotFoundException("Customer not found");
        Customer customer=o.get();
        Optional<Customer> existingCustomer = customerRepo.findByLegalId(customerDetails.getLegalId());
        if (existingCustomer.isPresent()&& !Objects.equals(customerDetails.getLegalId(), customer.getLegalId())) {
            throw new AlreadyExistsException("customer Already Exists");
        }
        customer.setCustomerType(customerDetails.getCustomerType());
        customer.setShortName(customerDetails.getShortName());
        customer.setGender(customerDetails.getGender());
        customer.setDateBirthCreation(customerDetails.getDateBirthCreation());
        customer.setAddress(customerDetails.getAddress());
        customer.setPostCode(customerDetails.getPostCode());
        customer.setLegalDocName(customerDetails.getLegalDocName());
        customer.setLegalId(customerDetails.getLegalId());
        customer.setTel(customerDetails.getTel());
        customer.setMail(customerDetails.getMail());
        customer.setAgence(customerDetails.getAgence());
        customer.setNationality(customerDetails.getNationality());





        customerRepo.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer updated successfully");



    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isEmpty()) {
            throw new UserNotFoundException("Customer not found");
        }
        customerRepo.deleteById(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
