package pl.iosx.quiz4wp.model.services.DbManager;

import android.content.Context;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class DbManager {

    private Context context;
    MyDatabaseHelper myDatabaseHelper;
    ConnectionSource connectionSource;

    public DbManager(Context context)
    {
        this.context = context;
        this.myDatabaseHelper = new MyDatabaseHelper(context);
        this.connectionSource = new AndroidConnectionSource(myDatabaseHelper);
    }

    public MyDatabaseHelper getMyDatabaseHelper() {
        return myDatabaseHelper;
    }

    public void setMyDatabaseHelper(MyDatabaseHelper myDatabaseHelper) {
        this.myDatabaseHelper = myDatabaseHelper;
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }
}
