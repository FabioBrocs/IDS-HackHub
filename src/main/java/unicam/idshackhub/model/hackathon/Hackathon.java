package unicam.idshackhub.model.hackathon;

import jakarta.persistence.*;
import lombok.*;
import unicam.idshackhub.model.hackathon.state.HackathonState;
import unicam.idshackhub.model.hackathon.state.Registration;
import unicam.idshackhub.model.user.assignment.BaseContext;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.team.HackathonTeam;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hackathon extends BaseContext {
	private String title;
	private String description;
	private TeamRules rules;
	@Builder.Default private HackathonStaff staff = new HackathonStaff();
	private Schedule schedule;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hackathon_id")
	@Builder.Default private List<HackathonTeam> teams = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hackathon_id")
	@Builder.Default private List<Submission> submissions = new ArrayList<>();
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