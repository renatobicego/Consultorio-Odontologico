package com.example.ProyectorIntegradorRenatoBicego.controllers;

import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import com.example.ProyectorIntegradorRenatoBicego.services.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;
    private static final Logger logger = Logger.getLogger(OdontologoController.class);


    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> buscar(@PathVariable Long id) throws Exception {
        logger.info("Buscando odontologo");
        return odontologoService.findOdontologo(id);
    }

    @GetMapping
    @ResponseBody
    public List<Odontologo> buscarTodos() throws Exception {
        logger.info("Buscando todos los odontologos");
        return odontologoService.findAllOdontologos();
    }

    @PostMapping
    public Odontologo registrar(@RequestBody Odontologo odontologo) throws Exception {
        logger.info("Registrando odontologo");
        return odontologoService.saveOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable Long id) throws Exception {
        ResponseEntity<HttpStatus> response = null;
        logger.info("Borrando odontologo");
        if(odontologoService.findOdontologo(id).isEmpty()){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            odontologoService.deleteOdontologo(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return response;

    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) throws Exception {
        ResponseEntity<Odontologo> response = null;
        logger.info("Actualizando odontologo");
        if(odontologoService.findOdontologo(odontologo.getId()).isEmpty()){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            response = new ResponseEntity<>(odontologoService.updateOdontologo(odontologo), HttpStatus.OK);
        }
        return response;
    }

}