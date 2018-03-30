package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "RATE")
public class QRate {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(columnName = "QUIZ_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private QuizModel quiz;

    @SerializedName("from")
    @DatabaseField (columnName = "PARAM_FROM")
    private int from;

    @SerializedName("to")
    @DatabaseField (columnName = "PARAM_TO")
    private int to;

    @SerializedName("content")
    @DatabaseField (columnName = "CONTENT")
    private String content;

    public QRate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
