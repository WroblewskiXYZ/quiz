package pl.iosx.quiz4wp.model.data.quiz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class Quiz {

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

    @SerializedName("categories")
    private List<ExCategory> categories;

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

    public Quiz(String buttonStart, String shareTitle, int questions, String createdAt, boolean sponsored, List<ExCategory> categories, String title, String type, String content, MainPhoto mainPhoto, List<Tag> tags, Category category) {
        this.buttonStart = buttonStart;
        this.shareTitle = shareTitle;
        this.questions = questions;
        this.createdAt = createdAt;
        this.sponsored = sponsored;
        this.categories = categories;
        this.title = title;
        this.type = type;
        this.content = content;
        this.mainPhoto = mainPhoto;
        this.tags = tags;
        this.category = category;
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

    public List<ExCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ExCategory> categories) {
        this.categories = categories;
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
