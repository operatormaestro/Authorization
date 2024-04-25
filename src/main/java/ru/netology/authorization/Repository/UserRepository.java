package ru.netology.authorization.Repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.Constants.Authorities;

import java.util.List;

import static ru.netology.authorization.Constants.AuthoritiesSets.*;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("admin") && password.equals("admin"))
            return ROOT.getSet();
        if (user.equals("blogger0") && password.equals("12345"))
            return AUTHOR.getSet();
        if (user.equals("user1") && password.equals("user1"))
            return USER.getSet();
        return null;
    }

}
