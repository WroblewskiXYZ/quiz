package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable (tableName = "CATEGORY")
public class DbiCategory {

    @DatabaseField(id = true)
    private long id;

    @DatabaseField(columnName = "CATEGORY_NAME")
    private String category;

    public DbiCategory() {
    }

    public DbiCategory(String category) {
        this.category = category;
    }

    public DbiCategory(long id, String category) {
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