package unicam.idshackhub.hackathon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.user.User;

@Getter
@Setter
@AllArgsConstructor
public class HackathonStaff {
    private User organizer;
    private User judge;
}
