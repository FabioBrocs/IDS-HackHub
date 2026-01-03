package unicam.idshackhub.hackathon.submission;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.idshackhub.team.HackathonTeam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submission {
	@Id private HackathonTeam team;
	private String description;
	private Integer vote;

	public Submission(HackathonTeam team, String description) {
		this.team = team;
		this.description = description;
		this.vote = null;
	}

}