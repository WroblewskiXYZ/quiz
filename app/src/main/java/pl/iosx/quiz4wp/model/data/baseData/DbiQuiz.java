package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable (tableName = "QUIZ_ITEM")
public class DbiQuiz {

    @DatabaseField(id = true)
    private long id;

    @DatabaseField (columnName = "QUESTION_SIZE")
    private int questionsSize;

    public int getQuestionsSize() {
        return questionsSize;
    }

    public void setQuestionsSize(int questionsSize) {
        this.questionsSize = questionsSize;
    }

    public ForeignCollection<DbiQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ForeignCollection<DbiQuestion> questions) {
        this.questions = questions;
    }

    @ForeignCollectionField
    private ForeignCollection<DbiQuestion> questions;

    @DatabaseField (columnName = "CREATED_AT", dataType = DataType.DATE_LONG)
    private Date created;

    //@DatabaseField
    //private List<ExCategory> categories;

    @DatabaseField(columnName = "TITLE")
    private String title;

    @DatabaseField(columnName = "TYPE")
    private String type;

    @DatabaseField(columnName = "CONTENT")
    private String content;

    //@SerializedName("mainPhoto")
    //private MainPhoto mainPhoto;

    @DatabaseField(columnName = "BATTLE")
    private boolean isBattle;

    @DatabaseField(columnName = "CATEGORY_ID", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private DbiCategory category;

    @DatabaseField(columnName = "AVG_RESULT")
    private double avgResult;

    @DatabaseField(columnName = "RESULT_COUNT")
    private int resultCount;

    @DatabaseField(columnName = "USE_BATTLE_DONE")
    private boolean userBattleDone;

    public DbiQuiz()
    {

    }

    public DbiQuiz(long id, int questionsSize, Date created, String title, String type, String content, boolean isBattle, DbiCategory category, double avgResult, int resultCount, boolean userBattleDone) {
        this.id = id;
        this.questionsSize = questionsSize;
        this.created = created;
        this.title = title;
        this.type = type;
        this.content = content;
        this.isBattle = isBattle;
        this.category = category;
        this.avgResult = avgResult;
        this.resultCount = resultCount;
        this.userBattleDone = userBattleDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBattle() {
        return isBattle;
    }

    public void setBattle(boolean battle) {
        isBattle = battle;
    }

    public double getAvgResult() {
        return avgResult;
    }

    public void setAvgResult(double avgResult) {
        this.avgResult = avgResult;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public boolean isUserBattleDone() {
        return userBattleDone;
    }

    public void setUserBattleDone(boolean userBattleDone) {
        this.userBattleDone = userBattleDone;
    }

    public DbiCategory getCategory() {
        return category;
    }

    public void setCategory(DbiCategory category) {
        this.category = category;
    }
}
