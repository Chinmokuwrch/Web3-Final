package com.silence.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.silence.crm.model.Vendedor;
import com.silence.crm.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<Vendedor> listar(){
		return vendedorRepository.findAll();
		}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor adicionar(@RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@DeleteMapping("/vendedores/{id}")
	void deleteVendedor(@PathVariable Long id) {
		vendedorRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Vendedor> update(@PathVariable Long id, @RequestBody Vendedor vendedor){
	if(!vendedorRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	vendedor.setId(id);
	vendedor = vendedorRepository.save(vendedor);
	return ResponseEntity.ok(vendedor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!vendedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		vendedorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		}
}
