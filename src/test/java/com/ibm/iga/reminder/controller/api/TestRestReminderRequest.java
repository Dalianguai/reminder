package com.ibm.iga.reminder.controller.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ibm.iga.reminder.config.MyWebApplicationInitializer;
import com.ibm.iga.reminder.config.RootConfiguration;
import com.ibm.iga.reminder.config.WebMvcConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={RootConfiguration.class,WebMvcConfig.class, MyWebApplicationInitializer.class})

public class TestRestReminderRequest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void testPostReminderRequest () throws Exception {
    	this.mockMvc.perform(get("/api/reminder/request"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
       .andExpect(jsonPath("$.status").value("failure"));
    }
}
