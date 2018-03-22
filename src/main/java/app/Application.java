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

    public CommandLineRunner demo(LearningOutcomeRepository loRepo, ProgramRepository progRepo, CourseRepository courseRepo, CategoryRepository catRepo) {
        return (args) -> {
            // save a few categories with descriptions
            catRepo.save(new Category("Design", "Should have good designing abilities."));
            catRepo.save(new Category("Communication", "Should have good communication skills."));

            // fetch all categories
            log.info("Categories found with findAll():");
            log.info("-------------------------------");
            for (Category c : catRepo.findAll()) {
                log.info(c.toString());
            }
            log.info("");

            // fetch an individual learning outcome by ID
            Category c1 = catRepo.findOne(1L);
            log.info("Category found with findOne(1L):");
            log.info("--------------------------------");
            log.info(c1.toString());
            log.info("");

            // fetch categories of name "Communication"
            log.info("Categories found with findByName('Communication'):");
            log.info("--------------------------------------------");
            for (Category cats : catRepo.findByName("Communication")) {
                log.info(cats.toString());
            }
            log.info("");

            // save a couple of learning outcomes
            loRepo.save(new LearningOutcome("Cloud", "knows to deploy a web app to the cloud"));
            loRepo.save(new LearningOutcome("DesignPatters", "knows to enterprise design patters"));
            loRepo.save(new LearningOutcome("SaaS", "is able to understand SaaS literature", c1));
            loRepo.save(new LearningOutcome("DesignPatters", "has knowledge of creational patters", c1));
            loRepo.save(new LearningOutcome("DesignPatters", "has knowledge of behavioral patters"));

            // fetch all learning outcomes
            log.info("Learning Outcomes found with findAll():");
            log.info("-------------------------------");
            for (LearningOutcome lo : loRepo.findAll()) {
                log.info(lo.toString());
            }
            log.info("");

            // fetch an individual laerning outcome by ID
            LearningOutcome lo1 = loRepo.findOne(1L);
            log.info("Learning Outcome found with findOne(1L):");
            log.info("--------------------------------");
            log.info(lo1.toString());
            log.info("");

           // fetch learning outcomes of name design patters
            log.info("Learning Outcomes found with findByName('DesignPatters'):");
            log.info("--------------------------------------------");
            for (LearningOutcome los : loRepo.findByName("DesignPatters")) {
                log.info(los.toString());
            }
            log.info("");

            // save a few programs with descriptions
            Program p1 = new Program("Software Engineering", "Intense program involving the design, " +
                    "development and maintenance of software and computer systems.");
            Program p2 = new Program("Women's Studies", "Not so intense program involving ...");
            Program p3 = new Program("Psychology", "");
            //save a few course and years
            List<Program> programs = new ArrayList<>();
            List<Program> programs2 = new ArrayList<>();

            programs.add(p1);
            programs2.add(p2);
            courseRepo.save(new Course("SYSC4005", "Systems and Simulation", AcademicYear.YEAR_1, programs));
            courseRepo.save(new Course("SYSC4806", "Software Engineering lab", AcademicYear.YEAR_4, programs2));
            progRepo.save(p1);
            progRepo.save(p2);
            progRepo.save(p3);
            // fetch all programs
            log.info("Programs found with findAll():");
            log.info("-------------------------------");
            for (Program p : progRepo.findAll()) {
                log.info(p.toString());
            }
            log.info("");

            // fetch an individual learning outcome by ID
            Program ptest = progRepo.findOne(1L);
            log.info("Program found with findOne(1L):");
            log.info("--------------------------------");
            log.info(ptest.toString());
            log.info("");

            // fetch programs of name "Software Engineering"
            log.info("Programs found with findByName('Software Engineering'):");
            log.info("--------------------------------------------");
            for (Program progs : progRepo.findByName("Software Engineering")) {
                log.info(progs.toString());
            }
            log.info("");
        };
    }
}
