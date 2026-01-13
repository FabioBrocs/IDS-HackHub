package unicam.idshackhub.model.hackathon;

import jakarta.persistence.*;
import lombok.*;
import unicam.idshackhub.model.hackathon.state.HackathonState;
import unicam.idshackhub.model.hackathon.state.Registration;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.team.HackathonTeam;
import unicam.idshackhub.model.user.Context;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
//TODO FIX attributi Transient
public class Hackathon implements Context {
	@Setter(AccessLevel.NONE) @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	private String title;
	private String description;
	private TeamRules rules;
	private HackathonStaff staff;
	private Schedule schedule;
	@Transient @Builder.Default private List<HackathonTeam> teams = new ArrayList<>();
	@Transient @Builder.Default private List<Submission> submissions = new ArrayList<>();
	//anche se non da errore subito dovrebbe rompersi per lo stesso motivo di assignment
	@Builder.Default private HackathonState actualState = new Registration();

	/**
	 * 
	 * @param newState
	 */
	public void changeState(HackathonState newState) {
		this.actualState = newState;
	}


	public void deleteHackathon() {
		this.actualState = null;
		//Procedo pulizia di tutti i ruoli
	}
}