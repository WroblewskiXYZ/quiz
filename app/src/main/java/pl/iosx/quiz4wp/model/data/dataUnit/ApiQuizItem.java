package pl.iosx.quiz4wp.model.data.dataUnit;

import com.google.gson.annotations.SerializedName;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class ApiQuizItem {

    @SerializedName("buttonStart")
    private String buttonStart;

    @SerializedName("shareTitle")
    private String shareTitle;

    @SerializedName("questionCount")
    private int questionCount;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("sponsored")
    private boolean sponsored;

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("content")
    private String content;

    @SerializedName("mainPhoto")
    private QMainPhoto mainPhoto;

    @SerializedName("category")
    private QCategory category;

    public ApiQuizItem() {
    }

    public String getButtonStart() {
        return buttonStart;
    }

    public void setButtonStart(String buttonStart) {
        this.buttonStart = buttonStart;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public QCategory getCategory() {
        return category;
    }

    public void setCategory(QCategory category) {
        this.category = category;
    }
}
