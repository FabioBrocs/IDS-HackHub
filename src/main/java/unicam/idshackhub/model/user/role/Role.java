package unicam.idshackhub.model.user.role;

import unicam.idshackhub.model.user.role.permission.Permission;

import java.util.List;

public interface Role {
	List<Permission> getListPermission();
	boolean hasPermission(Permission permission);
}