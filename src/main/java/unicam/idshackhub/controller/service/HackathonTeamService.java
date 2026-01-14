package unicam.idshackhub.controller.service;

import unicam.idshackhub.model.user.role.permission.Permission;
import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.team.HackathonTeam;
import unicam.idshackhub.model.hackathon.Hackathon;

import static unicam.idshackhub.controller.service.PermissionChecker.checkPermission;

public class HackathonTeamService{

	/**
	 * 
	 * @param HackathonTeamLeader
	 * @param submission
	 * @param Team
	 * @param hackathon
	 */
	public void postSubmission(User HackathonTeamLeader, Submission submission, HackathonTeam Team, Hackathon hackathon) {
		if(checkPermission(HackathonTeamLeader, Permission.Can_Submit,hackathon)){
			hackathon.getSubmissions().add(submission);
		}else{
			throw new SecurityException("L'utente non ha i permessi per inviare la sottomissione.");
		}
	}
	//TODO come creano la sottmissione?
}