package unicam.idshackhub.service;

import unicam.idshackhub.model.user.role.permission.Permission;
import unicam.idshackhub.model.utils.Invite;
import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.hackathon.Hackathon;

public class HackathonService extends Service {

	/**
	 * 
	 * @param organizator
	 * @param hackathon
	 */
	public void ProclamateWinner(User organizator, Hackathon hackathon) {
		if(checker.checkPermission(organizator, Permission.Can_Proclamate_Winner,hackathon)){
			if(hackathon.getActualState().isActionAllowed(Permission.Can_Proclamate_Winner)){
				//TODO logica proclamazione vincitore
			}throw new SecurityException("L'Hackathon non è ancora in fase conclusiva");
		}else {
			throw new SecurityException("L'utente non ha i permessi per questo hackathon");
		}
	}

	/**
	 * 
	 * @param organizator
	 * @param hackathon
	 * @param judge
	 */
	public void inviteJudge(User organizator,Hackathon hackathon, User judge) {
		if(checker.checkPermission(organizator,Permission.Can_Invite_Judge,hackathon)){
			if(hackathon.getActualState().isActionAllowed(Permission.Can_Invite_Judge)){
				if(judge.getRoleByContext(hackathon).isEmpty()){
					Invite inviteJudge= new Invite(organizator,"ciao!",judge);
				}else {
					throw new SecurityException("L'utente fa gia parte di questo hackathon in altri ruoli");
				}
			}throw new SecurityException("L'Hackathon non è in fase inziale");
		}else {
			throw new SecurityException("L'utente non ha i permessi per questo hackathon");
		}
	}

}