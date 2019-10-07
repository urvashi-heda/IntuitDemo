package com.intuit.demo;

import com.intuit.demo.controllers.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeController.class, secure = false)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveDetailsForCourse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/anonymous").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"message\": \"Welcome! This page is open to all\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
