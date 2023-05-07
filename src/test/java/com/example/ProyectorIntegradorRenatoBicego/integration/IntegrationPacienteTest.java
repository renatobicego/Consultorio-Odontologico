package com.example.ProyectorIntegradorRenatoBicego.integration;

import com.example.ProyectorIntegradorRenatoBicego.models.Domicilio;
import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import com.example.ProyectorIntegradorRenatoBicego.services.PacienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationPacienteTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private PacienteService pacienteService;

    private Paciente pacienteTest;

    @Test
    public void buscarPacientePorId() throws Exception{
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

        Paciente pacienteGuardado = pacienteService.savePaciente(pacienteTest);

        pacienteTest.setId(pacienteGuardado.getId());

        mvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", pacienteTest.getId()).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void buscarPacientes() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/pacientes").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
