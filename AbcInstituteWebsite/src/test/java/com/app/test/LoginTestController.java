package com.app.test;

import static org.junit.Assert.*;

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

import com.abcinstitute.controller.LoginController;

@WebAppConfiguration
@ContextConfiguration({"file:WEB-INF/spring/appServlet/servlet-context.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class LoginTestController  {
	
@Autowired
 WebApplicationContext wac;
 MockMvc mockMvc;
 
 @Autowired
 LoginController loginController;
 
 @Before
 public void setup() throws Exception{
	 mockMvc=MockMvcBuilders.standaloneSetup(loginController).build();
 }
	

}
