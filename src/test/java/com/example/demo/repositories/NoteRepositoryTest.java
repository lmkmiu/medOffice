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
public class NoteRepositoryTest {

    @Autowired
    AppointmentRepository appDao;
    @Autowired
    NoteRepository noteDao;
    @Autowired
    PhysicianRepository phyDao;
    @Autowired
    UserRepository userDao;

    public NoteRepositoryTest() {
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

        LocalDateTime startTime = LocalDateTime.parse("2023-03-11T09:30:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endTime = LocalDateTime.parse("2023-03-11T10:00:00.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

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

        Appointment app1 = new Appointment();
        app1.setStartTime(startTime);
        app1.setEndTime(endTime);
        app1.setPhysician(drA);
        app1.setUser(userA);
        appDao.save(app1);

        Note note1 = new Note();
        note1.setNote("This is a testing note");
        note1.setAppointment(app1);
        note1.setPhysician(drA);
        noteDao.save(note1);

        // test find the notes by appointment id
        List<Note> appNotes = noteDao.findByAppointment(app1.getAppId());

        assertEquals(1, appNotes.size());
        assertTrue(appNotes.contains(note1));
        }
}
