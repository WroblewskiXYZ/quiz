package pl.iosx.quiz4wp.model.data.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class Celebrity {

    @SerializedName("result")
    private String result;

    @SerializedName("imageAuthor")
    private String imageAuthor;

    @SerializedName("imageHeight")
    private String imageHeight;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("show")
    private int show;

    @SerializedName("name")
    private String name;

    @SerializedName("imageTitle")
    private String imageTitle;

    @SerializedName("imageWidth")
    private String imageWidth;

    @SerializedName("content")
    private String content;

    @SerializedName("imageSource")
    private String imageSource;

    public Celebrity(String result, String imageAuthor, String imageHeight, String imageUrl, int show, String name, String imageTitle, String imageWidth, String content, String imageSource) {
        this.result = result;
        this.imageAuthor = imageAuthor;
        this.imageHeight = imageHeight;
        this.imageUrl = imageUrl;
        this.show = show;
        this.name = name;
        this.imageTitle = imageTitle;
        this.imageWidth = imageWidth;
        this.content = content;
        this.imageSource = imageSource;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImageAuthor() {
        return imageAuthor;
    }

    public void setImageAuthor(String imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
