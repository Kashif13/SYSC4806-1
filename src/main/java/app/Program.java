package app;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy="programs",cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<Course>();

    /**
     * Default constructor
     */
    public Program() {}

    /**
     * Default constructor for when description is no provided.
     * @param name
     */
    public Program(String name) {
        this.name = name;
        this.description = "";
    }

    /**
     * Constructor for program
     * @param name - Name of the program, e.g. Software Engineering
     * @param description - Description for the program
     */
    public Program(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor for program when name, description and learning outcomes provided
     * @param name - Name of the program, e.g. Software Engineering
     * @param description - Description for the program
     * @param courses - List of course belonging to this program
     */
    public Program(String name, String description, List<Course> courses) {
        this.name = name;
        this.description = description;
        this.courses = courses;
    }

    /**
     * Function for adding course
     * @param course - Course to be added
     */
    public void addCourse(Course course){ this.courses.add(course); }

    /**
     * Function for removing a course
     * @param course - Course to be removed
     */
    public void removeCourse(Course course){ this.courses.remove(course); }


    /** Getters **/
    public Long getId() {
        return id;
    }
    public String getDescription() { return description; }
    public String getName() { return name; }
    public List<Course> getCourse() { return courses; }

    /** Setters **/
    public void setId(Long objectiveId) {
        this.id = objectiveId;
    }
    public void setDescription(String desc) { this.description = desc; }
    public void setName(String name) { this.name = name; }
    public void setCourses(List<Course> courses) { this.courses = courses; }


    /**
     * Overridden toString method that returns program name followed by a
     * description for the program
     * @return String - description of the program
     */
    @Override
    public String toString(){
        return "ID: " +this.getId() + ", " + name + ": " + description;
    }

}
