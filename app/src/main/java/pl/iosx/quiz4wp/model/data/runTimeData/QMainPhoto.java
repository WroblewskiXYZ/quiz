package pl.iosx.quiz4wp.model.data.runTimeData;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class QMainPhoto {

    protected String author;

    protected int width;

    protected int height;

    protected String source;

    protected String title;

    protected String url;

    protected int mediaId;

    public QMainPhoto() {
    }

    public QMainPhoto(String author, int width, int height, String source, String title, String url, int mediaId) {
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
