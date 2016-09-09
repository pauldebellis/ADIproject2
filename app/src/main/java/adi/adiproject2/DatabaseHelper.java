package adi.adiproject2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by klaus_000 on 9/7/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mods.db";
    public static final String TABLE_NAME = "mods";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_ENDORSEMENTS = "endorsements";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_URL = "url";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+
            COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME+" TEXT, "+
            COLUMN_URL+" TEXT, "+
            COLUMN_CATEGORY+" TEXT, "+
            COLUMN_ENDORSEMENTS+" TEXT, "+
            COLUMN_DESCRIPTION+" TEXT)";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public static final String[] COLUMNS = {COLUMN_ID,COLUMN_NAME};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
//ADD MODS to DB
    public void addMod(String name, String endorsements, String category, String description, SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ENDORSEMENTS, endorsements);
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_DESCRIPTION, description);
        db.insert(TABLE_NAME, null, values);

    }

//GET MOD SUMMARY FOR CATEGORY DETAIL
    public Cursor getModSummary(SQLiteDatabase db){
        db = getReadableDatabase();
        String[] projection = new String[]{"_id", COLUMN_NAME, COLUMN_ENDORSEMENTS, COLUMN_CATEGORY, COLUMN_DESCRIPTION};
//        String selection = COLUMN_CATEGORY+" = ?";
//        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        cursor.moveToFirst();

        DatabaseUtils.dumpCursor(cursor);

        return cursor;
    }


//GET MOD INFO FOR DETAILED VIEW
    public Cursor getModDetailed(SQLiteDatabase db){
        db = getReadableDatabase();
        String[] projection = new String[]{"_id", COLUMN_ID, COLUMN_NAME, COLUMN_CATEGORY, COLUMN_ENDORSEMENTS, COLUMN_DESCRIPTION, COLUMN_URL};
//        String selection = COLUMN_ID+" = ?";
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        cursor.moveToFirst();

        return cursor;
    }

//    SEARCH MODS BY NAME, DESCRIPTION, CATEGORY, OR NUMBER OF ENDORSEMENTS
    public Cursor searchMods(String query){
        String[] searchCriteria = {COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_CATEGORY, COLUMN_ENDORSEMENTS};
        String[] columns = {"name"};
        String WHERE = COLUMN_NAME + " LIKE ?";
                //+" OR "+COLUMN_DESCRIPTION+" OR "+COLUMN_CATEGORY+" OR "+COLUMN_ENDORSEMENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, COLUMNS, WHERE, new String[]{"%" + query + "%"}, null, null, null, null);
        return cursor;
    }


}
