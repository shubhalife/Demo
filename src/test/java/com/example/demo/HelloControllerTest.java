package com.example.demo;

import com.example.demo.controller.Hello;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private Hello hello;

    @Test
    public void invitationCardFormTest() {


        Assert.assertEquals(new Hello().HelloWord(), "views/index");
    }
}
