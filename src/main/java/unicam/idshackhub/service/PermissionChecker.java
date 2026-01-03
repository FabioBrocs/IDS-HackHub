package unicam.idshackhub.service;

import unicam.idshackhub.user.User;
import unicam.idshackhub.user.Context;
import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.utlities.Finished;

@Finished
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
		return user.getRole().hasPermission(perm);
	}

}