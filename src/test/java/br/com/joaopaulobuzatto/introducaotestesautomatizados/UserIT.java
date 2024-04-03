package br.com.joaopaulobuzatto.introducaotestesautomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import br.com.joaopaulobuzatto.introducaotestesautomatizados.model.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createUser() {
        var user = new User("joaopaulobuzatto", "123456");

        User[] list = testRestTemplate.postForObject("/api/users", user, User[].class);

        assertNotNull(list);
        assertEquals(1, list.length);
        assertEquals(user, list[0]);
        assertThrows(RuntimeException.class, () -> testRestTemplate.postForObject("/api/users", user, User[].class));
    }

}
