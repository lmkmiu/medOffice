package com.example.demo.repositories;

import com.example.demo.entities.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userDao;

    public UserRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<User> users = userDao.findAll();

        for (User user : users) {
            userDao.deleteById(user.getUserId());
        }
    }
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddUser() {
        User userA = new User();
        userA.setFirstName("Hello");
        userA.setLastName("Kitty");
        userA.setEmail("hello@kitty.com");
        userA.setPhone("23456789");
        userA.setPasswords("1234");
        userDao.save(userA);

        User resultUser = userDao.findById(userA.getUserId()).get();

        assertEquals(userA, resultUser);
    }
}
