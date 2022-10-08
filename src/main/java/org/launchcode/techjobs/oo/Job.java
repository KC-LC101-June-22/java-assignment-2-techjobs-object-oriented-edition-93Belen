package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    @Override
    public String toString(){
        if(this.getName() == null && this.getEmployer() == null && this.getLocation() == null && this.getPositionType() == null && this.getCoreCompetency() == null) {
            return "OOPS! This job does not seem to exist";
        }
    // TASK 5: HANDLE EMPTY DATA
        if(this.getName() == null){
            this.setName("Data not available");
        }
        if(this.getEmployer().getValue() == null | this.getEmployer().getValue() == ""){
            this.setEmployer(new Employer("Data not available"));
        }
        if(this.getLocation().getValue() == null | this.getLocation().getValue() == ""){
            this.setLocation(new Location("Data not available"));
        }
        if(this.getPositionType().getValue() == null | this.getPositionType().getValue() == ""){
            this.setPositionType(new PositionType("Data not available"));
        }
        if(this.getCoreCompetency().getValue() == null  | this.getCoreCompetency().getValue() == ""){
            this.setCoreCompetency(new CoreCompetency("Data not available"));
        }


        return "\n" +
                "ID: " + this.getId() + '\n' +
                "Name: " + this.getName() + '\n' +
                "Employer: " + this.getEmployer() + '\n' +
                "Location: " + this.getLocation() + '\n' +
                "Position Type: " + this.getPositionType() + '\n' +
                "Core Competency: " + this.getCoreCompetency() +
                "\n";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}
