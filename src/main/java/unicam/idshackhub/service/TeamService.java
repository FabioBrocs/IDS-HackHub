package unicam.idshackhub.service;

import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.user.User;
import unicam.idshackhub.team.HackathonTeam;
import unicam.idshackhub.hackathon.Hackathon;

public class TeamService extends Service {

	/**
	 * 
	 * @param teamLeader
	 * @param HackathonTeam
	 * @param hackathon
	 */
	public void registrateTeam(User teamLeader, HackathonTeam HackathonTeam, Hackathon hackathon) {

	}

	/**
	 * 
	 * @param teamLeader
	 * @param hackathonTeamLeader
	 * @param HackathonTeamMembers
	 */
	//TODO CHECK parametri e builder hackathonTeam
	public void createHackathonTeam(User teamLeader, User hackathonTeamLeader, User[] HackathonTeamMembers) {
		if(checker.checkPermission(teamLeader, Permission.Can_Create_HackathonTeam,null)){

		}
	}

}