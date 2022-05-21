package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Integer> {

}
