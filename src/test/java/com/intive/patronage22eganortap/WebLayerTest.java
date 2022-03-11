package com.intive.patronage22eganortap;

import com.intive.patronage22eganortap.web.controller.HelloTeamController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloTeamController.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenValidInput_Returns200() throws Exception {
        mockMvc.perform(get("/api/hello"))
    public void whenValidInputAndPolishLang_Returns200() throws Exception {
        mockMvc.perform(get("/api/")
                        .param("language", "pl"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cześć Zespole Cebularze!"));
    }

    @Test
    public void whenValidInputAndEnglishLang_Returns200() throws Exception {
        mockMvc.perform(get("/api/")
                        .param("language", "en"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Cebularze Team:)"));
    }

    @Test
    public void whenValidInputAndDefaultLang_Returns200() throws Exception {
        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cześć Zespole Cebularze!"));
    }
}