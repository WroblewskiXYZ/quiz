package pl.iosx.quiz4wp.model.data.dataUnit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 27.03.2018.
 */

public class ApiQuizContent {

    @SerializedName("rates")
    private List<QRate> rates;

    @SerializedName("questions")
    private List<QQuestion> questions;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("content")
    private String content;

    @SerializedName("id")
    private long id;

    @SerializedName("scripts")
    private String scripts;

    @SerializedName("mainPhoto")
    private QMainPhoto mainPhoto;

    @SerializedName("category")
    private QCategory category;

    @SerializedName("isBattle")
    private boolean isBattle;

    @SerializedName("created")
    private long created;

    @SerializedName("avgResult")
    private double avgResult;

    @SerializedName("resultCount")
    private int resultCount;

    @SerializedName("userBattleDone")
    private boolean userBattleDone;

    public ApiQuizContent() {
    }
}
