package app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faisal on 2018-03-20.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private AcademicYear year;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="COURSE_PROGRAM",
            joinColumns=@JoinColumn(name="COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name="PROGRAM_ID")
    )
    private List<Program> programs = new ArrayList<Program>();


    /**
     * Default constructor
     */
    public Course() {}

    /**
     * Constructor for Course
     * @param name - Name for the Course
     */
    public Course(String name) {
        this.name = name;
    }
    /**
     * Constructor for Course
     * @param name - Name for the Course
     * @param description - Description used to display what the course is about
     */
    public Course(String name, String description, AcademicYear year) {
        this.name = name;
        this.description = description;
        this.year = year;
    }

    /**
     * Constructor for Course
     * @param name - Name for the Course
     * @param description - Description used to display what the course is about
     */
    public Course(String name, String description, AcademicYear year, List<Program> p) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.programs = p;
    }

    /**
     * Function for adding program
     * @param p - Program to be added
     */
    public void addProgram(Program p){ this.programs.add(p); }

    /**
     * Function for removing program
     * @param p - program to be removed
     */
    public void removeProgram(Program p){ this.programs.remove(p); }

    /** Getters **/
    public Long getId() {
        return id;
    }
    public String getDescription() { return description; }
    public String getName() { return name; }
    public AcademicYear getYear() {return year; }



    /** Setters **/
    public void setId(Long objectiveId) {
        this.id = objectiveId;
    }
    public void setDescription(String desc) { this.description = desc; }
    public void setName(String name) { this.name = name; }
    public void setYear(AcademicYear year) {this.year = year; }


    /**
     * Overridden toString method to ensure only description is displayed
     * @return
     */
    @Override
    public String toString(){
        return "ID: " +this.getId() + ", " + name + ": " + description;
    }

}
