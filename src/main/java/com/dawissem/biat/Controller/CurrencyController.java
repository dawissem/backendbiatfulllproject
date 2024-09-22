package com.dawissem.biat.Controller;

import com.dawissem.biat.Entity.Country;
import com.dawissem.biat.Entity.Currency;
import com.dawissem.biat.Repository.CountryRepository;
import com.dawissem.biat.Repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/currency")
@AllArgsConstructor
public class CurrencyController {
    private final CurrencyRepository currencyRepo;

    @GetMapping("/all")
    public List<Currency> getAllCurrencys() {

        return  currencyRepo.findAll();
    }
}
