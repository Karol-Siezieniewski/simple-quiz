package pl.example.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.example.quiz.database.entities.PlayerEntity;
import pl.example.quiz.database.repositories.PlayerRepository;
import pl.example.quiz.services.QuizDataService;

import java.util.List;

@Component
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Executing startup processes...");
        playerRepository.save(new PlayerEntity("Joe"));
        playerRepository.save(new PlayerEntity("Bill"));
        playerRepository.save(new PlayerEntity("Jessica"));

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
        for (PlayerEntity player : playersFromDatabase) {
            log.info("Retrieved player: " + player);
        }

        quizDataService.getQuizCategories();
//        quizDataService.getQuizQuestions();
    }
}
