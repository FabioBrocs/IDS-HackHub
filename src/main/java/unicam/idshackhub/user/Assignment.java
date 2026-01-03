package unicam.idshackhub.user;

import jakarta.persistence.Embeddable;
import lombok.*;
import unicam.idshackhub.role.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Assignment {
	private Context context;
	private Role role;
}