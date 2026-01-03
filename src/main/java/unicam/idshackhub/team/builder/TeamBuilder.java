package unicam.idshackhub.team.builder;

import unicam.idshackhub.team.Team;

public class TeamBuilder extends TeamBuilderAbstract {
    private Team result;

    public Team buildIban(String iban){
        result.setIban(iban);
        return result;
    }
}
