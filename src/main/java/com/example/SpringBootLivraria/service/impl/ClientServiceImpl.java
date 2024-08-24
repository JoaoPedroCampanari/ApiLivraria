package com.example.SpringBootLivraria.service.impl;

import com.example.SpringBootLivraria.exception.exceptions.ClientNotFoundException;
import com.example.SpringBootLivraria.exception.exceptions.CpfAlreadyExistsException;
import com.example.SpringBootLivraria.model.ClientModel;
import com.example.SpringBootLivraria.repository.ClientRepository;
import com.example.SpringBootLivraria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientModel findById(UUID id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));
    }

    @Override
    public List<ClientModel> findALl(UUID id) {
        return clientRepository.findAll();
    }

    @Override
    public ClientModel save(ClientModel clientModel) {

        if (clientRepository.existsByCPF(clientModel.getCPF())){
            throw new CpfAlreadyExistsException("This CPF already exist!");
        }

        return clientRepository.save(clientModel);
    }

    @Override
    public void deleteById(UUID id) {
        if (!clientRepository.existsById(id)){
            throw new ClientNotFoundException("This ID: " + id  + " doesn't exist!");
        }

        clientRepository.deleteById(id);
    }
}
