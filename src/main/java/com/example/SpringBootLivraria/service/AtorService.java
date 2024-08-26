package com.example.SpringBootLivraria.service;

import com.example.SpringBootLivraria.model.AtorModel;

import java.util.List;
import java.util.UUID;

public interface AtorService {

    AtorModel findById(UUID id);

    List<AtorModel> findALl();

    AtorModel save (AtorModel atorModel);

    AtorModel update(AtorModel atorModel);

    void deleteById(UUID id);
}
