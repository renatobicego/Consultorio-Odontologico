package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import com.example.ProyectorIntegradorRenatoBicego.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo saveOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public void deleteOdontologo(Long id){
        Optional<Odontologo> odontologo = findOdontologo(id);
        if (odontologo.isPresent()) { // verificar si el objeto odontologo existe
            odontologoRepository.deleteById(id);
        }
    }

    public List<Odontologo> findAllOdontologos(){
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> findOdontologo(Long id){
        return odontologoRepository.findById(id);
    }

    public Odontologo updateOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
}
