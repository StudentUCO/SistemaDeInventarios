package co.com.uco.sistemainventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaInventarioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaInventarioApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		 String password = "admin";
		 for (int i = 0; i < 10; i++) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	 
			 String passwordEncrypt = passwordEncoder.encode(password);
			 System.out.println(passwordEncrypt);
			 
		}
		
	}
}
