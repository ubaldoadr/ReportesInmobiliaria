package cl.praxis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ReportesInmobiliariaApplication {

	private static final Logger loggerx = LoggerFactory.getLogger(ReportesInmobiliariaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReportesInmobiliariaApplication.class, args);
	}


	/*@Bean
	CommandLineRunner init(PasswordEncoder passwordEncoder) {
		return args -> {
			System.out.println(passwordEncoder.encode("1234"));
		};
	}*/
}
