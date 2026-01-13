package unicam.idshackhub.model.user.role;

import unicam.idshackhub.model.user.role.permission.Permission;

import java.util.EnumSet;
import java.util.Set;

public enum TeamRole implements Role {
	TeamMember(EnumSet.noneOf(Permission.class)),
	TeamLeader(EnumSet.of(Permission.Can_Registrate_Team));

	private final Set<Permission> permissions;

	TeamRole(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public java.util.List<Permission> getListPermission() {
		return java.util.List.copyOf(this.permissions);
	}
	@Override
	public boolean hasPermission(Permission permission) {
		return this.permissions.contains(permission);
	}
}