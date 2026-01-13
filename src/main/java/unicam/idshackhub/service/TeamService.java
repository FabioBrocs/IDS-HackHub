package unicam.idshackhub.service;

import unicam.idshackhub.model.user.role.TeamRole;
import unicam.idshackhub.model.user.role.permission.Permission;
import unicam.idshackhub.model.team.Team;
import unicam.idshackhub.team.builder.HackathonTeamBuilder;
import unicam.idshackhub.model.user.User;
import unicam.idshackhub.model.team.HackathonTeam;
import unicam.idshackhub.model.hackathon.Hackathon;

import java.util.List;

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
	//TODO CHECK parametri
	//TODO questo metodo è un macello pero funziona :)
	public void createHackathonTeam(User teamLeader, User hackathonTeamLeader, List<User> HackathonTeamMembers, Hackathon hackathon) {
		if(checker.checkPermission(teamLeader, Permission.Can_Create_HackathonTeam,null)){
				HackathonTeamBuilder builder = new HackathonTeamBuilder();
				builder.buildName("example");
				builder.buildDescription("example");
				builder.buildLeader(teamLeader);
				builder.buildMainTeam(
						teamLeader.getContextByRole(TeamRole.TeamLeader)
								.map(context -> (Team) context)
								.orElseThrow(() -> new RuntimeException("Main Team non trovato"))
				);
				builder.buildMembers(HackathonTeamMembers);
				builder.buildHackathonParticipation(hackathon);
				HackathonTeam team = builder.getTeam();
				hackathon.getTeams().add(team);
		}
	}

}