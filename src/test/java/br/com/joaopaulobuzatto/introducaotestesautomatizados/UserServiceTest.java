package br.com.joaopaulobuzatto.introducaotestesautomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.joaopaulobuzatto.introducaotestesautomatizados.model.User;
import br.com.joaopaulobuzatto.introducaotestesautomatizados.service.UserService;

public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void createUser_ReturnUsers() {
        // AAA
        // Arrange
        var user = new User("joaopaulobuzatto", "123456");

        // Act
        List<User> list = userService.create(user);

        // Assert
        assertEquals(1, list.size());
        assertEquals(user, list.get(0));
    }

    @Test
    public void createUser_ThrowsException() {
        var user = new User("joaopaulobuzatto", "123456");
        userService.create(user);

        assertThrows(Exception.class, () -> userService.create(user));
    }

}
