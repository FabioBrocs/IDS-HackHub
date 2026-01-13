package unicam.idshackhub.model.hackathon.state;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.user.role.permission.Permission;

public class Valutation implements HackathonState {

	/**
	 * 
	 * @param perm
	 */
	public boolean isActionAllowed(Permission perm) {
		return switch (perm){
			case Can_Vote -> true;
			case Can_End_Valutation_State -> true;
			default -> false;
		};
	}

	public void updateState(Hackathon context) {
		if(context.getSubmissions().stream().anyMatch(s -> s.getVote() == null)) System.out.println("impossibile procedere alla fase successiva se le sottomissioni non sono state tutte valutate");
		context.changeState(new Conclusion());
	}
}