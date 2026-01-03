package unicam.idshackhub.team;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Team extends AbstractTeam {

	private String iban;

	@Override
	public String getScopeName() {
		return "";
	}
}
