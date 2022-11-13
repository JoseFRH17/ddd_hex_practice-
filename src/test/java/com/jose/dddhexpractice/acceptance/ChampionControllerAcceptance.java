package com.jose.dddhexpractice.acceptance;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(ChampionController.class)
public class ChampionControllerAcceptance {

    private MockMvc mockMvc;

    public ChampionControllerAcceptance(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Get all champions on empty database should give empty array")
    public void getAllChampionsWithEmptyDatabase() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/allChampions"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String data = mvcResult.getResponse().getContentAsString();
        assertEquals(HttpStatus.OK,status);
        assertEquals("[]",data);
    }
}
