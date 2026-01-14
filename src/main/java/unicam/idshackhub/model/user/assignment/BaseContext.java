package unicam.idshackhub.model.user.assignment;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseContext implements Context {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
}
