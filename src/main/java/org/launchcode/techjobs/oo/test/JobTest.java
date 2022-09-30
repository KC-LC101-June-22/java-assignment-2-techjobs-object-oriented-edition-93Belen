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
        Job jobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Assert.assertTrue(jobFields.getName() instanceof String);
        Assert.assertTrue(jobFields.getEmployer() instanceof  Employer);
        Assert.assertTrue(jobFields.getLocation() instanceof  Location);
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
        Job jobTwinOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Job jobTwinTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Assert.assertFalse(jobTwinOne.equals(jobTwinTwo));
    }
}
