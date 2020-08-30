package works.hop.db.access;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

@SpringBootApplication
public class DemoDbAccessApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoDbAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
