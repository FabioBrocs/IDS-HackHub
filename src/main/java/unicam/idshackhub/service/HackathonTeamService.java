package unicam.idshackhub.service;

import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.user.User;
import unicam.idshackhub.hackathon.submission.Submission;
import unicam.idshackhub.team.HackathonTeam;
import unicam.idshackhub.hackathon.Hackathon;

public class HackathonTeamService extends Service {

	/**
	 * 
	 * @param HackathonTeamLeader
	 * @param submission
	 * @param Team
	 * @param hackathon
	 */
	public void postSubmission(User HackathonTeamLeader, Submission submission, HackathonTeam Team, Hackathon hackathon) {
		if(checker.checkPermission(HackathonTeamLeader, Permission.Can_Submit,hackathon)){
			hackathon.getSubmissions().add(submission);
		}else{
			throw new SecurityException("L'utente non ha i permessi per inviare la sottomissione.");
		}
	}
	//TODO come creano la sottmissione?
}