package unicam.idshackhub.model.utils;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.idshackhub.model.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Invite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @ManyToOne User owner;
    String description;
    @ManyToOne User arrival;

    public Invite(User owner, String description, User arrival) {
        this.owner = owner;
        this.description = description;
        this.arrival = arrival;
    }
}
