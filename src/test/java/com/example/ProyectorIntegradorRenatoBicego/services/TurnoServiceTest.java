package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.exceptions.BadRequestException;
import com.example.ProyectorIntegradorRenatoBicego.models.Domicilio;
import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.models.Turno;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    private static Turno turnoTest;
    @BeforeAll
    public static void cargarDatos(){
        turnoTest = new Turno();
        turnoTest.setFecha(LocalDateTime.of(2022, 10, 10, 10, 0, 0));

        Odontologo odontologoTest = new Odontologo();
        Paciente pacienteTest = new Paciente();
        Paciente pacienteGuardado = new PacienteService().savePaciente(pacienteTest);
        Odontologo odontologoGuardado = new OdontologoService().saveOdontologo(odontologoTest);

        turnoTest.setOdontologo(odontologoGuardado);
        turnoTest.setPaciente(pacienteGuardado);
    }

    @Test
    public void registrarBuscarEliminarTurno() throws BadRequestException {
        Turno turnoGuardado = turnoService.saveTurno(turnoTest);
        Assert.assertNotNull(turnoGuardado.getId());
        turnoTest.setId(turnoGuardado.getId());

        Optional<Turno> turnoRecibido = turnoService.findTurno(turnoTest.getId());
        Assert.assertTrue(turnoRecibido.isPresent());
        Assert.assertEquals(turnoRecibido.get().getId(), turnoTest.getId());

        turnoService.deleteTurno(turnoTest.getId());
        Assert.assertTrue(turnoService.findTurno(turnoTest.getId()).isEmpty());
    }

    @Test
    public void buscarTodosTurnos(){
        List<Turno> turnos = turnoService.findAllTurnos();
        Assert.assertTrue(turnos.size() > 0);
    }

}*/