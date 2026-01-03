package unicam.idshackhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unicam.idshackhub.user.User;

@SpringBootApplication
public class IdsHackHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdsHackHubApplication.class, args);
        System.out.println("--- L'APPLICAZIONE È PARTITA! ---");
        User user = new User();
        user.setUsername("Giacomo");
    }
}
