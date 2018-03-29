package pl.iosx.quiz4wp.model.data.apiData.quiz;

import com.google.gson.annotations.SerializedName;

import pl.iosx.quiz4wp.model.data.runTimeData.QCategory;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class Category{

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    public Category(long id, String name) {
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
