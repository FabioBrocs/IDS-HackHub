package unicam.idshackhub.team.builder;

import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.team.HackathonTeam;
import unicam.idshackhub.model.team.Team;

public class HackathonTeamBuilder extends TeamBuilderAbstract<HackathonTeam, HackathonTeamBuilder> {

	@Override
	protected HackathonTeam createTeamInstance() {
		return new HackathonTeam();
	}

	public HackathonTeamBuilder buildMainTeam(Team mainTeam) {
		team.setMainTeam(mainTeam);
		return this;
	}


	public HackathonTeamBuilder buildHackathonParticipation(Hackathon h) {
		team.setHackathonParticipation(h);
		return this;
	}

	public HackathonTeamBuilder buildSubmission(Submission s) {
		team.setSubmission(s);
		return this;
	}
}