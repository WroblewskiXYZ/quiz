package pl.iosx.quiz4wp.model.data.apiData.quiz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class QuizItem {

    @SerializedName("buttonStart")
    private String buttonStart;

    @SerializedName("shareTitle")
    private String shareTitle;

    @SerializedName("questions")
    private int questions;

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
    private MainPhoto mainPhoto;

    @SerializedName("tags")
    List<Tag> tags;

    @SerializedName("category")
    private Category category;

    public QuizItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
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

    public MainPhoto getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(MainPhoto mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
