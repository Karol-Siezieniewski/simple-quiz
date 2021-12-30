package pl.example.quiz.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.quiz.dto.HealthcheckDto;

@RestController
@RequestMapping("/api/health")
public class HealthcheckRestController {

    @GetMapping
    public HealthcheckDto healthcheck() {
        HealthcheckDto healthcheckDto = new HealthcheckDto(true, "Healthcheck is positive!");
        return healthcheckDto;
    }
}
