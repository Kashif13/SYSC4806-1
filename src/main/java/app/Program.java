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
    private List<LearningOutcome> learningOutcomes = new ArrayList<LearningOutcome>();

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
     * @param los - List of learning outcomes belonging to this program
     */
    public Program(String name, String description, List<LearningOutcome> los) {
        this.name = name;
        this.description = description;
        this.learningOutcomes = los;
    }

    /**
     * Function for adding learning outcome
     * @param lo - Learning outcome to be added
     */
    public void addLearningOutcome(LearningOutcome lo){ this.learningOutcomes.add(lo); }

    /**
     * Function for removing learning outcome
     * @param lo - Learning outcome to be removed
     */
    public void removeLearningOutcome(LearningOutcome lo){ this.learningOutcomes.remove(lo); }


    /** Getters **/
    public Long getId() {
        return id;
    }
    public String getDescription() { return description; }
    public String getName() { return name; }

    @OneToMany(mappedBy = "program", cascade = CascadeType.PERSIST)
    public List<LearningOutcome> getLearningOutcomes() { return learningOutcomes; }

    /** Setters **/
    public void setId(Long objectiveId) {
        this.id = objectiveId;
    }
    public void setDescription(String desc) { this.description = desc; }
    public void setName(String name) { this.name = name; }
    public void setLearningOutcomes(List<LearningOutcome> los) { this.learningOutcomes = los; }


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
