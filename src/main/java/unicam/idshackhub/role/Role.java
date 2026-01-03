package unicam.idshackhub.role;

import unicam.idshackhub.role.permission.Permission;

import java.util.List;

public interface Role {
	List<Permission> getListPermission();
	boolean hasPermission(Permission permission);
}