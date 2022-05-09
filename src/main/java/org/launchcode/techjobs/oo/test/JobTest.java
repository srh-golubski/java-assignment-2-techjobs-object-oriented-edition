package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job test_job_1;
    Job test_job_2;
    Job test_job_3;
    Job test_job_4;
    Job test_job_5;
    Job test_job_6;

    @Before
    public void createJobObject() {
        test_job_1 = new Job();
        test_job_2 = new Job();
        test_job_3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job_4 = new Job("Your Dream Job", new Employer("Bumble"), new Location("Remote"), new PositionType("Front end developer"), new CoreCompetency("Positive attitude"));
        test_job_5 = new Job("Your Dream Job", new Employer("Bumble"), new Location("Remote"), new PositionType("Front end developer"), new CoreCompetency("Positive attitude"));
        test_job_6 = new Job("Incomplete Job", new Employer(), new Location("New York City"), new PositionType(""), new CoreCompetency("Java"));
    }

    @Test
    public void testSettingJobId() {
        int test1 = test_job_2.getId() - 1;
        int test2 = test_job_1.getId();
        assertFalse(test_job_1.getId() == test_job_2.getId());
        assertEquals(test1, test2, .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String testName = test_job_3.getName();
        Employer testEmployer = test_job_3.getEmployer();
        Location testLocation = test_job_3.getLocation();
        PositionType testPositionType = test_job_3.getPositionType();
        CoreCompetency testCoreCompetency = test_job_3.getCoreCompetency();

        assertEquals("Product tester", testName);
        assertEquals("ACME", testEmployer.getValue());
        assertEquals("Desert", testLocation.getValue());
        assertEquals("Quality control", testPositionType.getValue());
        assertEquals("Persistence", testCoreCompetency.getValue());

        assertTrue(test_job_3 instanceof Job);
        assertTrue(testName instanceof String);
        assertTrue(testEmployer instanceof Employer);
        assertTrue(testLocation instanceof Location);
        assertTrue(testPositionType instanceof PositionType);
        assertTrue(testCoreCompetency instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job_4 == test_job_5);
    }

    @Test
    public void testJobsPrintCorrectly() {
        assertEquals("\nID: " + test_job_3.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", test_job_3.toString());
        assertEquals("\nOOPS! This job does not seem to exist.\n", test_job_1.toString());
        assertEquals("\nID: " + test_job_6.getId() + "\nName: Incomplete Job\nEmployer: Data not available\nLocation: New York City\nPosition Type: Data not available\nCore Competency: Java\n", test_job_6.toString());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        assertEquals("\nID: " + test_job_3.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", test_job_3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        assertEquals("\nID: " + test_job_6.getId() + "\nName: Incomplete Job\nEmployer: Data not available\nLocation: New York City\nPosition Type: Data not available\nCore Competency: Java\n", test_job_6.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        assertEquals("\nID: " + test_job_4.getId() + "\nName: Your Dream Job\nEmployer: Bumble\nLocation: Remote\nPosition Type: Front end developer\nCore Competency: Positive attitude\n", test_job_4.toString());
    }
}