package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.entity.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer>{

}
