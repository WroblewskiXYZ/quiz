package pl.iosx.quiz4wp.model.data.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class SponsoredResult {

    @SerializedName("imageAuthor")
    private String imageAuthor;

    @SerializedName("imageHeight")
    private String imageHeight;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("imageWidth")
    private String imageWidth;

    @SerializedName("textColor")
    private String textColor;

    @SerializedName("content")
    private String content;

    @SerializedName("mainColor")
    private String mainColor;

    @SerializedName("imageSource")
    private String imageSource;

    public SponsoredResult(String imageAuthor, String imageHeight, String imageUrl, String imageWidth, String textColor, String content, String mainColor, String imageSource) {
        this.imageAuthor = imageAuthor;
        this.imageHeight = imageHeight;
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
        this.textColor = textColor;
        this.content = content;
        this.mainColor = mainColor;
        this.imageSource = imageSource;
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

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
