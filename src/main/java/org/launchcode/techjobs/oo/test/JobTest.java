package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job jobOne = new Job();
        Job jobTwo = new Job();
        Assert.assertNotEquals(jobOne.getId(), jobTwo.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(jobFields.getName() instanceof String);
        Assert.assertTrue(jobFields.getEmployer() instanceof Employer);
        Assert.assertTrue(jobFields.getLocation() instanceof Location);
        Assert.assertTrue(jobFields.getPositionType() instanceof PositionType);
        Assert.assertTrue(jobFields.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Product tester", jobFields.getName());
        Assert.assertEquals("ACME", jobFields.getEmployer().getValue());
        Assert.assertEquals("Desert", jobFields.getLocation().getValue());
        Assert.assertEquals("Quality control", jobFields.getPositionType().getValue());
        Assert.assertEquals("Persistence", jobFields.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job jobTwinOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwinTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(jobTwinOne.equals(jobTwinTwo));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job someJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String someJobString = someJob.toString();
        // Returns blank line at beginning and end
        Assert.assertEquals('\n', someJobString.charAt(0));
        Assert.assertEquals('\n', someJobString.charAt(someJobString.length() - 1));
        }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job someJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String someJobString = someJob.toString();
        String expected = "\n" +
                "ID: " + someJob.getId() + '\n' +
                "Name: " + someJob.getName() + '\n' +
                "Employer: " + someJob.getEmployer() + '\n' +
                "Location: " + someJob.getLocation() + '\n' +
                "Position Type: " + someJob.getPositionType() + '\n' +
                "Core Competency: " + someJob.getCoreCompetency() +
                "\n";
        // Contains one label for each field, followed by its data each field is in its own line
        Assert.assertTrue(someJobString.contains("ID: " + someJob.getId() + '\n'));
        Assert.assertTrue(someJobString.contains("Name: " + someJob.getName() + '\n'));
        Assert.assertTrue(someJobString.contains("Employer: " + someJob.getEmployer() + '\n'));
        Assert.assertTrue(someJobString.contains("Location: " + someJob.getLocation() + '\n'));
        Assert.assertTrue(someJobString.contains("Position Type: " + someJob.getPositionType() + '\n'));
        Assert.assertTrue(someJobString.contains("Core Competency: " + someJob.getCoreCompetency() + '\n'));
        Assert.assertEquals(expected, someJobString);
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job someJob = new Job("Product tester", new Employer(), new Location(), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String someJobString = someJob.toString();
        String expected = "\n" +
                "ID: " + someJob.getId() + '\n' +
                "Name: " + someJob.getName() + '\n' +
                "Employer: " + new Employer("Data not available") + '\n' +
                "Location: " + new Location("Data not available") + '\n' +
                "Position Type: " + someJob.getPositionType() + '\n' +
                "Core Competency: " + someJob.getCoreCompetency() +
                "\n";
        // If field is null, return "Data not available"
        Assert.assertEquals(expected, someJobString);
        // If field is empty, return "Data not available"
        Job someEmptyJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String someEmptyJobString = someEmptyJob.toString();
        String expectedEmpty = "\n" +
                "ID: " + someEmptyJob.getId() + '\n' +
                "Name: " + someJob.getName() + '\n' +
                "Employer: " + new Employer("Data not available") + '\n' +
                "Location: " + new Location("Data not available") + '\n' +
                "Position Type: " + someJob.getPositionType() + '\n' +
                "Core Competency: " + someJob.getCoreCompetency() +
                "\n";
        Assert.assertEquals(expectedEmpty, someEmptyJobString);

    }
    @Test
    public void testToStringHandlesEmptyConstructor(){
        // if only contains id field, the method returns "OOPS! This job does not seem to exist"
        Job someJobOnlyId = new Job();
        Assert.assertEquals(someJobOnlyId.toString(), "OOPS! This job does not seem to exist");
    }
}
