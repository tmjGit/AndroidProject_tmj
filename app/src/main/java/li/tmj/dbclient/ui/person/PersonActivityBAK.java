package li.tmj.dbclient.ui.person;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import li.tmj.dbclient.R;
import li.tmj.dbclient.db.DatabaseOpenHelper;
import li.tmj.dbclient.db.DatabaseWorker;
import li.tmj.dbclient.db.model.Person;

//import android.support.v4.content.CursorLoader;
//import android.support.v4.content.Loader;

public class PersonActivityBAK extends AppCompatActivity{
        //implements LoaderManager.LoaderCallbacks<Cursor> {// Generic: Rückgabetyp des Threads, der auf die DB zugreift
    private static final int ID_LOADER_PERSONS = 42;
    private RecyclerView recycler;
    private DatabaseOpenHelper helper;
    private DatabaseWorker worker;
    private Cursor animalCursor;
   // private PersonRecyclerViewAdapter adapter;
   //private EditText inputFld;
    private Button saveBt;
    ListView listV;
    EditText nameIndivFld,nameFamilyFld,birthDayFld,birthMonthFld,birthYearFld;
    TextView idT;
    Spinner sexCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personsactivity);

        //inputFld=findViewById(R.id.name_indiv_fld);
        saveBt=findViewById(R.id.save_bt);
//        listV=findViewById(R.id.list_v);
        nameFamilyFld=findViewById(R.id.name_fam_fld);
        nameIndivFld=findViewById(R.id.name_indiv_fld);
        sexCb=findViewById(R.id.sex_cb);
        birthDayFld=findViewById(R.id.birthday_fld);
        birthMonthFld=findViewById(R.id.birthmonth_fld);
        birthYearFld=findViewById(R.id.birthyear_fld);
        idT=findViewById(R.id.id2_t);

        helper=new DatabaseOpenHelper(this);

        recycler=findViewById(R.id.acmain_rec_lst);
        initializeWorker();
//        initializeRecyclerView(recycler);
    }




    public void onSaveBtClick(View view){
//        String s= String.valueOf(inputFld.getText());
//      //  saveText(s);
//        inputFld.setText("");// Eingabefeld leeren
    }

    public void onShowBtClick(View view){
        List<Person> list=worker.loadAllPersons();
        if(null!=list && 0<list.size()){
            Person p=list.get(0);
            showPersonData(p);
        }
    }

    private void showPersonData(Person person){
        if(null==person){
            return;
        }
        idT.setText(String.valueOf(person.getId()));
        nameIndivFld.setText(person.getNameIndividual());
        nameFamilyFld.setText(person.getNameFamily());
        //sexCb.setSelection(1);//person.getSex();
        birthDayFld.setText(String.valueOf(person.getBirthDay()));
        birthMonthFld.setText(String.valueOf(person.getBirthMonth()));
        birthYearFld.setText(String.valueOf(person.getBirthYear()));
    }

    public void onShow2BtClick(View view){
        closeSoftKb();
        //loadList();
    }

    public void closeSoftKb(){
        //Soft-Keyboard schließen
        View v=getCurrentFocus();
        if(null==v){ return; }
        InputMethodManager m= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        m.hideSoftInputFromWindow(v.getWindowToken(),
                0 // 0|1, 1=kbd wird nur geschlossen, wenn nicht explizit vom Benutzer geöffnet
        );
    }

//    private void saveText(String text){
//        if(null==text || text.equals("")){
//            Toast.makeText(this, "Kein Text eingegeben", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        // direkt SQL per rawQuery wg. Sicherheit nicht empfohlen.
//        //Für Data Manipulation Language (DMS, update, insert, delete, ...) gibt es vorbereitete Methoden.
//        ContentValues values=new ContentValues();// Container für die Daten
//        values.put(COLUMN_NAME,text);//key value Paare
//        long ID=db.insert(TABLE_NAME,
//                null, // Hierdurch wird ggf. ein komplett leeres ContentValues mit einem Spaltennamen subsummiert.
//                values
//        );
//        Toast.makeText(this, "GespeichertName: "+text, Toast.LENGTH_SHORT).show();
//    }

//    private void loadAll(){
//        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,
//                null//where, filter, limit etc. vgl. prepared statements
//        );
//        while (cursor.moveToNext()){//Beim Lesen wird die Spaltennummer der jeweiligen Spalte im Resultset benötiogt:
//            int index=cursor.getColumnIndexOrThrow(COLUMN_NAME);
//            String name=cursor.getString(index);
//            int id=cursor.getInt( cursor.getColumnIndexOrThrow(COLUMN_ID) );
//            Toast.makeText(this, "Gelesener Datensatz: \n"+ COLUMN_ID+"="+id+", "+COLUMN_NAME + "="+name, Toast.LENGTH_SHORT).show();
//        }
//    }


//    private void loadList(){
//        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,
//                null//where, filter, limit etc. vgl. prepared statements
//        );
//        SimpleCursorAdapter adapter=new SimpleCursorAdapter(
//                this,
//                android.R.layout.simple_list_item_1,// vordefiniertes Layout mit bereits vorhandenen IDs
//                cursor,             // für das Resultset
//                new String[]{COLUMN_NAME}, // From: Spaltennamen im Ergebnis   { "_id", "name" }
//                new int[]{android.R.id.text1},     // To: Resource IDs des Layouts, auf die die Spalten gemappt werdeb  { R.id.id, R.id.name }
//                0
//        );
//        listV.setAdapter(adapter);
//    }







    private void initializeWorker(){
        //worker=new DbWorkerMock(helper.getWritableDatabase());
        worker=new DatabaseWorker(helper.getWritableDatabase());//Hier wird erst helper.onCreate aufgerufen!
    }

//    private void initializeRecyclerView(RecyclerView recycler) {
//        //Cursor animalCursor=worker.fetchAllImages();//schlecht, synchron auf den main thread; besser:
//        getLoaderManager().initLoader(//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
//                ID_LOADER_PERSONS,// Identifikation des Loaders
//                null, // hier kein Bundle zu übergeben
//                new PersonLoader(this) // Klasse, die Interface für Callbacks implementiert, hier diese Activity
//        );
//        //Für RecyclerView benötigt:
//        GridLayoutManager manager=new GridLayoutManager(this,2);
//        recycler.setLayoutManager(manager);
//        //Für ein Recyclerview benötigen wir einen eigenen Adapter:
//        //AnimalsRecyclerViewAdapter adapter
//        adapter= new PersonRecyclerViewAdapter(this,animalCursor);
//        recycler.setAdapter(adapter);
//    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeWorker();
    }

    @Override
    protected void onPause() {
        super.onPause();
        helper.close();
    }


}
