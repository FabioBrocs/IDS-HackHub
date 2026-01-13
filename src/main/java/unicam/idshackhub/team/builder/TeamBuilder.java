package unicam.idshackhub.team.builder;

import unicam.idshackhub.model.team.Team;

public class TeamBuilder extends TeamBuilderAbstract<Team, TeamBuilder> {

    @Override
    protected Team createTeamInstance() {
        return new Team();
    }

    public TeamBuilder buildIban(String iban) {
        team.setIban(iban);
        return this;
    }
}
