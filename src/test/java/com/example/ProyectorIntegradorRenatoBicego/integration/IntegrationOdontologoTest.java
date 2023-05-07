package com.example.ProyectorIntegradorRenatoBicego.integration;

import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import com.example.ProyectorIntegradorRenatoBicego.services.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationOdontologoTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private OdontologoService odontologoService;
    private Odontologo odontologoTest;

    @Test
    public void registrarOdontologo() throws Exception{
        odontologoTest = new Odontologo();
        odontologoTest.setId(1L);
        odontologoTest.setNombre("Nombre");
        odontologoTest.setApellido("Apellido");
        odontologoTest.setMatricula(12345);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payload = writer.writeValueAsString(odontologoTest);

        MvcResult response = mvc.perform(MockMvcRequestBuilders.post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(response.getResponse().getContentAsString(), payload);

    }

}

