package utahousing.seproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 3/11/2015.
 */
public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="UtaHousingDB.db";
    private static final String TABLE_LOGIN="login";

    private static final String columnMyMavUserId="myMavUserId";
    private static final String columnPassword="password";

    public DBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE="create table " + TABLE_LOGIN + "(" + columnMyMavUserId +"text primary key," + columnPassword +"text)";
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(db);
    }

    public void populateLoginTable(){
        List<LoginDAO> users=new ArrayList<LoginDAO>();
        users.add(new LoginDAO("nxj1234","password123"));
        users.add(new LoginDAO("jxt1234","password123"));
        users.add(new LoginDAO("sxk1234","password123"));
        users.add(new LoginDAO("rxc1234","password123"));
        users.add(new LoginDAO("nxl1234","password123"));
        SQLiteDatabase db=this.getWritableDatabase();
        db.beginTransaction();
        for (LoginDAO user:users){
            ContentValues row=new ContentValues();
            row.put(columnMyMavUserId,user.getMyMavUserId());
            row.put(columnPassword,user.getPassword());
            db.insert(TABLE_LOGIN,null,row);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
