package com.example.SpringBootLivraria.controller;

import com.example.SpringBootLivraria.responseDelete.ApiResponse;
import com.example.SpringBootLivraria.dto.ClientRecordDto;
import com.example.SpringBootLivraria.model.ClientModel;
import com.example.SpringBootLivraria.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

        clientService.save(clientModel);

        clientModel.add(linkTo(methodOn(ClientController.class).findByIdClient(clientModel.getId())).withRel("Client:"));

        return ResponseEntity.status(HttpStatus.CREATED).body(clientModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> findByIdClient(@PathVariable(value = "id") UUID id){

        ClientModel clientModel = clientService.findById(id);
        clientModel.add(linkTo(methodOn(ClientController.class).findAllClients()).withRel("Clients List"));

        return ResponseEntity.status(HttpStatus.OK).body(clientModel);
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> findAllClients(){
        List<ClientModel> clientModelList = clientService.findALl();
        if (!clientModelList.isEmpty()){
            for (ClientModel client: clientModelList){
                UUID id = client.getId();
                client.add(linkTo(methodOn(ClientController.class).findByIdClient(id)).withRel("Client"));
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientModelList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteByIdClient(@PathVariable(value = "id") UUID id){
        clientService.deleteById(id);

        ApiResponse response = new ApiResponse("Product deleted successfully", linkTo(methodOn(ClientController.class).findAllClients()).withRel("Clients List"));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> updateById(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClientRecordDto clientRecordDto ){
        ClientModel clientModel = clientService.findById(id);
        BeanUtils.copyProperties(clientRecordDto,clientModel);

        clientService.update(clientModel);
        clientModel.add(linkTo(methodOn(ClientController.class).findByIdClient(id)).withRel("Client: "));

        return ResponseEntity.status(HttpStatus.OK).body(clientModel);
    }

}
