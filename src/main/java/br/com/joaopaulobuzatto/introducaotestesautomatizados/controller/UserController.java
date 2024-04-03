package br.com.joaopaulobuzatto.introducaotestesautomatizados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulobuzatto.introducaotestesautomatizados.model.User;
import br.com.joaopaulobuzatto.introducaotestesautomatizados.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public List<User> create(@RequestBody User user) {
        return userService.create(user);
    }
    

}
