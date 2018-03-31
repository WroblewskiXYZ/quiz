package pl.iosx.quiz4wp.model.data.dataUnit;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
import java.util.List;

import pl.iosx.quiz4wp.model.data.DataConverter;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable (tableName = "QUIZ_ITEM")
public class QuizModel {

    @DatabaseField(id = true)
    private long id;

    @DatabaseField (columnName = "QUESTION_SIZE")
    private int questionsSize;

    @ForeignCollectionField
    private ForeignCollection<QQuestion> questionForeignCollection;

    private List<QQuestion> questions;

    @DatabaseField (columnName = "CREATED_AT", dataType = DataType.DATE_LONG)
    private Date created;

    @DatabaseField(columnName = "TITLE")
    private String title;

    @DatabaseField(columnName = "TYPE")
    private String type;

    @DatabaseField(columnName = "CONTENT")
    private String content;

    @DatabaseField(columnName = "MAIN_PHOTO_ID", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private QMainPhoto mainPhoto;

    @DatabaseField(columnName = "BATTLE")
    private boolean isBattle;

    @DatabaseField(columnName = "CATEGORY_ID", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private QCategory category;

    @DatabaseField(columnName = "AVG_RESULT")
    private double avgResult;

    @DatabaseField(columnName = "RESULT_COUNT")
    private int resultCount;

    @DatabaseField(columnName = "USE_BATTLE_DONE")
    private boolean userBattleDone;

    @DatabaseField(columnName = "DOWNLOAD_STATUS")
    private boolean isDownloaded;

    public ForeignCollection<QRate> getRateForeignCollection() {
        return rateForeignCollection;
    }

    public void setRateForeignCollection(ForeignCollection<QRate> rateForeignCollection) {
        this.rateForeignCollection = rateForeignCollection;
    }

    @ForeignCollectionField
    private ForeignCollection<QRate> rateForeignCollection;

    private List<QRate> rates;

    public QuizModel()
    {
        isDownloaded = false;
    }

    public QuizModel(ApiQuizItem item)
    {
        update(item);
    }

    public QuizModel(long id, int questionsSize, List<QQuestion> questions, Date created, String title, String type, String content, QMainPhoto mainPhoto, boolean isBattle, QCategory category, double avgResult, int resultCount, boolean userBattleDone) {
        this.id = id;
        this.questionsSize = questionsSize;
        this.questions = questions;
        this.created = created;
        this.title = title;
        this.type = type;
        this.content = content;
        this.mainPhoto = mainPhoto;
        this.isBattle = isBattle;
        this.category = category;
        this.avgResult = avgResult;
        this.resultCount = resultCount;
        this.userBattleDone = userBattleDone;
    }

    public QuizModel getNew()
    {
        return new QuizModel(id,questionsSize,null,created,title,type,content,null,isBattle,null,avgResult,resultCount,userBattleDone);
    }

    public void update(ApiQuizItem item)
    {
        this.id = item.getId();
        this.questionsSize = item.getQuestionCount();
        this.created = DataConverter.getDateFromDateString(item.getCreatedAt());
        this.title = item.getTitle();
        this.type = item.getType();
        this.content = item.getContent();
        this.mainPhoto = item.getMainPhoto();
        this.category = item.getCategory();

        this.questions = null;
        this.isBattle = false;
        this.avgResult = 0;
        this.resultCount = 0;
        this.userBattleDone = false;
        this.rates = null;

        this.isDownloaded = false;
    }

    public void update(ApiQuizContent content)
    {
        this.id = content.getId();
        this.questions = content.getQuestions();
        this.created = DataConverter.getDateFromDateString(content.getCreatedAt());
        this.title = content.getTitle();
        this.type = content.getType();
        this.content = content.getContent();
        this.mainPhoto = content.getMainPhoto();

        //this.category = content.getCategory();
        this.isBattle = content.isBattle();
        this.avgResult = content.getAvgResult();
        this.resultCount = content.getResultCount();
        this.userBattleDone = content.isUserBattleDone();

        this.rates = content.getRates();

        if(questions!=null)
        {
            this.questionsSize = questions.size();
            this.isDownloaded = true;
        }
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuestionsSize() {
        return questionsSize;
    }

    public void setQuestionsSize(int questionsSize) {
        this.questionsSize = questionsSize;
    }

    public ForeignCollection<QQuestion> getQuestionForeignCollection() {
        return questionForeignCollection;
    }

    public void setQuestionForeignCollection(ForeignCollection<QQuestion> questionForeignCollection) {
        this.questionForeignCollection = questionForeignCollection;
    }

    public List<QQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QQuestion> questions) {
        this.questions = questions;
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

    public QMainPhoto getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(QMainPhoto mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public boolean isBattle() {
        return isBattle;
    }

    public void setBattle(boolean battle) {
        isBattle = battle;
    }

    public QCategory getCategory() {
        return category;
    }

    public void setCategory(QCategory category) {
        this.category = category;
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

    public List<QRate> getRates() {
        return rates;
    }

    public void setRates(List<QRate> rates) {
        this.rates = rates;
    }
}
