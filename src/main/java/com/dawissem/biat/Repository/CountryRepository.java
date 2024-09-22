
package com.dawissem.biat.Repository;

import com.dawissem.biat.Entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

}

