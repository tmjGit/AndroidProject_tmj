package li.tmj.dbclient.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
        private static final String DB_NAME= "database";
        private static final int DB_VERSION=1;// Erlaubt den Abgleich, falls sich das DB Schema ändert, sollte man hochzählen.

        public DatabaseOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // onCreate wird nicht beim Erzeugen dieser Klasse, sondern beim Erzeugen (bei Bedarf=erster Zugriff) der Datenbank ausgelöst!
            db.execSQL(DatabaseContract.PersonEntry.CREATE_TABLE);
            //db.execSQL(DatabaseContract.ImageEntry.CREATE_TABLE);
            DatabaseWorker worker=new DatabaseWorker(db);
            new DatabaseInitializer(worker);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
