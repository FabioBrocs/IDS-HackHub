package unicam.idshackhub.model.user;

import jakarta.persistence.Embeddable;
import lombok.*;
import unicam.idshackhub.model.user.role.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
/*JPA gli sta molto antipatico il fatto di usare le interfacce per buttarle nel database
pero vorrei evitare di togliere le interfacce o cambiare troppo la logica de programma
per buttarci dentro jpa, la soluzione migliore sembrerebbe quella di usare dei converter */
public class Assignment {
	private Context context;
	private Role role;
}