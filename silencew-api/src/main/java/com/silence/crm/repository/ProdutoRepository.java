package com.silence.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silence.crm.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
