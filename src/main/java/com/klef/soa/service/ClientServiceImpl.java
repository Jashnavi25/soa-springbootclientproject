package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Client;
import com.klef.soa.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService
{
	@Autowired
	private ClientRepository repo;

	@Override
	public Client addClient(Client client) 
	{
		return repo.save(client);
	}

	@Override
	public List<Client> displayAllClients() 
	{
		return repo.findAll();
	}

	@Override
	public Client updateClient(Client c) 
	{
		Optional<Client> optional = repo.findById(c.getClientId());
		if(optional.isPresent())
		{
			Client client = optional.get();
			
			client.setName(c.getName());
			client.setType(c.getType());
			client.setStatus(c.isStatus());
			client.setLocation(c.getLocation());
			
			return repo.save(client);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Client displayClientById(Long id) 
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteClientById(Long id) 
	{
		boolean status = repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);
			return "Client Deleted Successfully";
		}
		else
		{
			return "Client ID Not Found";
		}
	}

	@Override
	public List<Client> displayClientsByName(String name) 
	{
		return repo.findByName(name);
	}

	@Override
	public List<Client> displayClientsByType(String type) 
	{
		return repo.findByType(type);
	}
}