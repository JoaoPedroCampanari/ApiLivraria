package com.example.SpringBootLivraria.controller;

import com.example.SpringBootLivraria.dto.ClientRecordDto;
import com.example.SpringBootLivraria.model.ClientModel;
import com.example.SpringBootLivraria.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto recordDto){
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(recordDto,clientModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }
}
