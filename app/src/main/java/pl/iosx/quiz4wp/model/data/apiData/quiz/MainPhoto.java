package pl.iosx.quiz4wp.model.data.apiData.quiz;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class MainPhoto {

    @SerializedName("author")
    private String author;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("source")
    private String source;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("media_id")
    private int mediaId;

    public MainPhoto(String author, int width, int height, String source, String title, String url, int mediaId) {
        this.author = author;
        this.width = width;
        this.height = height;
        this.source = source;
        this.title = title;
        this.url = url;
        this.mediaId = mediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }
}
