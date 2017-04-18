package values;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Eli on 4/14/2017.
 */

@SpringBootApplication
public class Application {

	// using bootstrapping and a defined main(), this starts the web service.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
