package com.mutual.prueba;


import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

public class MockMvcTestUtil {
  /** Utility for mock testing */
  protected MockMvc mockMvc;

  public void init(Object controlller)
  {
    StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(controlller);
    this.mockMvc = builder.build();
  }

}
