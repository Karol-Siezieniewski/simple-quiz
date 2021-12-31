package pl.example.quiz.frontend;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.quiz.dto.QuestionsDto;
import pl.example.quiz.services.QuizDataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log
public class OngoingGameService {
    private GameOptions gameOptions;
    private int currentQuestionIndex;
    @Getter
    private int points;

    private List<QuestionsDto.QuestionDto> questions;

    @Autowired
    private QuizDataService quizDataService;

    public void gameInit(GameOptions gameOptions){
        this.gameOptions = gameOptions;
        this.currentQuestionIndex = 0;
        this.points = 0;

        this.questions = quizDataService.getQuizQuestions(gameOptions);
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex+1;
    }

    public int getTotalNumberOfQuestions() {
        return questions.size();
    }

    public String getCurrentQuestion(){
        QuestionsDto.QuestionDto dto = questions.get(currentQuestionIndex);
        return dto.getQuestion();
    }

    public List<String> getCurrentQuestionAnswersInRandom() {
        QuestionsDto.QuestionDto dto = questions.get(currentQuestionIndex);

        List<String> answers = new ArrayList<>();
        answers.add(dto.getCorrectAnswer());
        answers.addAll(dto.getIncorrectAnswers());

        Collections.shuffle(answers);
        return answers;
    }

    public boolean proceedToNextQuestion(){
        currentQuestionIndex++;
        return currentQuestionIndex < questions.size();
    }
}