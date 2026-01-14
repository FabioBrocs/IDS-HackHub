package unicam.idshackhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unicam.idshackhub.model.team.Team;
import unicam.idshackhub.model.user.assignment.Assignment;
import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.user.role.RoleType;

@SpringBootApplication
public class IdsHackHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdsHackHubApplication.class, args);
        System.out.println("--- L'APPLICAZIONE È PARTITA! ---");
        User user = new User();
        user.setUsername("Giacomo");
        user.getAssignments().add(new Assignment(new Team(),RoleType.G_VerifiedUser));
    }
}
