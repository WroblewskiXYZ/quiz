package pl.iosx.quiz4wp.model.data.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class Rate {

    @SerializedName("from")
    private int from;

    @SerializedName("to")
    private int to;

    @SerializedName("content")
    private String content;

    public Rate(int from, int to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
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
