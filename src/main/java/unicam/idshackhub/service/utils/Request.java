package unicam.idshackhub.service.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.role.GlobalRole;
import unicam.idshackhub.user.User;

@Getter
@Setter
@AllArgsConstructor
//TODO JPA
public class Request {
	private User user;
	private String description;

	public void Manage(boolean manage) {
		if (manage) user.setRole(GlobalRole.VerifiedUser);
	}
}