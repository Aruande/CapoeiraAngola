package com.kalunga.capoeiraangola;


import com.kalunga.capoeiraangola.user.User;
import com.kalunga.capoeiraangola.user.UserDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserDAOTests {
    @Autowired private UserDAO userDAO;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("d5@youhoo.com");
        user.setPassword("dave123456");
        user.setFirstName("David");
        user.setLastName("hunt");

        User savedUser = userDAO.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = userDAO.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = userDAO.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello2000");
        userDAO.save(user);

        User updatedUser = userDAO.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello2000");
    }

    @Test
    public void testGet() {
        Integer userId = 3;
        Optional<User> optionalUser = userDAO.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }


    @Test
    public void testDelete() {
        Integer userId = 2;
        userDAO.deleteById(userId);

        Optional<User> optionalUser = userDAO.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }


}
