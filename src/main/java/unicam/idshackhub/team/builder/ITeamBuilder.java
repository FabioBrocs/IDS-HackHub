package unicam.idshackhub.team.builder;

import unicam.idshackhub.team.AbstractTeam;
import unicam.idshackhub.user.User;

public interface ITeamBuilder<T extends AbstractTeam>  {
    /**
     *
     * @param name
     */
    T buildName(String name);

    /**
     *
     * @param description
     */
    T buildDescription(String description);


    /**
     *
     * @param leader
     */
    T buildLeader(User leader);

    T getTeam();
}