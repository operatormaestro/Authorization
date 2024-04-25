package ru.netology.authorization.Constants;

import java.util.List;

public enum AuthoritiesSets {
    ROOT(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
    AUTHOR(List.of(Authorities.READ, Authorities.WRITE)),
    USER(List.of(Authorities.READ));

    private final List<Authorities> set;

    AuthoritiesSets(List<Authorities> set) {
        this.set = set;
    }

    public List<Authorities> getSet() {
        return set;
    }
}
