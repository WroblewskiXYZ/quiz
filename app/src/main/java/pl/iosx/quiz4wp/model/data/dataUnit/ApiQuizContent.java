package pl.iosx.quiz4wp.model.data.dataUnit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class ApiQuizContent {

    @SerializedName("rates")
    private List<QRate> rates;

    @SerializedName("questions")
    private List<QQuestion> questions;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("content")
    private String content;

    @SerializedName("id")
    private long id;

    @SerializedName("scripts")
    private String scripts;

    @SerializedName("mainPhoto")
    private QMainPhoto mainPhoto;

    @SerializedName("category")
    private QCategory category;

    @SerializedName("isBattle")
    private boolean isBattle;

    @SerializedName("created")
    private long created;

    @SerializedName("avgResult")
    private double avgResult;

    @SerializedName("resultCount")
    private int resultCount;

    @SerializedName("userBattleDone")
    private boolean userBattleDone;

    public ApiQuizContent() {
    }

    public List<QRate> getRates() {
        return rates;
    }

    public void setRates(List<QRate> rates) {
        this.rates = rates;
    }

    public List<QQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QQuestion> questions) {
        this.questions = questions;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScripts() {
        return scripts;
    }

    public void setScripts(String scripts) {
        this.scripts = scripts;
    }

    public QMainPhoto getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(QMainPhoto mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public QCategory getCategory() {
        return category;
    }

    public void setCategory(QCategory category) {
        this.category = category;
    }

    public boolean isBattle() {
        return isBattle;
    }

    public void setBattle(boolean battle) {
        isBattle = battle;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
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
}
