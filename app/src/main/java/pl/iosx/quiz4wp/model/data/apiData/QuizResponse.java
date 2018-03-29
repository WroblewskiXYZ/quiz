package pl.iosx.quiz4wp.model.data.apiData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.iosx.quiz4wp.model.data.apiData.quiz.QuizItem;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class QuizResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<QuizItem> quizItemItems;

    public QuizResponse(int count, List<QuizItem> quizItemItems) {
        this.count = count;
        this.quizItemItems = quizItemItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<QuizItem> getQuizItemItems() {
        return quizItemItems;
    }

    public void setQuizItemItems(List<QuizItem> quizItemItems) {
        this.quizItemItems = quizItemItems;
    }
}
