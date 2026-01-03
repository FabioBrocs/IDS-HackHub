package unicam.idshackhub.hackathon.state;

import unicam.idshackhub.hackathon.Hackathon;
import unicam.idshackhub.role.permission.Permission;

public class Conclusion implements HackathonState {

	/**
	 * 
	 * @param perm
	 */
	public boolean isActionAllowed(Permission perm) {
		return switch (perm){
			case Can_Proclamate_Winner -> true;
			default -> false;
		};
	}

	public void updateState(Hackathon context) {
		context.deleteHackathon();
		//TODO valutare se salvare uno storico in un database
	}
}