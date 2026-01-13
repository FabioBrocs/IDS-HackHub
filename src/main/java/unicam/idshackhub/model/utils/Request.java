package unicam.idshackhub.model.utils;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.idshackhub.model.user.role.GlobalRole;
import unicam.idshackhub.model.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Request {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	@ManyToOne(optional = false) User user;
	private String description;

	public Request(User user, String description) {
		this.user = user;
		this.description = description;
	}

	public void Manage(boolean manage) {
		if (manage) user.setRole(GlobalRole.VerifiedUser);
	}
}