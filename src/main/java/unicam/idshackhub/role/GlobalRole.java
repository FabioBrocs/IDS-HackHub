package unicam.idshackhub.role;

import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.utlities.Finished;

import java.util.List;
import java.util.EnumSet;
import java.util.Set;

@Finished
public enum GlobalRole implements Role {
	VerifiedUser(EnumSet.of(Permission.Can_Create_Hackathon)),
	SystemAdmin(EnumSet.of(Permission.Can_Manage_Request)),
	NormalUser(EnumSet.of(Permission.Can_Create_Request));

	private final Set<Permission> permissions;

	GlobalRole(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public List<Permission> getListPermission() {
		return List.copyOf(this.permissions);
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return this.permissions.contains(permission);
	}

}