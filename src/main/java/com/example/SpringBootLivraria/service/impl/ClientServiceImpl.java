package com.example.SpringBootLivraria.service.impl;

import com.example.SpringBootLivraria.exception.exceptions.ClientNotFoundException;
import com.example.SpringBootLivraria.exception.exceptions.CpfAlreadyExistsException;
import com.example.SpringBootLivraria.model.ClientModel;
import com.example.SpringBootLivraria.repository.ClientRepository;
import com.example.SpringBootLivraria.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ClientModel> findALl() {

        List<ClientModel> clientModelList = clientRepository.findAll();

        if (clientModelList.isEmpty()){
            throw new ClientNotFoundException("No clients found. Please ensure that there are clients registered in the system.");
        }
        return clientModelList;
    }

    @Override
    public ClientModel save(ClientModel clientModel) {

        if (clientRepository.existsByCPF(clientModel.getCPF())){
            throw new CpfAlreadyExistsException("This CPF already exist!");
        }

        return clientRepository.save(clientModel);
    }

    @Override
    public ClientModel update(ClientModel clientModel) {
        if (!clientRepository.existsById(clientModel.getId())){
            throw new ClientNotFoundException("This client ID doesn't exist! " + clientModel.getId());
        }
        return clientRepository.save(clientModel);
    }

    @Override
    public void deleteById(UUID id) {
        if (!clientRepository.existsById(id)){
            throw new ClientNotFoundException("This Client ID: " + id  + " doesn't exist!");
        }

        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientModel> saveAllClients(List<ClientModel> clientModelList) {
        List<ClientModel> clientModerate = new ArrayList<>();

        if (clientModelList.isEmpty()){
            throw new ClientNotFoundException("This list is empty!");
        }

        for (ClientModel c: clientModelList){

            if (clientRepository.existsByCPF(c.getCPF())){
                throw new CpfAlreadyExistsException("This CPF already exist! " + c.getCPF());
            }
            ClientModel clientModel = new ClientModel();

            BeanUtils.copyProperties(c,clientModel);

            clientModerate.add(clientModel);
        }

        return clientRepository.saveAll(clientModerate);
    }
}
