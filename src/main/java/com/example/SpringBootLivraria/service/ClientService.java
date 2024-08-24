package com.example.SpringBootLivraria.service;

import com.example.SpringBootLivraria.model.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    ClientModel findById(UUID id);

    List<ClientModel> findALl(UUID id);

    ClientModel save (ClientModel clientModel);

    void deleteById(UUID id);

}
