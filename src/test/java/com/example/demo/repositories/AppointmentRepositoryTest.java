package com.example.demo.repositories;

import com.example.demo.entities.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AppointmentRepositoryTest {

    @Autowired
    AppointmentRepository appDao;
    @Autowired
    NoteRepository noteDao;
    @Autowired
    PhysicianRepository phyDao;
    @Autowired
    UserRepository userDao;

    public AppointmentRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
//        List<User> users = userDao.findAll();
//
//        for(User user : users) {
//            userDao.deleteById(user.getUserId());
//        }
//
//        List<Physician> physicians = phyDao.findAll();
//
//        for(Physician physician: physicians) {
//            phyDao.deleteById(physician.getPhysicianId());
//        }
//
//        List<Note> notes = noteDao.findAll();
//
//        for(Note note: notes) {
//            noteDao.deleteById(note.getNoteId());
//        }
//
//        List<Appointment> apps = appDao.findAll();
//
//        for(Appointment app: apps) {
//            appDao.deleteById(app.getAppId());
//        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddFindById() {

        LocalDateTime startTime1 = LocalDateTime.parse("2023-03-11T09:30:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endTime1 = LocalDateTime.parse("2023-03-11T10:00:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime startTime2 = LocalDateTime.parse("2023-03-11T10:01:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endTime2 = LocalDateTime.parse("2023-03-11T10:30:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Physician drA = new Physician();
        drA.setFirstName("Dr");
        drA.setLastName("A");
        drA.setEmail("a@dr.com");
        drA.setPhone("12345678");
        drA.setPasswords("1234");
        phyDao.save(drA);

        User userA = new User();
        userA.setFirstName("Hello");
        userA.setLastName("Kitty");
        userA.setEmail("hello@kitty.com");
        userA.setPhone("23456789");
        userA.setPasswords("1234");
//        userA.isNotification(0);
        userDao.save(userA);

        Physician drB = new Physician();
        drB.setFirstName("Dr");
        drB.setLastName("B");
        drB.setEmail("b@dr.com");
        drB.setPhone("12345678");
        drB.setPasswords("1234");
        phyDao.save(drB);

        Appointment app1 = new Appointment();
        app1.setStartTime(startTime1);
        app1.setEndTime(endTime1);
        app1.setPhysician(drA);
        app1.setUser(userA);
        appDao.save(app1);

        Appointment app2 = new Appointment();
        app2.setStartTime(startTime2);
        app2.setEndTime(endTime2);
        app2.setPhysician(drB);
        app2.setUser(userA);
        appDao.save(app2);

        //test appointments find by physician ID
        List<Appointment> phyAppList = appDao.findByPhysician(drA.getPhysicianId());
        Appointment test = appDao.findById(1).get();
        assertEquals(1, phyAppList.size());
        assertTrue(phyAppList.contains(app1));
        assertFalse(phyAppList.contains(app2));
        //test appointments find by user ID
        List<Appointment> userAppList = appDao.findByUser(userA.getUserId());

        assertEquals(2, userAppList.size());
        assertTrue(userAppList.contains(app1));
        assertTrue(userAppList.contains(app2));
    }

}
