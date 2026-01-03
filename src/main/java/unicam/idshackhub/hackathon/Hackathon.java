package unicam.idshackhub.hackathon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import unicam.idshackhub.hackathon.state.HackathonState;
import unicam.idshackhub.hackathon.state.Registration;
import unicam.idshackhub.hackathon.submission.Submission;
import unicam.idshackhub.team.HackathonTeam;
import unicam.idshackhub.user.Context;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
//TODO FIX ENTITY JPA
public class Hackathon implements Context {
	@Setter(AccessLevel.NONE) @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	private String title;
	private String description;
	private TeamRules rules;
	private HackathonStaff staff;
	private Schedule schedule;
	@Builder.Default private List<HackathonTeam> teams = new ArrayList<>();
	@Builder.Default private HackathonState actualState = new Registration();
	@Builder.Default private List<Submission> submissions = new ArrayList<>();

	/**
	 * 
	 * @param newState
	 */
	public void changeState(HackathonState newState) {
		this.actualState = newState;
	}

	@Override
	public String getScopeName() {
		return "HACKATHON";
	}

	public void deleteHackathon() {
		this.actualState = null;
		//Procedo pulizia di tutti i ruoli
	}
}