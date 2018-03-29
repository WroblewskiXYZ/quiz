package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "QUESTION_IMAGE")
public class DbiQImage {

    @DatabaseField(id = true)
    private long id;

    @DatabaseField (columnName = "AUTHOR")
    private String author;

    @DatabaseField (columnName = "SOURCE")
    private String source;

    @DatabaseField (columnName = "MEDIA_ID")
    private long mediaId;

    @DatabaseField (columnName = "URL")
    private String url;

    @DatabaseField (columnName = "WIDTH")
    private String width;

    @DatabaseField (columnName = "HEIGHT")
    private String height;

    public DbiQImage() {
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

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
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
