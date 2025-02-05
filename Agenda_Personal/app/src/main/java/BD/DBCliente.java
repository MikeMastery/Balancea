package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBCliente extends  DBHELPER {

    Context context;
    public DBCliente(@Nullable Context context) {
        super(context);

        this.context = context;
    }
    public long InsertarCliente(String nombres, String ciudad, String telefono, String email, String contraseña) {
        long id = 0;
        try {

            if (nombres.isEmpty() || ciudad.isEmpty() || telefono.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {

                return -1;
            }


            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                return -2;
            }


            DBHELPER dbhelper = new DBHELPER(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombres", nombres);
            values.put("ciudad", ciudad);
            values.put("telefono", telefono);
            values.put("email", email);
            values.put("contraseña", contraseña);

            id = db.insert(TABLE_CLIENTE, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}
