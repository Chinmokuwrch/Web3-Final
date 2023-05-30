package com.silence.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silence.crm.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
