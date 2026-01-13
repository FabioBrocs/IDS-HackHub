package unicam.idshackhub.service;

import unicam.idshackhub.model.hackathon.state.Valutation;
import unicam.idshackhub.model.user.role.permission.Permission;
import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.hackathon.Hackathon;

public class JudgeService extends Service {

	/**
	 * 
	 * @param judge
	 * @param submission
	 * @param hackathon
	 */
	public void JudgeSubmission(User judge, Submission submission, Hackathon hackathon,Integer vote) {
		if(checker.checkPermission(judge, Permission.Can_Vote,hackathon)) {
			if(hackathon.getActualState().isActionAllowed(Permission.Can_Vote)){
				submission.setVote(vote);
			}throw new SecurityException("l'hackathon non è in fase di valutazione");
		}throw new SecurityException("l'utente non possiede i permessi adatti");
	}

	/**
	 * 
	 * @param judge
	 * @param hackathon
	 */
	public void closeVotationState(User judge, Hackathon hackathon) {
		if(checker.checkPermission(judge, Permission.Can_End_Valutation_State,hackathon)) {
			if(hackathon.getActualState() instanceof Valutation) {
				hackathon.getActualState().updateState(hackathon);
			}
		}throw new SecurityException("l'utente non possiede i permessi adatti");
	}

}