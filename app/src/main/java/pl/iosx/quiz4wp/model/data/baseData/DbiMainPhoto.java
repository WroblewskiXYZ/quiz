package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "MAIN_PHOTO")
public class DbiMainPhoto {

    @DatabaseField(id = true)
    private long id;

    @DatabaseField (columnName = "AUTHOR")
    private String author;

    @DatabaseField (columnName = "SOURCE")
    private String source;

    @DatabaseField (columnName = "TITLE")
    private String title;

    @DatabaseField (columnName = "URL")
    private String url;

    @DatabaseField (columnName = "WIDTH")
    private String width;

    @DatabaseField (columnName = "HEIGHT")
    private String height;

    public DbiMainPhoto() {
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
