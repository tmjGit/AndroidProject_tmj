package li.tmj.dbclient.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import li.tmj.dbclient.db.model.Person;

public class DbWorkerMock extends DatabaseWorker{
        private SQLiteDatabase db;
        private DatabaseOpenHelper dbHelper;
        private static final String TAG = "**DatabaseWorker";

    public DbWorkerMock(SQLiteDatabase db) {
        super(db);
    }


        public long insertPerson(Person person) {
//            ContentValues values=new ContentValues();
//            values.put(DatabaseContract.PersonEntry.CLM_NAME_FAMILY,person.getNameFamily());
//            values.put(DatabaseContract.PersonEntry.CLM_NAME_INDIV,person.getNameIndividual());
//            values.put(DatabaseContract.PersonEntry.CLM_SEX,person.getSex());
//            values.put(DatabaseContract.PersonEntry.CLM_BIRTHDAY,person.getBirthDay());
//            values.put(DatabaseContract.PersonEntry.CLM_BIRTHMONTH,person.getBirthMonth());
//            values.put(DatabaseContract.PersonEntry.CLM_BIRTHYEAR,person.getBirthYear());
////        values.put(ImageEntry.COLUMN_BREEDER_ID,breederID);
//            long id= db.insert( // rowId
//                    DatabaseContract.PersonEntry.TABLE,
//                    null,
//                    values
//            );
//            if(0<id) {
//                person.setId(id);
//                //}else{
//                //Error writing to db!
//            }
            return 42;
        }


        public void open() {//(boolean readOnly){
//        if (readOnly) {
//            this.db = dbHelper.getReadableDatabase();
//        }else{
            this.db = dbHelper.getWritableDatabase();
//        }
            Log.d(TAG, "DB open");
        }

        public void close() {
            db.close();
            Log.d(TAG, "DB close");
        }


//        public Cursor fetchAllPersons(){
//            String table= DatabaseContract.PersonEntry.TABLE// Abzufragende Tabellen
//                    //+ " join " +BreederEntry.TABLE +" on " +ImageEntry.COLUMN_BREEDER_ID+"="+BreederEntry.TABLE+"."+BreederEntry._ID
//                    ;
//            String[] columns=new String[]{ // columns to be fetched
//                    DatabaseContract.PersonEntry._ID,
//                    DatabaseContract.PersonEntry.CLM_NAME_FAMILY,
//                    DatabaseContract.PersonEntry.CLM_NAME_INDIV,
//                    DatabaseContract.PersonEntry.CLM_SEX,
//                    DatabaseContract.PersonEntry.CLM_BIRTHDAY,
//                    DatabaseContract.PersonEntry.CLM_BIRTHMONTH,
//                    DatabaseContract.PersonEntry.CLM_BIRTHYEAR
//            };
//            String orderBy= DatabaseContract.PersonEntry.CLM_NAME_FAMILY;
//            Cursor cursor=db.query(table, columns,null,null,null,null,orderBy);
//            return cursor;
//        }

        public List<Person> loadAllPersons() {
            List<Person> list = new ArrayList<>();
            // Cursor cursor=fetchAllPersons();

            Person p = new Person();
            p.setId(1);
            p.setNameFamily("Dickson");
            p.setNameIndividual("Dick");
            p.setSex("männlich");
            p.setBirthDay(12);
            p.setBirthMonth(7);
            p.setBirthYear(1973);
            list.add(p);

            p = new Person();
            p.setId(2);
            p.setNameFamily("Tomson");
            p.setNameIndividual("Tom");
            p.setSex("männlich");
            p.setBirthDay(17);
            p.setBirthMonth(10);
            // p.setBirthYear(1993);
            list.add(p);

            p = new Person();
            p.setId(3);
            p.setNameFamily("Harrison");
            p.setNameIndividual("Harrietta");
            p.setSex("weiblich");
//        p.setBirthDay(12);
//        p.setBirthMonth(7);
//        p.setBirthYear(1973);
            list.add(p);

            return list;

        }
    }
