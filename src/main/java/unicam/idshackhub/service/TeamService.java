package unicam.idshackhub.service;

import unicam.idshackhub.model.user.role.RoleType;
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
	 * @param hackathonTeam
	 * @param hackathon
	 */
	public void registrateTeam(User teamLeader, HackathonTeam hackathonTeam, Hackathon hackathon) {
		if(checker.checkPermission(teamLeader, Permission.Can_Registrate_Team)) {
			if(hackathon.getActualState().isActionAllowed(Permission.Can_Registrate_Team)) {
				hackathon.getTeams().add(hackathonTeam);
			}else throw new RuntimeException("Iscrizioni scadute");
		}else throw new RuntimeException("Permission denied");
	}

	/**
	 * 
	 * @param teamLeader
	 * @param hackathonTeamLeader
	 * @param HackathonTeamMembers
	 */
	//TODO questo metodo è un macello pero funziona :)
	public void createHackathonTeam(User teamLeader, User hackathonTeamLeader, List<User> HackathonTeamMembers) {
		if(checker.checkPermission(teamLeader, Permission.Can_Create_HackathonTeam)){
				HackathonTeamBuilder builder = new HackathonTeamBuilder();
				builder.buildName("example");
				builder.buildDescription("example");
				builder.buildLeader(hackathonTeamLeader);
				builder.buildMainTeam(
						teamLeader.getContextByRole(RoleType.T_TeamLeader)
								.map(context -> (Team) context)
								.orElseThrow(() -> new RuntimeException("Main Team non trovato"))
				);
				builder.buildMembers(HackathonTeamMembers);
				HackathonTeam team = builder.getTeam();
		}
	}

}