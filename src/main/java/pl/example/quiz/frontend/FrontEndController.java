package pl.example.quiz.frontend;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.example.quiz.services.QuizDataService;

@Controller
@Log
public class FrontEndController {

    @Autowired
    private QuizDataService quizDataService;

    @Autowired
    private OngoingGameService ongoingGameService;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "test message");
        return "index";
    }

    @GetMapping("/select")
    public String select(Model model){
        model.addAttribute("gameOptions", new GameOptions());
        model.addAttribute("categories", quizDataService.getQuizCategories());
        return "select";
    }

    @PostMapping("/select")
    public String postSelectForm(Model model, @ModelAttribute GameOptions gameOptions){
        log.info("Submitted form containing: " + gameOptions);
        ongoingGameService.gameInit(gameOptions);
        return "redirect:game";
    }

    @GetMapping("/game")
    public String game(Model model){
        model.addAttribute("userAnswer", new UserAnswer());
        model.addAttribute("currentQuestionNumber", ongoingGameService.getCurrentQuestionIndex());
        model.addAttribute("totalQuestionNumber", ongoingGameService.getTotalNumberOfQuestions());
        model.addAttribute("currentQuestion", ongoingGameService.getCurrentQuestion());
        model.addAttribute("currentQuestionAnswers", ongoingGameService.getCurrentQuestionAnswersInRandom());
        return "game";
    }
}
