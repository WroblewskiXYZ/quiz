package pl.iosx.quiz4wp.model.data.runTimeData;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class QCategory {

    protected long id;
    protected String category;

    public QCategory() {
    }

    public QCategory(String category) {
        this.category = category;
    }

    public QCategory(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}