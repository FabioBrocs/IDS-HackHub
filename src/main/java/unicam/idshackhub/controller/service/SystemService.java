package unicam.idshackhub.controller.service;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.hackathon.HackathonStaff;
import unicam.idshackhub.model.hackathon.Schedule;
import unicam.idshackhub.model.hackathon.TeamRules;
import unicam.idshackhub.model.user.assignment.BaseContext;
import unicam.idshackhub.model.user.role.RoleType;
import unicam.idshackhub.model.user.role.permission.Permission;
import unicam.idshackhub.model.utils.Invite;
import unicam.idshackhub.model.utils.Request;
import unicam.idshackhub.model.team.builder.TeamBuilder;
import unicam.idshackhub.model.user.assignment.Assignment;
import unicam.idshackhub.model.user.User;

import java.util.ArrayList;

import static unicam.idshackhub.controller.service.PermissionChecker.checkPermission;

public class SystemService{

	/**
	 * 
	 * @param user
	 */
	public void createRequest(User user,String description) {
		if(checkPermission(user, Permission.Can_Create_Request)){
			Request request = new Request(user,description);
		}else throw new RuntimeException("Permission denied");
	}

	/**
	 * 
	 * @param admin                 
	 * @param request
	 */
	public void manageRequest(User admin, Request request,boolean manage) {
		if(checkPermission(admin, Permission.Can_Manage_Request)){
			request.Manage(manage);
		}else throw new RuntimeException("Permission denied");
	}

	public void AcceptInvite(User user, Invite invite,boolean accept) {
		boolean hasRole = invite.getOwner()
				.getContextByRole(RoleType.H_Organizator)
				.map(user::getRoleByContext)
				.isPresent();
		if(!hasRole){
			if(accept){
				invite.getOwner().getContextByRole(RoleType.H_Organizator)
						.ifPresent(contex -> {
							user.getAssignments().add(new Assignment((BaseContext) contex, RoleType.H_Judge));
						});
			}
		}else throw new SecurityException("l'utente fa già parte nell'hackathon");
	}

	/**
	 * 
	 * @param verifiedUser
	 */
	public void createHackathon(User verifiedUser, String title, String description, TeamRules teamRules, Schedule schedule) {
		if(checkPermission(verifiedUser, Permission.Can_Create_HackathonTeam)){
			Hackathon.builder()
					.title(title)
					.description(description)
					.rules(teamRules)
					.schedule(schedule)
					.build();
		}else throw new RuntimeException("Permission denied");
	}

	public void createTeam(User user,String name,String description,String iban) {
		if(checkPermission(user, Permission.Can_Create_Team)){
			TeamBuilder builder = new TeamBuilder();
			builder.buildName(name)
					.buildDescription(description)
					.buildLeader(user)
					.buildMembers(new ArrayList<>())
					.buildIban(iban);
		}else throw new RuntimeException("Permission denied");
	}
}