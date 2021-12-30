package pl.example.quiz.dto;


public class HealthcheckDto {

    private boolean status;
    private String message;

    public HealthcheckDto(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
