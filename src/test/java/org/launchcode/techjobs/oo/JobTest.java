package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        Job test1 = new Job();
        Job test2 = new Job();
        int testId1 = test1.getId();
        int testId2 = test2.getId() - 1;
        assertEquals(testId1, testId2, .001);
        assertFalse(test1.getId() == test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job_7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testName = test_job_7.getName();
        Employer testEmployer = test_job_7.getEmployer();
        Location testLocation = test_job_7.getLocation();
        PositionType testPositionType = test_job_7.getPositionType();
        CoreCompetency testCoreCompetency = test_job_7.getCoreCompetency();

        assertEquals("Product tester", testName);
        assertEquals("ACME", testEmployer.getValue());
        assertEquals("Desert", testLocation.getValue());
        assertEquals("Quality control", testPositionType.getValue());
        assertEquals("Persistence", testCoreCompetency.getValue());

        assertTrue(test_job_7 instanceof Job);
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
        Job test_job_10 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = test_job_10.toString().charAt(0);
        char lastChar = test_job_10.toString().charAt(test_job_10.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
        //assertEquals("\nID: " + test_job_10.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", test_job_10.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job_8 = new Job("Incomplete Job", new Employer(""), new Location("New York City"), new PositionType(""), new CoreCompetency("Java"));
        assertEquals("\nID: " + test_job_8.getId() + "\nName: Incomplete Job\nEmployer: Data not available\nLocation: New York City\nPosition Type: Data not available\nCore Competency: Java\n", test_job_8.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test_job_10 = new Job("Your Dream Job", new Employer("Bumble"), new Location("Remote"), new PositionType("Front end developer"), new CoreCompetency("Positive attitude"));
        assertEquals("\nID: " + test_job_10.getId() + "\nName: Your Dream Job\nEmployer: Bumble\nLocation: Remote\nPosition Type: Front end developer\nCore Competency: Positive attitude\n", test_job_10.toString());
    }
}