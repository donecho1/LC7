package com.tradefinance.LC7.LC.repositories;

import com.tradefinance.LC7.LC.Entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}
