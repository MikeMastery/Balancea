package BDrecordatorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
public class DBasignarRecordatorio extends  BDrecord {
    Context context;

    public DBasignarRecordatorio(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long Insertarrecordatorio(String recordatorio, String fecha) {
        long id = 0;
        try {
            BDrecord dbhelper = new BDrecord(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("recordatorio", recordatorio);
            values.put("fecha", fecha);

            id = db.insert(TABLE_RECORDATORIO, null, values);


        } catch (Exception ex) {
            ex.toString();

        }
        return id;
    }





    public ArrayList<String> listarRecordatorios() {
        ArrayList<String> datos = new ArrayList<String>();
        BDrecord dbhelper = new BDrecord(context);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_RECORDATORIO;
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do{
                String reg= "id: "+c.getInt(0)+"\n"+
                        "recordatorio: "+c.getString(1)+"\n"+
                        "fecha: "+c.getString(2);
                datos.add(reg);
            }while (c.moveToNext());

        }


        db.close();
        return datos;
    }

}
