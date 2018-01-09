package li.tmj.dbclient.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import li.tmj.dbclient.db.DatabaseContract.PersonEntry;
import li.tmj.dbclient.db.model.Person;
//import li.tmj.dbclient.db.DatabaseContract.AddressEntry;

public class DatabaseWorker {
    private SQLiteDatabase db;
    private DatabaseOpenHelper dbHelper;
    private static final String TAG="**DatabaseWorker";

    public DatabaseWorker(SQLiteDatabase db){
        this.db=db;
    }

    public long insertPerson(Person person){
        ContentValues values=new ContentValues();
        values.put(PersonEntry.CLM_NAME_FAMILY,person.getNameFamily());
        values.put(PersonEntry.CLM_NAME_INDIV,person.getNameIndividual());
        values.put(PersonEntry.CLM_SEX,person.getSex());
        values.put(PersonEntry.CLM_BIRTHDAY,person.getBirthDay());
        values.put(PersonEntry.CLM_BIRTHMONTH,person.getBirthMonth());
        values.put(PersonEntry.CLM_BIRTHYEAR,person.getBirthYear());
//        values.put(ImageEntry.COLUMN_BREEDER_ID,breederID);
        long id= db.insert( // rowId
                PersonEntry.TABLE,
                null,
                values
                );
        if(0<id) {
            person.setId(id);
        //}else{
            //Error writing to db!
        }
        return id;
    }



    public void open(){//(boolean readOnly){
//        if (readOnly) {
//            this.db = dbHelper.getReadableDatabase();
//        }else{
        this.db=dbHelper.getWritableDatabase();
//        }
        Log.d(TAG,"DB open");
    }

    public void close(){
        db.close();
        Log.d(TAG,"DB close");
    }

//    public Cursor fetchByName(String partialName){
//        Cursor cursor=db.query(
//                DatabaseContract.NamesEntry.TABLE_NAME,
//                new String[]{
//                        DatabaseContract.NamesEntry._ID,
//                        DatabaseContract.NamesEntry.COLUMN_NAME
//                },
//                DatabaseContract.NamesEntry.COLUMN_NAME +" like ?",
//                new String[]{
//                        partialName
//                },
//                null,
//                null,
//                null
//        );
//        return cursor;
//    }
//
    public Cursor fetchAllPersons(){
        String table=PersonEntry.TABLE// Abzufragende Tabellen
            //+ " join " +BreederEntry.TABLE +" on " +ImageEntry.COLUMN_BREEDER_ID+"="+BreederEntry.TABLE+"."+BreederEntry._ID
                ;
        String[] columns=new String[]{ // columns to be fetched
                PersonEntry._ID,
                PersonEntry.CLM_NAME_FAMILY,
                PersonEntry.CLM_NAME_INDIV,
                PersonEntry.CLM_SEX,
                PersonEntry.CLM_BIRTHDAY,
                PersonEntry.CLM_BIRTHMONTH,
                PersonEntry.CLM_BIRTHYEAR
        };
        String orderBy=PersonEntry.CLM_NAME_FAMILY;
        Cursor cursor=db.query(table, columns,null,null,null,null,orderBy);
        return cursor;
    }

    public List<Person> loadAllPersons(){
        List<Person> list=new ArrayList<>();
        Cursor cursor=fetchAllPersons();
        while (cursor.moveToNext()){//Beim Lesen wird die Spaltennummer der jeweiligen Spalte im Resultset benötigt:
            Person person=new Person();
            person.setId( cursor.getInt( cursor.getColumnIndexOrThrow(PersonEntry._ID) ) );
            person.setNameFamily( cursor.getString( cursor.getColumnIndexOrThrow(PersonEntry.CLM_NAME_FAMILY) ) );
            person.setNameIndividual( cursor.getString( cursor.getColumnIndexOrThrow(PersonEntry.CLM_NAME_INDIV) ) );
            person.setSex( cursor.getString( cursor.getColumnIndexOrThrow(PersonEntry.CLM_SEX) ) );
            person.setBirthDay( cursor.getInt( cursor.getColumnIndexOrThrow(PersonEntry.CLM_BIRTHDAY) ) );
            person.setBirthMonth( cursor.getInt( cursor.getColumnIndexOrThrow(PersonEntry.CLM_BIRTHMONTH) ) );
            person.setBirthYear( cursor.getInt( cursor.getColumnIndexOrThrow(PersonEntry.CLM_BIRTHYEAR) ) );
            list.add(person);
        }
        return list;
    }

//    public void insertName(String name){
//        if(null==name || name.equals("")){
////                Toast.makeText(this, "Kein Text eingegeben", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        // direkt SQL per rawQuery wg. Sicherheit nicht empfohlen.
//        //Für Data Manipulation Language (DMS, update, insert, delete, ...) gibt es vorbereitete Methoden.
//        ContentValues values=new ContentValues();// Container für die Daten
//        values.put(DatabaseContract.NamesEntry.COLUMN_NAME,name);//key value Paare
//        long ID=db.insert(DatabaseContract.NamesEntry.TABLE_NAME,
//                null, // Hierdurch wird ggf. ein komplett leeres ContentValues mit einem Spaltennamen subsummiert.
//                values
//        );
////            Toast.makeText(this, "GespeichertName: "+name, Toast.LENGTH_SHORT).show();
//    }

    public String displayValue(long value){
        if(value==0) {
            return "";
        }else{
            return String.valueOf(value);
        }
    }

    public String displayValue(String value){
        if(null==value) {
            return "";
        }else{
            return value;
        }
    }


}
