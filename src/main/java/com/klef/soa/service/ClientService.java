package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Client;

public interface ClientService 
{
	Client addClient(Client client);
	List<Client> displayAllClients();
	Client updateClient(Client c);
	Client displayClientById(Long id);
	String deleteClientById(Long id);
	List<Client> displayClientsByName(String name);
	List<Client> displayClientsByType(String type);
}