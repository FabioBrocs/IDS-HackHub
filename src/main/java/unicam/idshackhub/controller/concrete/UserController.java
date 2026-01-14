package unicam.idshackhub.controller.concrete;

import unicam.idshackhub.controller.AbstractController;
import unicam.idshackhub.model.user.User;

public class UserController extends AbstractController<User> {
    public UserController() {super(User.class);}

    @Override
    public Class<User> getEntityClass() {
        return null;
    }
}
