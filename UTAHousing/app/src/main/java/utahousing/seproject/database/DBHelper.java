package utahousing.seproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 3/11/2015.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static DBHelper instance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="UtaHousingDB.db";

    private DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBAdapter.CREATE_LOGIN_TABLE);
        populateLoginTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBAdapter.TABLE_LOGIN);
        onCreate(db);
    }

    private void populateLoginTable(SQLiteDatabase db){
        List<LoginDAO> users=new ArrayList<LoginDAO>();
        users.add(new LoginDAO("nxj1234","password123"));
        users.add(new LoginDAO("jxt1234","password123"));
        users.add(new LoginDAO("sxk1234","password123"));
        users.add(new LoginDAO("rxc1234","password123"));
        users.add(new LoginDAO("nxl1234","password123"));
        db.beginTransaction();
        for (LoginDAO user:users){
            ContentValues row=new ContentValues();
            row.put(DBAdapter.columnMyMavUserId,user.getMyMavUserId());
            row.put(DBAdapter.columnPassword,user.getPassword());
            db.insert(DBAdapter.TABLE_LOGIN,null,row);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}