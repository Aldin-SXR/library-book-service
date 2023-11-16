package ba.edu.ibu.libarybookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibaryBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibaryBookServiceApplication.class, args);
	}

}
