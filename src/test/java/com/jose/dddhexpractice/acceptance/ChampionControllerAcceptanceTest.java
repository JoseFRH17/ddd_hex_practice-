package com.jose.dddhexpractice.acceptance;


import com.jose.dddhexpractice.common.AbstractControllerTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class ChampionControllerAcceptanceTest  extends AbstractControllerTest {

    @Override
    @BeforeAll
    public void setUp() {
        super.setUp();
    }

    @Test
    @DisplayName("Get all champions on empty database should give empty array")
    public void getAllChampionsWithEmptyDatabase() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/champion/all"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String data = mvcResult.getResponse().getContentAsString();
        assertEquals(HttpStatus.OK.value(),status);
        assertEquals("[]",data);
    }
}
