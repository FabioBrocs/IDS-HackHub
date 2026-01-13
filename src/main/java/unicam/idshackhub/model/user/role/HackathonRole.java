package unicam.idshackhub.model.user.role;

import unicam.idshackhub.model.user.role.permission.Permission;

import java.util.List;
import java.util.EnumSet;
import java.util.Set;

public enum HackathonRole implements Role {
	Judge(EnumSet.of(Permission.Can_Vote,Permission.Can_End_Valutation_State)),
	Organizator(EnumSet.of(Permission.Can_Proclamate_Winner,Permission.Can_Invite_Judge)),
	HackathonTeamMember(EnumSet.noneOf(Permission.class)),
	HackathonTeamLeader(EnumSet.of(Permission.Can_Submit));

	private final Set<Permission> permissions;

	HackathonRole(Set<Permission> permissions) {
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