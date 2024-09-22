package com.dawissem.biat.Repository;

import com.dawissem.biat.Entity.Account;
import com.dawissem.biat.Entity.Customer;
import com.dawissem.biat.Enum.CategoryAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("SELECT a FROM Account a WHERE "
            + "(:accountTitle IS NULL OR LOWER(a.accountTitle) LIKE LOWER(CONCAT('%', :accountTitle, '%'))) AND "
            + "(:category IS NULL OR a.category = :category) AND "
            + "(:openingDate IS NULL OR a.openingDate = :openingDate)")
    List<Account> findByCriteria(
            @Param("accountTitle") String accountTitle,
            @Param("category") CategoryAccount category,
            @Param("openingDate") Date openingDate);

    Optional<Account> findByAccountTitle(String accountTitle);
}
