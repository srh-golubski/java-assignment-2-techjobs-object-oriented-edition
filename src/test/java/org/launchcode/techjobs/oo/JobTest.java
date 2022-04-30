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

    @Before
    public void createJobObject() {
            test_job_1 = new Job();
            test_job_2 = new Job();
            test_job_3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            test_job_4 = new Job("Your Dream Job", new Employer("Bumble"), new Location("Remote"), new PositionType("Front end developer"), new CoreCompetency("Positive attitude"));
            test_job_5 = new Job("Your Dream Job", new Employer("Bumble"), new Location("Remote"), new PositionType("Front end developer"), new CoreCompetency("Positive attitude"));
        }

    @Test
    public void testSettingJobId() {
        int test1 = test_job_2.getId() - 1;
        int test2 = test_job_1.getId();
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
        //assertEquals(new Employer("ACME"), testEmployer);
        //assertEquals(new Location("Desert"), testLocation);
        //assertEquals(new PositionType("Quality control"), testPositionType);
        //assertEquals(new CoreCompetency("Persistence"), testCoreCompetency);

        assertTrue(test_job_3 instanceof Job);
        assertTrue(testName instanceof String);
        assertTrue(testEmployer instanceof Employer);
        assertTrue(testLocation instanceof Location);
        assertTrue(testPositionType instanceof PositionType);
        assertTrue(testCoreCompetency instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertNotSame("Verify that two Job objects with different IDs are not equal", test_job_4, test_job_5);
    }

    @Test
    public void testJobsPrintCorrectly() {
        assertEquals("\nID: 6\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence", test_job_3.toString());
    }


}
