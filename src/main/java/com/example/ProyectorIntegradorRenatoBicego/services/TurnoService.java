package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.exceptions.BadRequestException;
import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.models.Turno;
import com.example.ProyectorIntegradorRenatoBicego.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;

    public Turno saveTurno(Turno turno) throws BadRequestException{
        if(turno.getPaciente() == null || turno.getOdontologo() == null){
            throw new BadRequestException("Paciente y Odontologo no pueden ser nulos");
        } else if (!pacienteOdontologoExists(turno.getPaciente(), turno.getOdontologo())) {
            throw new BadRequestException("Paciente u Odontologo no existen en la base de datos. \n" +
                    "Id paciente: " + turno.getPaciente().getId() + "\n" +
                    "Id odontologo: " + turno.getOdontologo().getId());
        }
        return turnoRepository.save(turno);
    }

    public void deleteTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public List<Turno> findAllTurnos(){
        return turnoRepository.findAll();
    }

    public Optional<Turno> findTurno(Long id){
        return turnoRepository.findById(id);
    }

    public Turno updateTurno(Turno turno) throws BadRequestException {
        if(turno.getPaciente() == null || turno.getOdontologo() == null){
            throw new BadRequestException("Paciente y Odontologo no pueden ser nulos");
        } else if (!pacienteOdontologoExists(turno.getPaciente(), turno.getOdontologo())) {
            throw new BadRequestException("Paciente u Odontologo no existen en la base de datos. \n" +
                    "Id paciente: " + turno.getPaciente().getId() + "\n" +
                    "Id odontologo: " + turno.getOdontologo().getId());
        }
        return turnoRepository.save(turno);
    }

    private boolean pacienteOdontologoExists(Paciente paciente, Odontologo odontologo){
        return
                pacienteService.findPaciente(paciente.getId()).isPresent() &&
                odontologoService.findOdontologo(odontologo.getId()).isPresent();
    }
}
