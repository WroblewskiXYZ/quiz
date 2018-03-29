package pl.iosx.quiz4wp.model.data.apiData.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class Answer {

    @SerializedName("image")
    private QImage image;

    @SerializedName("order")
    private int order;

    @SerializedName("text")
    private String text;

    @SerializedName("isCorrect")
    private int isCorrect;

    public Answer(QImage image, int order, String text, int isCorrect) {
        this.image = image;
        this.order = order;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public QImage getImage() {
        return image;
    }

    public void setImage(QImage image) {
        this.image = image;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect==0;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
