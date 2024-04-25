package ru.netology.authorization.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorization.Exeptions.InvalidCredentials;
import ru.netology.authorization.Exeptions.UnauthorizedUser;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> catchInvalidCredentials(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> catchUnauthorizedUser(UnauthorizedUser e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
