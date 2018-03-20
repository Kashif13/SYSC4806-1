package app;


import javax.persistence.*;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    /**
     * Default constructor
     */
    public Program() {}
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
     * Default constructor for when description is no provided.
     * @param name
     */
    public Program(String name) {
        this.name = name;
        this.description = "";
    }

    /** Getters **/
    public Long getId() {
        return id;
    }
    public String getDescription() { return description; }
    public String getName() { return name; }



    /** Setters **/
    public void setId(Long objectiveId) {
        this.id = objectiveId;
    }
    public void setDescription(String desc) { this.description = desc; }
    public void setName(String name) { this.name = name; }


    /**
     * Overridden toString method that returns program name followed by a
     * description for the program
     * @return
     */
    @Override
    public String toString(){
        return name + ": " + description;
    }

}
