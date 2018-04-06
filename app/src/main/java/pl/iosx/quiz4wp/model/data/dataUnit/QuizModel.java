package pl.iosx.quiz4wp.model.data.dataUnit;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collections;
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

    @DatabaseField (columnName = "QUESTIONSIZE")
    private int questionsSize;

    @DatabaseField (columnName = "QUESTIONDONE")
    private int questionsDone;

    @DatabaseField (columnName = "QUESTIONPOINTS")
    private int questionsPoints;

    @ForeignCollectionField
    private ForeignCollection<QQuestion> questionForeignCollection;

    private List<QQuestion> questions;

    @DatabaseField (columnName = "CREATED", dataType = DataType.DATE_LONG)
    private Date created;

    @DatabaseField(columnName = "TITLE")
    private String title;

    @DatabaseField(columnName = "TYPE")
    private String type;

    @DatabaseField(columnName = "CONTENT")
    private String content;

    @DatabaseField(columnName = "MAINPHOTO", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private QMainPhoto mainPhoto;

    @DatabaseField(columnName = "BATTLE")
    private boolean isBattle;

    @DatabaseField(columnName = "CATEGORY_ID", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private QCategory category;

    @DatabaseField(columnName = "AVGRESULT")
    private double avgResult;

    @DatabaseField(columnName = "RESULTCOUNT")
    private int resultCount;

    @DatabaseField(columnName = "USEBATTLEDONE")
    private boolean userBattleDone;

    @DatabaseField(columnName = "DOWNLOADSTATUS")
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
    }

    public QuizModel(ApiQuizItem item)
    {
        update(item);
    }

    public QuizModel(long id, int questionsSize, int questionsDone, int questionsPoints, ForeignCollection<QQuestion> questionForeignCollection, List<QQuestion> questions, Date created, String title, String type, String content, QMainPhoto mainPhoto, boolean isBattle, QCategory category, double avgResult, int resultCount, boolean userBattleDone, boolean isDownloaded, ForeignCollection<QRate> rateForeignCollection, List<QRate> rates) {
        this.id = id;
        this.questionsSize = questionsSize;
        this.questionsDone = questionsDone;
        this.questionsPoints = questionsPoints;
        this.questionForeignCollection = questionForeignCollection;
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
        this.isDownloaded = isDownloaded;
        this.rateForeignCollection = rateForeignCollection;
        this.rates = rates;
    }

    public QuizModel getNew()
    {
        return new QuizModel(id,questionsSize,questionsDone,questionsPoints,null, null,created,title,type,content,null,isBattle,null,avgResult,resultCount,userBattleDone, isDownloaded,null,null);
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
        this.questionsSize = questions.size();
        this.isDownloaded = true;
    }

    public void updateLists() {
        updateRateList();
        updateQuestionList();
    }

    private void updateRateList()
    {
        rates = new ArrayList<>();
        if(rateForeignCollection!=null && rateForeignCollection.size()>0)
        {
            for(QRate rate : rateForeignCollection)
            {
                rates.add(rate);
            }
        }
    }

    private void updateQuestionList()
    {
        questions = new ArrayList<>();
        if(questionForeignCollection!=null && questionForeignCollection.size()>0)
        {
            for(QQuestion question : questionForeignCollection)
            {
                question.updateLists();
                questions.add(question);
            }
        }
        Collections.sort(questions);
    }

    public void onQuestionDone(boolean isCorrect)
    {
        questionsDone++;
        if(isCorrect)questionsPoints++;
    }

    public boolean isDone()
    {
        return questionsSize>0 && questionsSize == questionsDone;
    }

    public int getPercentageProgress()
    {
        return (questionsDone*100)/questionsSize;
    }

    public int getPercentageScore()
    {
        return (questionsPoints*100)/questionsSize;
    }

    public void resetScore()
    {
        questionsDone = 0;
        questionsPoints = 0;
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

    public int getQuestionsDone() {
        return questionsDone;
    }

    public void setQuestionsDone(int questionsDone) {
        this.questionsDone = questionsDone;
    }

    public int getQuestionsPoints() {
        return questionsPoints;
    }

    public void setQuestionsPoints(int questionsPoints) {
        this.questionsPoints = questionsPoints;
    }


}
