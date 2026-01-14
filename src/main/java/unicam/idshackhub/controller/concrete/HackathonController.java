package unicam.idshackhub.controller.concrete;

import unicam.idshackhub.controller.AbstractController;
import unicam.idshackhub.model.hackathon.Hackathon;

public class HackathonController extends AbstractController<Hackathon> {
    public HackathonController() {super(Hackathon.class);}

    @Override
    public Class<Hackathon> getEntityClass() {
        return null;
    }
}
