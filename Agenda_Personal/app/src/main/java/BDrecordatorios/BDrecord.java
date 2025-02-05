package BDrecordatorios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDrecord extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NOMBRE="BDrecordatorios";

    public static final String TABLE_RECORDATORIO ="recordatorios";

    public BDrecord(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_RECORDATORIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "recordatorio TEXT NOT NULL," +
                "fecha TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_RECORDATORIO);
        onCreate(db);

    }
}
