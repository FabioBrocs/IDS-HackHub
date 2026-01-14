package unicam.idshackhub.model.team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.model.user.assignment.BaseContext;
import unicam.idshackhub.model.user.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractTeam extends BaseContext {
    private String name;
    private String description;
    @OneToOne private User leader;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "User_id")
    private List<User> members = new ArrayList<>();
}