package unicam.idshackhub.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import unicam.idshackhub.model.user.role.ContextType;
import unicam.idshackhub.model.user.role.Role;
import unicam.idshackhub.model.user.role.RoleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

	@Id private long id;
	private String username;
	private String email;
	private String passwordHash;
	private RoleType globalRole;
	@ElementCollection private List<Assignment> assignments = new ArrayList<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User other)) return false;
		if (this.id <= 0 || other.id <= 0) return false;
		return this.id == other.id;
	}

	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}

	public Optional<Role> getRoleByContext(Context context) {
		return assignments.stream()
				.filter(a -> context.equals(a.getContext()))
				.map(a -> (Role) a.getRole())
				.findFirst();
	}

	public Optional<Context> getContextByRole(Role role) {
		return assignments.stream()
				.filter(a -> role.equals(a.getRole()))
				.map(Assignment::getContext)
				.map(Context.class::cast)
				.findFirst();
	}
}
