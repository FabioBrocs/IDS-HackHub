package unicam.idshackhub.model.user;

import jakarta.persistence.Embeddable;

@Embeddable
public interface Context {
	long getId();
}