package com.klef.soa.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Client;
import com.klef.soa.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController
{
	@Autowired
	private ClientService service;

	@GetMapping("/")
	public String test()
	{
		return "SOA Programming & MicroServices";
	}

	// Add Client
	@PostMapping("/add") 
	public ResponseEntity<Client> addClient(@RequestBody Client c) 
	{ 
		Client client = service.addClient(c); 
		return ResponseEntity.status(201).body(client); 
	}

	// Display All Clients
	@GetMapping("/displayall")
	public ResponseEntity<List<Client>> displayAllClients()
	{
		List<Client> clients = service.displayAllClients(); 
		return ResponseEntity.status(200).body(clients);
	}

	// Display Client By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayClientById(@RequestParam Long id)
	{
		Client client = service.displayClientById(id);

		if(client != null)
		{
			return ResponseEntity.status(200).body(client);
		}
		else
		{
			return ResponseEntity.status(404).body("Client ID Not Found");
		}
	}

	// Update Client
	@PutMapping("/update")
	public ResponseEntity<?> updateClient(@RequestBody Client client)
	{
		Client c = service.updateClient(client);

		if(c != null)
		{
			return ResponseEntity.ok(c);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client ID Not Found");
		}
	}

	// Delete Client By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClientById(@PathVariable Long id)
	{
		String message = service.deleteClientById(id);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Clients By Name
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Client>> displayClientsByName(@PathVariable String name)
	{
		List<Client> clients = service.displayClientsByName(name);
		return ResponseEntity.status(200).body(clients);
	}

	// Display Clients By Type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Client>> displayClientsByType(@PathVariable String type)
	{
		List<Client> clients = service.displayClientsByType(type);
		return ResponseEntity.status(200).body(clients);
	}
}