package pl.iosx.quiz4wp.model.data.quizContent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class LastResult {

    @SerializedName("city")
    private int city;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("result")
    private double result;

    @SerializedName("resolveTime")
    private int resolveTime;

    public LastResult(int city, String endDate, double result, int resolveTime) {
        this.city = city;
        this.endDate = endDate;
        this.result = result;
        this.resolveTime = resolveTime;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(int resolveTime) {
        this.resolveTime = resolveTime;
    }
}
