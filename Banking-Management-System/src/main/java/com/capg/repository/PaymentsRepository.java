package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments,Integer> {

}
