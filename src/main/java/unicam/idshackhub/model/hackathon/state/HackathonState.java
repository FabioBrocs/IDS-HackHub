package unicam.idshackhub.model.hackathon.state;

import jakarta.persistence.Embeddable;
import unicam.idshackhub.model.hackathon.Hackathon;
import unicam.idshackhub.model.user.role.permission.Permission;

@Embeddable
public interface HackathonState {
	boolean isActionAllowed(Permission perm);
	void updateState(Hackathon context);
}