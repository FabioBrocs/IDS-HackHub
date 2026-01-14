package unicam.idshackhub.model.user.role;

import jakarta.persistence.Embeddable;
import unicam.idshackhub.model.user.role.permission.Permission;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public enum RoleType implements Role {
    //HACKATHON ROLE
    H_Judge(ContextType.HACKATHON,EnumSet.of(Permission.Can_Vote,Permission.Can_End_Valutation_State)),
    H_Organizator(ContextType.HACKATHON,EnumSet.of(Permission.Can_Proclamate_Winner,Permission.Can_Invite_Judge)),
    H_HackathonTeamMember(ContextType.HACKATHON,EnumSet.noneOf(Permission.class)),
    H_HackathonTeamLeader(ContextType.HACKATHON,EnumSet.of(Permission.Can_Submit)),
    //TEAM ROLE
    T_TeamMember(ContextType.TEAM,EnumSet.noneOf(Permission.class)),
    T_TeamLeader(ContextType.TEAM,EnumSet.of(Permission.Can_Registrate_Team)),
    //GLOBAL ROLE
    G_VerifiedUser(ContextType.GLOBAL,EnumSet.of(Permission.Can_Create_Hackathon)),
    G_SystemAdmin(ContextType.GLOBAL,EnumSet.of(Permission.Can_Manage_Request)),
    G_NormalUser(ContextType.GLOBAL,EnumSet.of(Permission.Can_Create_Request));

    private final ContextType contextType;
    private final Set<Permission> permissions;

    RoleType(ContextType type,Set<Permission> permissions) {
        this.contextType = type;
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
