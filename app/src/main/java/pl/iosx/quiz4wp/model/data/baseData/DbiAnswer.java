package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import pl.iosx.quiz4wp.model.data.apiData.quizContent.Question;
import pl.iosx.quiz4wp.model.data.runTimeData.QAnswer;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "ANSWER")
public class DbiAnswer{

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(columnName = "QUESTION_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private DbiQuestion question;

    @DatabaseField (columnName = "PARAM_ORDER")
    private int order;

    @DatabaseField (columnName = "A_TEXT")
    private String text;

    @DatabaseField (columnName = "IS_CORRECT")
    private boolean isCorrect;


    public DbiAnswer() {

    }

    public DbiAnswer(int order, String text, boolean isCorrect) {
        this.order = order;
        this.text = text;
        this.isCorrect = isCorrect;
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public DbiQuestion getQuestion() {
        return question;
    }

    public void setQuestion(DbiQuestion question) {
        this.question = question;
    }
}
