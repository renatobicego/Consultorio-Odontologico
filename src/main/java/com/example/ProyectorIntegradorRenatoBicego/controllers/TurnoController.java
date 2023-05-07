package com.example.ProyectorIntegradorRenatoBicego.controllers;

import com.example.ProyectorIntegradorRenatoBicego.exceptions.BadRequestException;
import com.example.ProyectorIntegradorRenatoBicego.models.Turno;
import com.example.ProyectorIntegradorRenatoBicego.services.OdontologoService;
import com.example.ProyectorIntegradorRenatoBicego.services.PacienteService;
import com.example.ProyectorIntegradorRenatoBicego.services.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;
    private static final Logger logger = Logger.getLogger(TurnoController.class);


    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}")
    public Optional<Turno> buscar(@PathVariable Long id) throws Exception {
        logger.info("Buscando turno");
        return turnoService.findTurno(id);
    }

    @GetMapping
    @ResponseBody
    public List<Turno> buscarTodos() throws Exception {
        logger.info("Buscando todos los turnos");
        return turnoService.findAllTurnos();
    }

    @PostMapping
    public ResponseEntity<Turno> registrar(@RequestBody Turno turno) throws BadRequestException {
        logger.info("Registrando turno");
        return new ResponseEntity<>(turnoService.saveTurno(turno),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) throws Exception {
        logger.info("Borrando turno");
        turnoService.deleteTurno(id);
    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) throws BadRequestException {
        logger.info("Actualizando turno");
        return new ResponseEntity<>(turnoService.updateTurno(turno), HttpStatus.OK);
    }
}
