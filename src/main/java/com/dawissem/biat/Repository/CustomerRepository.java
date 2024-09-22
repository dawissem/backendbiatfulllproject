package com.dawissem.biat.Repository;

import com.dawissem.biat.Entity.Customer;
import com.dawissem.biat.Enum.CustomerEnum;
import com.dawissem.biat.Enum.GenderEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM Customer c WHERE "
            + "(:name IS NULL OR LOWER(c.shortName) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
            + "(:legalId IS NULL OR c.legalId = :legalId) AND "
            + "(:nationality IS NULL OR c.nationality.name = :nationality) AND "
            + "(:gender IS NULL OR c.gender = :gender) AND "
            + "(:type IS NULL OR c.customerType = :type)")
    List<Customer> findByCriteria(
            @Param("name") String name,
            @Param("legalId") String legalId,
            @Param("nationality") String nationality,
            @Param("gender") GenderEnum gender,
            @Param("type") CustomerEnum type);

    Optional<Customer> findByLegalId(String legalId);
}

