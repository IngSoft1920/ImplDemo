package ingsoft1920.impldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class ImpldemoApplication {
	final static Logger logger = LogManager.getLogger(ImpldemoApplication.class.getName());

	public static void main(String[] args) {
		logger.info("Aplicacion iniciada");
		SpringApplication.run(ImpldemoApplication.class, args);
	}

}
