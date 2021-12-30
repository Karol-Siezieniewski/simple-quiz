package pl.example.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.example.quiz.dto.CategoriesDto;
import pl.example.quiz.dto.QuestionsDto;

import java.net.URI;

@Service
@Log
public class QuizDataService {

    public void getQuizCategories() {
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Available quiz categories: " + result.getCategories());
    }

    public void getQuizQuestions() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", 2)
                .queryParam("category", 15)
                .queryParam("difficulty", "medium")
                .build().toUri();
        log.info("Quiz questions retrieve URL: " + uri);

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Quiz questions: " + result.getResults());
    }
}
