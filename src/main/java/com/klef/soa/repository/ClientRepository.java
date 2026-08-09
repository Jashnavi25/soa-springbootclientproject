package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>
{
	// Derived Query Method 1
	// from Client c where c.name=?1
	List<Client> findByName(String name);

	// Derived Query Method 2
	// from Client c where c.type=?1
	List<Client> findByType(String type);
}