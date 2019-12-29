package com.cers.backend.controller;

import com.cers.backend.domain.Advice;
import com.cers.backend.service.AdviceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdviceController.class)
public class AdviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdviceService adviceService;

    @Test
    public void insertAdvice() throws Exception{
        Advice adviceMock = new Advice();
        Date date = new Date();

        adviceMock.setTitle("Treinamento");
        adviceMock.setDescription("Treinamento de incêndio - 12/01/2020");
        adviceMock.setDtPublication(date);

        Mockito.when(adviceService.insertAdvice(Mockito
                                   .any(Advice.class)))
                                   .thenReturn(adviceMock);

        mockMvc.perform(MockMvcRequestBuilders
               .post("/advice")
               .content(asJsonString(adviceMock))
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated());

    }

    @Test
    public void alterAdvice() throws Exception{
        Advice adviceMock = new Advice();
        Date date = new Date();

        adviceMock.setTitle("Treinamento");
        adviceMock.setDescription("Treinamento de incêndio para a TI- 12/01/2020");
        adviceMock.setDtVisualization(date);

        Mockito.when(adviceService.alterAdvice(Mockito
                .any(Advice.class), Mockito.anyLong()))
                .thenReturn(adviceMock);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/advice/{id}", 1)
                .content(asJsonString(adviceMock))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
               .delete("/advice/{id}",1))
               .andExpect(status().isOk());
    }

    @Test
    public void findById() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/advice/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listAdvices() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/advice")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}