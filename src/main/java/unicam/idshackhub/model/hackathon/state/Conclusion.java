package unicam.idshackhub.model.hackathon.state;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.user.role.permission.Permission;

public class Conclusion implements HackathonState {

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