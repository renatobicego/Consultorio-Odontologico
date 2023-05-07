package com.example.ProyectorIntegradorRenatoBicego.controllers;

import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.services.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    private final PacienteService pacienteService;
    private static final Logger logger = Logger.getLogger(PacienteController.class);


    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping("/{id}")
    public Optional<Paciente> buscar(@PathVariable Long id) throws Exception {
        logger.info("Buscando paciente");

        return pacienteService.findPaciente(id);
    }

    @GetMapping
    @ResponseBody
    public List<Paciente> buscarTodos() throws Exception {
        logger.info("Buscando todos los pacientes");
        return pacienteService.findAllPacientes();
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente) throws Exception {
        logger.info("Registrando paciente");
        return pacienteService.savePaciente(paciente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable Long id) throws Exception {
        ResponseEntity<HttpStatus> response = null;
        logger.info("Borrando paciente");
        if(pacienteService.findPaciente(id).isEmpty()){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            pacienteService.deletePaciente(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) throws Exception {
        ResponseEntity<Paciente> response = null;
        logger.info("Actualizando paciente");

        if(pacienteService.findPaciente(paciente.getId()).isEmpty()){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            response = new ResponseEntity<>(pacienteService.updatePaciente(paciente), HttpStatus.OK);
        }
        return response;
    }
}
