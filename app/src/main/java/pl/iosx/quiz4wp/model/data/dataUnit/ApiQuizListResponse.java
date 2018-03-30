package pl.iosx.quiz4wp.model.data.dataUnit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class ApiQuizListResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<ApiQuizItem> apiQuizItemItems;

    public ApiQuizListResponse(int count, List<ApiQuizItem> apiQuizItemItems) {
        this.count = count;
        this.apiQuizItemItems = apiQuizItemItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ApiQuizItem> getApiQuizItemItems() {
        return apiQuizItemItems;
    }

    public void setApiQuizItemItems(List<ApiQuizItem> apiQuizItemItems) {
        this.apiQuizItemItems = apiQuizItemItems;
    }
}
