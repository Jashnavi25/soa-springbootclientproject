package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.*;
import com.klef.soa.entity.*;
import com.klef.soa.repository.*;

@DataJpaTest	// applied on repository layer
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest 
{
	    @Autowired
	    private ClientRepository repository;

	    @Test
	    void testFindAllClients() 
	    {
	        List<Client> clients = repository.findAll();
	        assertNotNull(clients);
	        assertFalse(clients.isEmpty());
	        System.out.println("Total Users: " + clients.size());
	    }

	    @Test
	    void testFindClientById() 
	    {
	        Optional<Client> client = repository.findById(1L);
	        assertTrue(client.isPresent());
	        assertEquals(1L, client.get().getClientId());
	        System.out.println("User ID: " + client.get().getClientId());
	        System.out.println("Name: " + client.get().getName());
	    }

//	    @Test
//	    void testFindClientByName() 
//	    {
//	        List<Client> client = repository.findByName("admin");
//	        assertTrue(client.isPresent));
//	        assertEquals("admin", client.getName());
//	        System.out.println("Name: " + client.getName());
//	    }

	    @Test
	    void testClientDetails() 
	    {
	        Optional<Client> client = repository.findById(17L);
	        assertTrue(client.isPresent());
	        Client foundUser = client.get();
	        assertNotNull(foundUser.getName());
	        assertNotNull(foundUser.getType());
	        assertNotNull(foundUser.getLocation());
	        assertNotNull(foundUser.getCreatedAt());
	        assertNotNull(foundUser.getUpdatedAt());
	        System.out.println("Name: " + foundUser.getName());
	        System.out.println("Type: " + foundUser.getType());
	        System.out.println("Location: " + foundUser.getLocation());
	    }

	    @Test
	    void testTotalClientCount() 
	    {
	        long count = repository.count();
	        assertEquals(1L, count);
	    }
}
