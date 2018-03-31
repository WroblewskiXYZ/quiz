package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "MAIN_PHOTO")
public class QMainPhoto {

    @DatabaseField(generatedId = true)
    private long id;

    @SerializedName("author")
    @DatabaseField (columnName = "AUTHOR")
    private String author;

    @SerializedName("source")
    @DatabaseField (columnName = "SOURCE")
    private String source;

    @SerializedName("title")
    @DatabaseField (columnName = "TITLE")
    private String title;

    @SerializedName("url")
    @DatabaseField (columnName = "URL")
    private String url;

    @SerializedName("width")
    @DatabaseField (columnName = "WIDTH")
    private int width;

    @SerializedName("height")
    @DatabaseField (columnName = "HEIGHT")
    private int height;

    public QMainPhoto() {
    }

    public QMainPhoto(long id, String author, String source, String title, String url, int width, int height) {
        this.id = id;
        this.author = author;
        this.source = source;
        this.title = title;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public QMainPhoto getNew()
    {
        return new QMainPhoto(id,author,source, title, url, width,height);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
