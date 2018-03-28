package pl.iosx.quiz4wp.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.iosx.quiz4wp.model.data.quiz.Quiz;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class QuizResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<Quiz> quizItems;

    public QuizResponse(int count, List<Quiz> quizItems) {
        this.count = count;
        this.quizItems = quizItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Quiz> getQuizItems() {
        return quizItems;
    }

    public void setQuizItems(List<Quiz> quizItems) {
        this.quizItems = quizItems;
    }
}
