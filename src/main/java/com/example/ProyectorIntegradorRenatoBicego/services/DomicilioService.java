package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.models.Domicilio;
import com.example.ProyectorIntegradorRenatoBicego.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService  {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public Domicilio saveDomicilio(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }

    public void deleteDomicilio(Long id){
        domicilioRepository.deleteById(id);
    }

    public List<Domicilio> findAllDomicilios(){
        return domicilioRepository.findAll();
    }

    public Optional<Domicilio> findDomicilio(Long id){
        return domicilioRepository.findById(id);
    }

    public Domicilio updateDomicilio(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }
}
