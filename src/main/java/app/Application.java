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

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(LearningOutcomeRepository loRepo, ProgramRepository progRepo) {
        return (args) -> {
            // save a couple of learning outcomes
            loRepo.save(new LearningOutcome("Cloud", "knows to deploy a web app to the cloud"));
            loRepo.save(new LearningOutcome("DesignPatters", "knows to enterprise design patters"));
            loRepo.save(new LearningOutcome("SaaS", "is able to understand SaaS literature"));
            loRepo.save(new LearningOutcome("DesignPatters", "has knowledge of creational patters"));
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
            progRepo.save(new Program("Software Engineering", "Intense program involving the design, " +
                    "development and maintenance of software and computer systems."));
            progRepo.save(new Program("Women's Studies", "Not so intense program involving ..."));
            progRepo.save(new Program("Psychology", ""));

            // fetch all programs
            log.info("Programs found with findAll():");
            log.info("-------------------------------");
            for (Program p : progRepo.findAll()) {
                log.info(p.toString());
            }
            log.info("");

            // fetch an individual laerning outcome by ID
            Program p1 = progRepo.findOne(1L);
            log.info("Program found with findOne(1L):");
            log.info("--------------------------------");
            log.info(p1.toString());
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
