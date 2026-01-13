package unicam.idshackhub.model.hackathon.state;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.user.role.permission.Permission;


public class Registration implements HackathonState {

	public boolean isActionAllowed(Permission perm) {
		return switch (perm){
			case Can_Invite_Judge -> true;
			case Can_Registrate_Team -> true;
			default -> false;
		};
	}

	public void updateState(Hackathon context) {
		if(context.getStaff().getJudge() != null){
			if(context.getRules().getMinTeams()<=context.getTeams().size()){
				context.changeState(new Progress());
			}throw new SecurityException("non è stato raggiunto il numero minimo di team l'hackathon verrà annullato");
		}throw new SecurityException("giudice non presente, l'hackathon verrà annullato");
	}
}