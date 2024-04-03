package br.com.joaopaulobuzatto.introducaotestesautomatizados.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joaopaulobuzatto.introducaotestesautomatizados.model.User;

@Service
public class UserService {

    public List<User> users = new ArrayList<>();

    public List<User> create(User user) {
        if (users.contains(user)) {
            throw new RuntimeException();
        }

        users.add(user);
        return users;
    }

}
