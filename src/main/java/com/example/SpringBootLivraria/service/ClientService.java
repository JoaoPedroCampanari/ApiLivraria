package com.example.SpringBootLivraria.service;

import com.example.SpringBootLivraria.model.ClientModel;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientModel findById(UUID id);

    List<ClientModel> findALl();

    ClientModel save (ClientModel clientModel);

    ClientModel update(ClientModel clientModel);

    void deleteById(UUID id);

    List<ClientModel> saveAllClients(List<ClientModel> clientModelList);
}
