package unicam.idshackhub.team.builder;

import unicam.idshackhub.model.team.AbstractTeam;
import unicam.idshackhub.model.user.User;

import java.util.List;

public interface ITeamBuilder<V extends AbstractTeam, T extends ITeamBuilder<V, T>>  {
    T buildName(String name);
    T buildDescription(String description);
    T buildLeader(User leader);
    T buildMembers(List<User> members);
    V getTeam();
}