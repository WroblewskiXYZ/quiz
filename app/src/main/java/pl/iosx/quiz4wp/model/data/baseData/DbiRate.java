package pl.iosx.quiz4wp.model.data.baseData;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.iosx.quiz4wp.model.data.runTimeData.QRate;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

@DatabaseTable(tableName = "RATE")
public class DbiRate extends QRate{

    @DatabaseField(id = true)
    private long id;

    @DatabaseField (columnName = "PARAM_FROM")
    private int from;

    @DatabaseField (columnName = "PARAM_TO")
    private int to;

    @DatabaseField (columnName = "CONTENT")
    private String content;

    public DbiRate() {
    }

    public DbiRate(int from, int to, String content) {
        super(from, to, content);
    }
}
