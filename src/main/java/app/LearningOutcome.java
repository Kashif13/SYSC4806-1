package app;


import javax.persistence.*;

@Entity
public class LearningOutcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Category category;

    /**
     * Default constructor
     */
    public LearningOutcome() {}

    /**
     * Constructor incase name not provided. Gives it a blank name but retains description
     * @param description
     */
    public LearningOutcome(String description) {
        this.name = "";
        this.description = description;
    }

    /**
     * Constructor for learning outcomes
     * @param name - Name for learning outcomes, to easily identify
     * @param description - Description used to display what the learning outcome is
     */
    public LearningOutcome(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor for learning outcomes
     * @param name - Name for learning outcomes, to easily identify
     * @param description - Description used to display what the learning outcome is
     * @param program - program this learning outcome belongs to
     */
    public LearningOutcome(String name, String description, Program program) {
        this.name = name;
        this.description = description;
        this.program = program;
    }

    /** Getters **/
    public Long getId() {
        return id;
    }
    public String getDescription() { return description; }
    public String getName() { return name; }
    public Program getProgram() { return program; }


    /** Setters **/
    public void setId(Long objectiveId) {
        this.id = objectiveId;
    }
    public void setDescription(String desc) { this.description = desc; }
    public void setName(String name) { this.name = name; }
    public void setProgram(Program program) { this.program = program; }


    /**
     * Overridden toString method to ensure only description is displayed
     * @return String - description of the learning outcome
     */
    @Override
    public String toString(){
        return "ID: " +this.getId() + ", Name: " +this.name + ", Description: " + this.description;
    }

}
