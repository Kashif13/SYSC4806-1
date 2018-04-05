package app;

/**
 * Created by Faisal on 2018-02-23.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserRepository userRepository, LearningOutcomeRepository loRepo, ProgramRepository progRepo, CourseRepository courseRepo, CategoryRepository catRepo) {
        return (args) -> {

            userRepository.save(new User("admin", "password"));
            userRepository.save(new User("user", "password"));

            // save a few categories with descriptions
            catRepo.save(new Category("Design", "Should have good designing abilities."));
            catRepo.save(new Category("Communication", "Should have good communication skills."));

            // fetch an individual learning outcome by ID
            Category c1 = catRepo.findOne(1L);

            // save a couple of learning outcomes
            List<LearningOutcome> learningOutcomes1 = new ArrayList<LearningOutcome>();
            List<LearningOutcome> learningOutcomes2 = new ArrayList<LearningOutcome>();
            learningOutcomes1.add(new LearningOutcome("Cloud", "knows to deploy a web app to the cloud"));
            learningOutcomes1.add(new LearningOutcome("DesignPatters", "knows to enterprise design patters"));
            learningOutcomes1.add(new LearningOutcome("SaaS", "is able to understand SaaS literature", c1));
            learningOutcomes2.add(new LearningOutcome("DesignPatters", "has knowledge of creational patters", c1));
            learningOutcomes2.add(new LearningOutcome("DesignPatters", "has knowledge of behavioral patters"));


            // save a few programs with descriptions
            Program p1 = new Program("Software Engineering", "Intense program involving the design, " +
                    "development and maintenance of software and computer systems.");
            Program p2 = new Program("Women's Studies", "Not so intense program involving ...");
            Program p3 = new Program("Psychology", "");

            //save a few course and years, and have courses set in the corresponding learning outcomes
            List<Program> programs = new ArrayList<>();
            List<Program> programs2 = new ArrayList<>();

            programs.add(p1);
            programs2.add(p2);
            Course course1 = new Course("SYSC4005", "Systems and Simulation", AcademicYear.YEAR_1, programs);
            Course course2 = new Course("SYSC4806", "Software Engineering lab", AcademicYear.YEAR_4, programs2);

            courseRepo.save(course1);
            courseRepo.save(course2);
            for(LearningOutcome lo : learningOutcomes1){
                lo.setCourse(course1);
                lo.setCategory(c1);
                loRepo.save(lo);
            }
            for(LearningOutcome lo : learningOutcomes2){
                lo.setCourse(course2);
                lo.setCategory(c1);
                loRepo.save(lo);
            }
            progRepo.save(p1);
            progRepo.save(p2);
            progRepo.save(p3);

            // fetch an individual learning outcome by ID
            Program ptest = progRepo.findOne(1L);
        };
    }
}
