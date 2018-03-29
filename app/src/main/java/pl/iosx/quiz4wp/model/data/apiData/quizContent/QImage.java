package pl.iosx.quiz4wp.model.data.apiData.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class QImage {

    @SerializedName("author")
    private String author;

    @SerializedName("width")
    private String width;

    @SerializedName("mediaId")
    private String mediaId;

    @SerializedName("source")
    private String source;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private String height;

    public QImage(String author, String width, String mediaId, String source, String url, String height) {
        this.author = author;
        this.width = width;
        this.mediaId = mediaId;
        this.source = source;
        this.url = url;
        this.height = height;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
