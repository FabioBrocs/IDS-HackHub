package unicam.idshackhub.team.builder;

import unicam.idshackhub.team.AbstractTeam;
import unicam.idshackhub.user.User;

public class TeamBuilderAbstract<T extends AbstractTeam> implements ITeamBuilder{

    private T result;

    @Override
    public T buildName(String name) {
        result.setName(name);
        return result;
    }

    @Override
    public T buildDescription(String description) {
        result.setDescription(description);
        return result;
    }

    @Override
    public T buildLeader(User leader) {
        result.setLeader(leader);
        return result;
    }

    @Override
    public T getTeam() {
        return result;
    }
}
