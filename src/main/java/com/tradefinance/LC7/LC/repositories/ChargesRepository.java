package com.tradefinance.LC7.LC.repositories;

import com.tradefinance.LC7.LC.Entities.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargesRepository extends JpaRepository<Charges,Long> {
}
