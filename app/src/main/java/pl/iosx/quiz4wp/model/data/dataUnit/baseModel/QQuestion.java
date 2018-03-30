package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "QUESTION_ITEM")
public class QQuestion {

    @DatabaseField(generatedId = true)
    private long id;

    @ForeignCollectionField
    private ForeignCollection<QAnswer> answerForeignCollection;

    @SerializedName("answers")
    List<QAnswer> answers;

    @DatabaseField(columnName = "QUIZ_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private QuizModel quiz;

    @SerializedName("image")
    @DatabaseField (columnName = "QUESTION_IMAGE_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private QImage qImage;

    @SerializedName("text")
    @DatabaseField (columnName = "Q_TEXT")
    private String text;

    @SerializedName("answer")
    @DatabaseField (columnName = "ANSWER")
    private String answer;

    @SerializedName("type")
    @DatabaseField (columnName = "Q_TYPE")
    private String type;

    @DatabaseField (columnName = "Q_ORDER")
    @SerializedName("order")
    private int order;

    public QQuestion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ForeignCollection<QAnswer> getAnswerForeignCollection() {
        return answerForeignCollection;
    }

    public void setAnswerForeignCollection(ForeignCollection<QAnswer> answerForeignCollection) {
        this.answerForeignCollection = answerForeignCollection;
    }


    public QuizModel getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizModel quiz) {
        this.quiz = quiz;
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
