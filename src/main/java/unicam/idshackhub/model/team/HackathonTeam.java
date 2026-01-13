package unicam.idshackhub.model.team;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.model.utils.Submission;
import unicam.idshackhub.model.hackathon.Hackathon;

@Getter
@Setter
@Entity
public class HackathonTeam extends AbstractTeam{
	@ManyToOne @JoinColumn(name = "main_team_id") private Team mainTeam;
	@ManyToOne @JoinColumn(name = "hackathon_participation_id") private Hackathon hackathonParticipation;
	@OneToOne private Submission submission;
}