package com.example.SpringBootLivraria.controller;

import com.example.SpringBootLivraria.dto.AtorRecordDto;
import com.example.SpringBootLivraria.dto.BookRecordDto;
import com.example.SpringBootLivraria.model.AtorModel;
import com.example.SpringBootLivraria.responseDelete.ApiResponse;
import com.example.SpringBootLivraria.service.AtorService;
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
@RequestMapping({"/ators","/ators/"})
public class AtorController {

    private final AtorService atorService;

    @Autowired
    public AtorController(AtorService atorService){
        this.atorService = atorService;
    }

    @GetMapping
    public ResponseEntity<List<AtorModel>> findAllAtor(){
        List<AtorModel> atorModelList = atorService.findALl();

        if (!atorModelList.isEmpty()){
            for (AtorModel am : atorModelList){
                am.add(linkTo(methodOn(AtorController.class).findByIdAtor(am.getId())).withRel("Ator: "));
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(atorModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorModel> findByIdAtor(@PathVariable(value = "id")UUID id){
        AtorModel atorModel = atorService.findById(id);

        atorModel.add(linkTo(methodOn(AtorController.class).findAllAtor()).withRel("Ator List: "));

        return ResponseEntity.status(HttpStatus.OK).body(atorModel);
    }

    @PostMapping
    public ResponseEntity<AtorModel> saveAtor(@RequestBody @Valid AtorRecordDto atorRecordDto){

        AtorModel atorModel = new AtorModel();

        BeanUtils.copyProperties(atorRecordDto,atorModel);
        atorService.save(atorModel);

        atorModel.add(linkTo(methodOn(AtorController.class).findByIdAtor(atorModel.getId())).withRel("Ator: "));

        return ResponseEntity.status(HttpStatus.CREATED).body(atorModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtorModel> updateAtor(@PathVariable(value = "id") UUID id, @RequestBody @Valid AtorRecordDto atorRecordDto){

        AtorModel atorModel = atorService.findById(id);

        BeanUtils.copyProperties(atorRecordDto,atorModel);

        atorService.update(atorModel);

        atorModel.add(linkTo(methodOn(AtorController.class).findByIdAtor(id)).withRel("Ator: "));

        return ResponseEntity.status(HttpStatus.OK).body(atorModel);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAtor(@PathVariable(value = "id") UUID id){

        ApiResponse apiResponse = new ApiResponse("Ator deleted successfully", linkTo(methodOn(AtorController.class).findAllAtor()).withRel("Ators List: "));

        atorService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
