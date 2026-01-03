package unicam.idshackhub.hackathon.state;

import unicam.idshackhub.hackathon.Hackathon;
import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.utlities.Finished;

@Finished
public class Progress implements HackathonState {

	/**
	 * 
	 * @param perm
	 */
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