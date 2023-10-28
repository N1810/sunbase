package com.neeraj.Sunbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.Sunbase.Entity.Customer;

public interface Costumerrepository extends JpaRepository<Customer, Long> {

}
