package unicam.idshackhub.model.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.idshackhub.model.team.HackathonTeam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submission {
	@Id
	@OneToOne(optional = false)
	@JoinColumn(name = "team_id", nullable = false)
	private HackathonTeam team;
	private String description;
	private Integer vote;

	public Submission(HackathonTeam team, String description) {
		this.team = team;
		this.description = description;
		this.vote = null;
	}

}