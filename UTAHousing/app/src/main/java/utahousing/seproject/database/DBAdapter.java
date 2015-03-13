package utahousing.seproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 3/12/2015.
 */
public class DBAdapter {

    public static final String TABLE_LOGIN="login";

    public static final String columnMyMavUserId="myMavUserId";
    public static final String columnPassword="password";
    public static String CREATE_LOGIN_TABLE="create table " + TABLE_LOGIN + "(" + columnMyMavUserId +" text primary key," + columnPassword +" text)";
    public SQLiteDatabase db;
    private final Context context;
    private DBHelper dbHelper;

    public DBAdapter(Context context){
        this.context=context;
        dbHelper=DBHelper.getInstance(context);
    }

    public boolean isLoginSuccessful(String myMavUserId, String password){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        Cursor cursor=db.query(TABLE_LOGIN,null,columnMyMavUserId+"=? and "+columnPassword+"=?",new String[]{myMavUserId,password},null,null,null);
        if(cursor.getCount()<1){
            cursor.close();
            db.close();
            return false;
        }
        db.close();
        return true;
    }
}