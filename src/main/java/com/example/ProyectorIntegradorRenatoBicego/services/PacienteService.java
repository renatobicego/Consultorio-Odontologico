package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DomicilioService domicilioService;

    public Paciente savePaciente(Paciente paciente){
        if(paciente.getDomicilio() != null){
            domicilioService.saveDomicilio(paciente.getDomicilio());
        }
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> findAllPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findPaciente(Long id){
        return pacienteRepository.findById(id);
    }

    public Paciente updatePaciente(Paciente paciente){
        domicilioService.saveDomicilio(paciente.getDomicilio());
        return pacienteRepository.save(paciente);
    }

    public void setDomicilioService(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }
}
