package unicam.idshackhub.model.hackathon;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.idshackhub.model.user.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HackathonStaff {
    @ManyToOne private User organizer;
    @ManyToOne private User judge;
}
