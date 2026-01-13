package unicam.idshackhub.model.team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.model.user.Context;
import unicam.idshackhub.model.user.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractTeam implements Context {

    @Id private long id;
    private String name;
    private String description;
    @OneToOne private User leader;
    @Transient private List<User> members = new ArrayList<>();
}