package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    private static Odontologo odontologoTest;
    @BeforeAll
    public static void cargarDatos(){
        odontologoTest = new Odontologo();
        odontologoTest.setNombre("Nombre");
        odontologoTest.setApellido("Apellido");
        odontologoTest.setMatricula(12345);
    }

    @Test
    public void registrarBuscarEliminarOdontologo(){
        Odontologo odontologoGuardado = odontologoService.saveOdontologo(odontologoTest);
        Assert.assertNotNull(odontologoGuardado.getId());
        odontologoTest.setId(odontologoGuardado.getId());

        Optional<Odontologo> odontologoRecibido = odontologoService.findOdontologo(odontologoTest.getId());
        Assert.assertTrue(odontologoRecibido.isPresent());
        Assert.assertEquals(odontologoRecibido.get().getId(), odontologoTest.getId());

        odontologoService.deleteOdontologo(odontologoTest.getId());
        Assert.assertTrue(odontologoService.findOdontologo(odontologoTest.getId()).isEmpty());
    }

    @Test
    public void buscarTodosOdontologos(){
        List<Odontologo> odontologos = odontologoService.findAllOdontologos();
        Assert.assertTrue(odontologos.size() > 0);
    }

}