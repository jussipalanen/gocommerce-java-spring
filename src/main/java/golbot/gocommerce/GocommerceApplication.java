package golbot.gocommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class GocommerceApplication {

	public static void main(String[] args) {
		System.out.println("Starting the Spring Application");
		SpringApplication.run(GocommerceApplication.class, args);
	}

}
