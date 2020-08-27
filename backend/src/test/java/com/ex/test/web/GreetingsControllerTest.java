package com.ex.test.web;

import com.ex.web.GreetingsController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-application-context.xml"})
@WebAppConfiguration
public class GreetingsControllerTest {

  @Autowired
  WebApplicationContext wac;

  @Autowired
  GreetingsController controller;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void contextLoads() {}

  @Test
  public void getToGreetingController_thenReturnsRandomMotd() throws Exception {
    MvcResult result = mockMvc.perform(get("/greetings/")) // testing is done without the /api context of the DispatcherServlet f
                                                                      // from web.xml. The tests startup their own context not from the
                                                                      // deployment descriptor.
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();
    Assert.assertNotNull(result);
    Assert.assertTrue("Empty content", result.getResponse().getContentAsString().length() > 0);
  }

  @Test
  public void postToGreetinsController_thenReturnsLocationOfNewMotd() throws Exception {
    int motdsInitialSize = controller.getMotds().size();

    MvcResult result = mockMvc.perform(post("/greetings/")
      .contentType("text/plain").content("Hello, World!"))
      .andDo(print())
      .andExpect(status().isCreated())
      .andReturn();

    Assert.assertEquals("motdSize not expected", controller.getMotds().size(), motdsInitialSize + 1);
    Assert.assertNotNull("No location header", result.getResponse().getHeader("Location"));
  }

  @Test
  public void getById_thenReturnMotd() throws Exception {
    MvcResult result = mockMvc.perform(get("/greetings/0"))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();

    String body = result.getResponse().getContentAsString();
    Assert.assertNotNull("Empty body", body);
    Assert.assertTrue("Empty message", body.length() > 0);
  }

  @Test
  public void getById_withInvalidId_thenReturn400() throws Exception {
    mockMvc.perform((get("/greetings/-1")))
      .andDo(print())
      .andExpect(status().isBadRequest())
      .andReturn();
  }
}
