package unicam.idshackhub.service;

import unicam.idshackhub.hackathon.Hackathon;
import unicam.idshackhub.hackathon.HackathonStaff;
import unicam.idshackhub.hackathon.Schedule;
import unicam.idshackhub.hackathon.TeamRules;
import unicam.idshackhub.role.HackathonRole;
import unicam.idshackhub.role.permission.Permission;
import unicam.idshackhub.service.utils.Invite;
import unicam.idshackhub.service.utils.Request;
import unicam.idshackhub.team.builder.TeamBuilder;
import unicam.idshackhub.user.Assignment;
import unicam.idshackhub.user.User;

import java.util.Optional;

public class SystemService extends Service {

	/**
	 * 
	 * @param user
	 */
	public void createRequest(User user,String description) {
		if(checker.checkPermission(user, Permission.Can_Create_Request)){
			Request request = new Request(user,description);
		}else throw new RuntimeException("Permission denied");
	}

	/**
	 * 
	 * @param admin                 
	 * @param request
	 */
	public void manageRequest(User admin, Request request,boolean manage) {
		if(checker.checkPermission(admin, Permission.Can_Manage_Request)){
			request.Manage(manage);
		}else throw new RuntimeException("Permission denied");
	}

	public void AcceptInvite(User user, Invite invite,boolean accept) {
		boolean hasRole = invite.getOwner()
				.getContextByRole(HackathonRole.Organizator)
				.map(user::getRoleByContext)
				.isPresent();
		if(!hasRole){
			if(accept){
				invite.getOwner().getContextByRole(HackathonRole.Organizator)
						.ifPresent(contex -> {
							user.getAssignments().add(new Assignment(contex, HackathonRole.Judge));
						});
			}
		}else throw new SecurityException("l'utente fa già parte nell'hackathon");
	}

	/**
	 * 
	 * @param verifiedUser
	 */
	public void createHackathon(User verifiedUser) {
		if(checker.checkPermission(verifiedUser, Permission.Can_Create_HackathonTeam)){
			Hackathon.builder()
					.title("Hackathon")
					.description("Hackathon")
					.rules(new TeamRules(2,1,3,2))
					.staff(new HackathonStaff(verifiedUser,null))
					//.schedule(new Schedule())
					.build();
		}else throw new RuntimeException("Permission denied");
	}

	public void createTeam(User user) {
		if(checker.checkPermission(user, Permission.Can_Create_Team)){
			TeamBuilder builder = new TeamBuilder();
			//TODO INSERIRE BUILDER TEAM
		}else throw new RuntimeException("Permission denied");
	}

}