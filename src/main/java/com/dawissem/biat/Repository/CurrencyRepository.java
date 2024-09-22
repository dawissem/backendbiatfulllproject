package com.dawissem.biat.Repository;

import com.dawissem.biat.Entity.Country;
import com.dawissem.biat.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,String> {
}
