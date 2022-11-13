package com.jose.dddhexpractice.acceptance;


import com.jose.dddhexpractice.controllers.ChampionController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(ChampionController.class)
public class ChampionControllerAcceptanceTest {

    private final MockMvc mockMvc;

    public ChampionControllerAcceptanceTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Get all champions on empty database should give empty array")
    public void getAllChampionsWithEmptyDatabase() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("champion/all"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String data = mvcResult.getResponse().getContentAsString();
        assertEquals(HttpStatus.OK.value(),status);
        assertEquals("[]",data);
    }
}
