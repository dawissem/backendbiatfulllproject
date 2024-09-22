package com.dawissem.biat.Controller;

import com.dawissem.biat.Dto.CustomerDto;
import com.dawissem.biat.Entity.Country;
import com.dawissem.biat.Mapper.CustomerMapper;
import com.dawissem.biat.Repository.CountryRepository;
import com.dawissem.biat.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/country")
@AllArgsConstructor
public class CountryController {
    private final CountryRepository countryRepo;

    @GetMapping("/all")
    public List<Country> getAllCountrys() {

        return  countryRepo.findAll();
    }
}
