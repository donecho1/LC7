package com.tradefinance.LC7.LC.repositories;

import com.tradefinance.LC7.LC.Entities.LetterOfCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterOfCreditRepository extends JpaRepository<LetterOfCredit,Long> {
    Optional<LetterOfCredit> findByLetterOfCreditNumber(String letterOfCreditNumber);
}

