package pl.example.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class QuizDataService {

    public void getQuizCategories(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://opentdb.com/api_category.php", String.class);
        log.info("Available quiz categories: " + result);
    }
}
