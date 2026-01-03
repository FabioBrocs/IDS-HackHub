package unicam.idshackhub.hackathon.state;

import unicam.idshackhub.hackathon.Hackathon;
import unicam.idshackhub.role.permission.Permission;

public interface HackathonState {

	/**
	 * 
	 * @param perm
	 */
	boolean isActionAllowed(Permission perm);
	void updateState(Hackathon context);

}