package unicam.idshackhub.service.utils;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.user.User;
import unicam.idshackhub.utlities.Finished;

@Getter
@Setter
@AllArgsConstructor
@Finished
//TODO JPA
public class Invite {
    long id;
    User owner;
    String description;
    User arrival;
}
