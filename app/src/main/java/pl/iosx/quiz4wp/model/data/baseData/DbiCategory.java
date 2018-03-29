package pl.iosx.quiz4wp.model.data.baseData;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable (tableName = "CATEGORY")
public class DbiCategory {

    @DatabaseField(id = true)
    @SerializedName("id")
    private long id;

    @DatabaseField(columnName = "CATEGORY_NAME")
    @SerializedName("name")
    private String name;

    public DbiCategory() {
    }

    public DbiCategory(String name) {
        this.name = name;
    }

    public DbiCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}