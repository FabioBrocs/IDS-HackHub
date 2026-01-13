package unicam.idshackhub.model.hackathon.state;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.user.role.permission.Permission;

public class Progress implements HackathonState {

	public boolean isActionAllowed(Permission perm) {
		return switch (perm){
			case Can_Submit -> true;
			default -> false;
		};
	}

	public void updateState(Hackathon context) {
		context.getTeams().removeIf(team -> team.getSubmission() == null);
		if(context.getTeams().isEmpty()) context.deleteHackathon();
		context.changeState(new Valutation());
	}
}