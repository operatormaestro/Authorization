package ru.netology.authorization.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.authorization.Constants.Authorities;
import ru.netology.authorization.Exeptions.InvalidCredentials;
import ru.netology.authorization.Exeptions.UnauthorizedUser;
import ru.netology.authorization.Repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
