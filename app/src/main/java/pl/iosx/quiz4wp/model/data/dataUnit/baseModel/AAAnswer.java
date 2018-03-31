package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "ANSWERAA")
public class AAAnswer {

    @DatabaseField(generatedId = true)
    private long id;


    @SerializedName("order")
    @DatabaseField (columnName = "PARAM_ORDER")
    private int order;

    @SerializedName("text")
    @DatabaseField (columnName = "A_TEXT")
    private String text;

    @SerializedName("isCorrect")
    @DatabaseField (columnName = "IS_CORRECT")
    private int isCorrect;

    public AAAnswer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
