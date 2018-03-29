package pl.iosx.quiz4wp.model.data.apiData.quizContent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class Question {

    @SerializedName("image")
    private QImage image;

    @SerializedName("answers")
    private List<Answer> answers;

    @SerializedName("text")
    private String text;

    @SerializedName("answer")
    private String answer;

    @SerializedName("type")
    private String type;

    @SerializedName("order")
    private int order;

    public Question(QImage image, List<Answer> answers, String text, String answer, String type, int order) {
        this.image = image;
        this.answers = answers;
        this.text = text;
        this.answer = answer;
        this.type = type;
        this.order = order;
    }

    public QImage getImage() {
        return image;
    }

    public void setImage(QImage image) {
        this.image = image;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
