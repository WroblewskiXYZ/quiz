package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import pl.iosx.quiz4wp.model.data.apiData.quizContent.Answer;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "QUESTION_ITEM")
public class DbiQuestion {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(columnName = "QUIZ_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private DbiQuiz quiz;

    @DatabaseField (columnName = "QUESTION_IMAGE_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private DbiQImage qImage;



    @ForeignCollectionField(columnName = "ANSWER_ID")
    private ForeignCollection<DbiAnswer> answers;

    @DatabaseField (columnName = "Q_TEXT")
    private String text;

    @DatabaseField (columnName = "ANSWER")
    private String answer;

    @DatabaseField (columnName = "Q_TYPE")
    private String type;

    @DatabaseField (columnName = "Q_ORDER")
    private String order;

    public DbiQuestion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DbiQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(DbiQuiz quiz) {
        this.quiz = quiz;
    }

    public DbiQImage getqImage() {
        return qImage;
    }

    public void setqImage(DbiQImage qImage) {
        this.qImage = qImage;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public ForeignCollection<DbiAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(ForeignCollection<DbiAnswer> answers) {
        this.answers = answers;
    }
}
