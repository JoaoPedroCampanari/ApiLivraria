package com.example.SpringBootLivraria.service.impl;

import com.example.SpringBootLivraria.exception.exceptions.AtorNotFoundException;
import com.example.SpringBootLivraria.exception.exceptions.EmailAlreadyExistException;
import com.example.SpringBootLivraria.exception.exceptions.NameAlreadyExistException;
import com.example.SpringBootLivraria.model.AtorModel;
import com.example.SpringBootLivraria.repository.AtorRepository;
import com.example.SpringBootLivraria.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AtorServiceImpl implements AtorService {

    private final AtorRepository atorRepository;

    @Autowired
    public AtorServiceImpl(AtorRepository atorRepository){
        this.atorRepository = atorRepository;
    }

    @Override
    public AtorModel findById(UUID id) {
        return atorRepository.findById(id).orElseThrow(() -> new AtorNotFoundException("This Ator ID doesn't exist! " + id));
    }

    @Override
    public List<AtorModel> findALl() {

        if (atorRepository.findAll().isEmpty()){
            throw new AtorNotFoundException("No Ators found. Please ensure that there are ators registered in the system.");
        }

        return atorRepository.findAll();
    }

    @Override
    public AtorModel save(AtorModel atorModel) {
        if (atorRepository.existsByNome(atorModel.getNome())){
            throw new NameAlreadyExistException("This Ator name already exist! " + atorModel.getNome());
        }
        if (atorRepository.existsByEmail(atorModel.getEmail())){
            throw new EmailAlreadyExistException("This Ator email already exist!");
        }

        return atorRepository.save(atorModel);
    }

    @Override
    public AtorModel update(AtorModel atorModel) {

        if (!atorRepository.existsById(atorModel.getId())){
            throw new AtorNotFoundException("This Ator ID doesn't exist! " + atorModel.getId());
        }

        return atorRepository.save(atorModel);
    }

    @Override
    public void deleteById(UUID id) {

        if (!atorRepository.existsById(id)){
            throw new AtorNotFoundException("This Ator ID doesn't exist! " + id);
        }

        atorRepository.deleteById(id);
    }
}
