package pl.iosx.quiz4wp.model.data.apiData.quiz;


import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class Tag {

    @SerializedName("uid")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;

    public Tag(long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
