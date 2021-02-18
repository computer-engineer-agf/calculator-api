package com.calculator.hclm;

import com.calculator.hclm.controller.SimpleCalculatorController;
import com.calculator.hclm.model.Calculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.FileOutputStream;
import java.time.LocalDateTime;

@SpringBootTest
public class HclmApplicationTests {

	@Test
	void contextLoads() {
	}

}
