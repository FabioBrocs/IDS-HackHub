package unicam.idshackhub.model.hackathon;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class TeamRules {
    private int maxTeams;
    private int minTeams;
    private int maxPlayersPerTeam;
    private int minPlayersPerTeam;


    public TeamRules(int maxT, int minT, int maxP, int minP) {
        if(maxT<minT || maxP<minP) throw new IllegalArgumentException();
        this.maxTeams = maxT;
        this.minTeams = minT;
        this.maxPlayersPerTeam = maxP;
        this.minPlayersPerTeam = minP;
    }

}
