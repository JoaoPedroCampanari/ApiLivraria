package com.example.SpringBootLivraria.controller;

import com.example.SpringBootLivraria.dto.ClientRecordDto;
import com.example.SpringBootLivraria.model.ClientModel;
import com.example.SpringBootLivraria.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto recordDto){
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(recordDto,clientModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> findByIdClient(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> findAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findALl());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByIdClient(@PathVariable(value = "id") UUID id){
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> updateById(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClientRecordDto clientRecordDto ){
        ClientModel clientModel = clientService.findById(id);
        BeanUtils.copyProperties(clientRecordDto,clientModel);

        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(clientModel));
    }

}
