package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.models.Domicilio;
import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PacienteServiceTest {
        @Autowired
        private PacienteService pacienteService;
        private static Paciente pacienteTest;
        @BeforeAll
        public static void cargarDatos(){
            pacienteTest = new Paciente();
            Domicilio domicilioTest = new Domicilio();
            domicilioTest.setCalle("Calle");
            domicilioTest.setLocalidad("Localidad");
            domicilioTest.setNumero(123);
            domicilioTest.setProvincia("Provincia");
            pacienteTest.setNombre("Nombre");
            pacienteTest.setApellido("Apellido");
            pacienteTest.setDni(12345);
            pacienteTest.setDomicilio(domicilioTest);
            pacienteTest.setEmail("email@gmail.com");
            pacienteTest.setFechaIngreso(LocalDate.of(2023, 12, 12));
        }

        @Test
        @Order(1)
        public void registrarBuscarEliminarPaciente(){
            Paciente pacienteGuardado = pacienteService.savePaciente(pacienteTest);
            Assert.assertNotNull(pacienteGuardado.getId());
            pacienteTest.setId(pacienteGuardado.getId());

            Optional<Paciente> pacienteRecibido = pacienteService.findPaciente(pacienteTest.getId());
            Assert.assertEquals(pacienteRecibido.get().getId(), pacienteTest.getId());
            System.out.println(pacienteTest.getId());

            pacienteService.deletePaciente(pacienteTest.getId());
            Assert.assertTrue(pacienteService.findPaciente(pacienteTest.getId()).isEmpty());
        }


        @Test
        public void buscarTodosPacientes(){
            List<Paciente> pacientes = pacienteService.findAllPacientes();
            Assert.assertTrue(pacientes.size() > 0);
        }

}