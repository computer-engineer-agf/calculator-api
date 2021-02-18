package com.calculator.hclm;

import com.calculator.hclm.service.CalculatorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class HclmApplication {

	static Logger logging = Logger.getLogger(CalculatorServiceImpl.class.getName());

	public static void main(String[] args) {
			SpringApplication.run(HclmApplication.class, args);
	}

}
