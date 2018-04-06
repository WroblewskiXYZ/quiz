package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "ANSWER")
public class QAnswer {

    public static final int ANSWER_CORRECT = 1;

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(columnName = "QUESTION_ID", canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private QQuestion question;

    @SerializedName("order")
    @DatabaseField (columnName = "PARAM_ORDER")
    private int order;

    @SerializedName("text")
    @DatabaseField (columnName = "A_TEXT")
    private String text;

    @SerializedName("isCorrect")
    @DatabaseField (columnName = "IS_CORRECT")
    private int isCorrect;

    public QAnswer() {

    }

    public QAnswer(int order, String text, int isCorrect) {
        this.order = order;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public QAnswer getNew()
    {
        return new QAnswer(order,text,isCorrect);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QQuestion getQuestion() {
        return question;
    }

    public void setQuestion(QQuestion question) {
        this.question = question;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect()
    {
        return isCorrect == ANSWER_CORRECT;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
