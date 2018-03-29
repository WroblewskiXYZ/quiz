package pl.iosx.quiz4wp.model.data.runTimeData;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class QAnswer {

    protected int order;

    protected String text;

    protected boolean isCorrect;

    public QAnswer() {
    }

    public QAnswer(int order, String text, boolean isCorrect) {
        this.order = order;
        this.text = text;
        this.isCorrect = isCorrect;
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
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
