package unicam.idshackhub.service;

import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.user.Context;
import unicam.idshackhub.model.user.role.permission.Permission;

public class PermissionChecker {
	/**
	 * 
	 * @param user
	 * @param perm
	 * @param context
	 */
	public boolean checkPermission(User user, Permission perm, Context context) {
		if (user == null || perm == null) return false;
		return user.getRoleByContext(context)
				.map(role -> role.hasPermission(perm))
				.orElse(false);
	}

	public boolean checkPermission(User user, Permission perm) {
		if (user == null || perm == null) return false;
		return user.getGlobalRole().hasPermission(perm);
	}

}