package pl.iosx.quiz4wp.model.data.dataUnit.baseModel;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Comparator;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable (tableName = "CATEGORY")
public class QCategory implements Comparable<QCategory>{

    @DatabaseField(id = true)
    @SerializedName("id")
    private long id;

    @DatabaseField(columnName = "CATEGORY_NAME")
    @SerializedName("name")
    private String name;

    public QCategory() {
    }

    public QCategory(String name) {
        this.name = name;
    }

    public QCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public QCategory getNew()
    {
        return new QCategory(id, name);
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

    @Override
    public int compareTo(@NonNull QCategory qCategory) {
        if(id == qCategory.id) return 0;
        else if( id> qCategory.id) return 1;
        else return -1;
    }
}