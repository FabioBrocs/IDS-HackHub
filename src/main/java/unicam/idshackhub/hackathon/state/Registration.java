package unicam.idshackhub.hackathon.state;

import unicam.idshackhub.hackathon.Hackathon;
import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.utlities.Finished;

@Finished
public class Registration implements HackathonState {

	/**
	 * 
	 * @param perm
	 */
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
				System.out.println("tutte le condizioni sono stati soddisfatte, l'hackathon verrà fatto partire");
				context.changeState(new Progress());
			}throw new SecurityException("non è stato raggiunto il numero minimo di team l'hackathon verrà annullato");
		}throw new SecurityException("giudice non presente, l'hackathon verrà annullato");
	}
}