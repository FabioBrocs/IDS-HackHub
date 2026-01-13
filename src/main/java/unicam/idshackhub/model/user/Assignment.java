package unicam.idshackhub.model.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import unicam.idshackhub.model.user.role.RoleType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Assignment {
	@ManyToOne
	@JoinColumn(name = "context_id")
	private BaseContext context; //in che contesto si applica hackathon o team
	private RoleType role; //tipo di ruolo (capo, membro...)
}