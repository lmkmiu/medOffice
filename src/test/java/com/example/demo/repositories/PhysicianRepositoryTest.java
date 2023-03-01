package com.example.demo.repositories;

import com.example.demo.entities.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class PhysicianRepositoryTest {

    @Autowired
    PhysicianRepository phyDao;

    public PhysicianRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddFindById() {
        Physician drA = new Physician();
        drA.setFirstName("Dr");
        drA.setLastName("A");
        drA.setEmail("a@dr.com");
        drA.setPhone("12345678");
        drA.setPasswords("1234");
        phyDao.save(drA);

        Physician result = phyDao.findById(drA.getPhysicianId()).get();

        assertEquals(drA, result);
    }
}
