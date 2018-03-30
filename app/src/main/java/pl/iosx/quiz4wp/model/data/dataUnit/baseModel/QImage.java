package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "QUESTION_IMAGE")
public class QImage {

    @DatabaseField(id = true)
    private long id;

    @SerializedName("author")
    @DatabaseField (columnName = "AUTHOR")
    private String author;

    @SerializedName("source")
    @DatabaseField (columnName = "SOURCE")
    private String source;

    @SerializedName("url")
    @DatabaseField (columnName = "URL")
    private String url;

    @SerializedName("width")
    @DatabaseField (columnName = "WIDTH")
    private String width;

    @SerializedName("height")
    @DatabaseField (columnName = "HEIGHT")
    private String height;

    public QImage() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
