package li.tmj.dbclient.ui.person;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import li.tmj.dbclient.R;
import li.tmj.dbclient.db.DatabaseOpenHelper;
import li.tmj.dbclient.db.DatabaseWorker;
import li.tmj.dbclient.db.DbWorkerMock;
import li.tmj.dbclient.db.model.Person;
//import android.support.v4.content.CursorLoader;
//import android.support.v4.content.Loader;

public class PersonActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {// Generic: Rückgabetyp des Threads, der auf die DB zugreift

    private static final int ID_LOADER_PERSONS = 42;
    private Button saveBt;
    ListView listV;
    EditText nameIndivFld, nameFamilyFld, birthDayFld, birthMonthFld, birthYearFld;
    TextView idT;
    Spinner sexCb;
    private RecyclerView recycler;
    private DatabaseOpenHelper helper;
    private DatabaseWorker worker;
    private Cursor cursor;
    private PersonRecyclerViewAdapter adapter;
    private Person currentPerson;
    private boolean hasChanged=false;
    private int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personsactivity);

        saveBt = findViewById(R.id.save_bt);
        nameFamilyFld = findViewById(R.id.name_fam_fld);
        nameIndivFld = findViewById(R.id.name_indiv_fld);
        sexCb = findViewById(R.id.sex_cb);
        birthDayFld = findViewById(R.id.birthday_fld);
        birthMonthFld = findViewById(R.id.birthmonth_fld);
        birthYearFld = findViewById(R.id.birthyear_fld);
        idT = findViewById(R.id.id2_t);
        setupCb();

        helper = new DatabaseOpenHelper(this);
        recycler = findViewById(R.id.acmain_rec_lsz);
        initializeWorker();
        //initializeRecyclerView(recycler);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeWorker();
    }


    public void onSaveBtClick(View view){
        Toast.makeText(this, "Save Button geklickt!", Toast.LENGTH_SHORT).show();//TODO
        setChanged(false);
    }

    public void onShowBtClick(View view) {
        List<Person> list = worker.loadAllPersons();
        if (null != list && 0 < list.size()) {
            try {
                index++;
                if(index>=list.size()){
                    index=0;
                }
                currentPerson=list.get(index);
                //for (Person p : list) {//Person p=list.get(0);
                    //currentPerson=p;
                    showCurrentPerson();
                    //Toast.makeText(this, "Person id="+p.getId(), Toast.LENGTH_SHORT).show();
                    Thread.sleep(1000);
                //}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setChanged(boolean hasChanged){
        this.hasChanged=hasChanged;
        saveBt.setEnabled(hasChanged);
    }

    private void initializeWorker() {
        worker=new DbWorkerMock(helper.getWritableDatabase());
        //worker = new DatabaseWorker(helper.getWritableDatabase());//Hier wird erst helper.onCreate aufgerufen!
    }


    private void initializeRecyclerView(RecyclerView recycler) {
        //Cursor cursor=worker.fetchAllImages();//schlecht, synchron auf den main thread; besser:
        getLoaderManager().initLoader(//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
                ID_LOADER_PERSONS,// Identifikation des Loaders
                null, // hier kein Bundle zu übergeben
                new PersonLoader(this, worker) // Klasse, die Interface für Callbacks implementiert, hier diese Activity
        );
        //Für RecyclerView benötigt:
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(manager);
        //Für ein Recyclerview benötigen wir einen eigenen Adapter:
        //AnimalsRecyclerViewAdapter adapter
        adapter = new PersonRecyclerViewAdapter(this, cursor);
        recycler.setAdapter(adapter);
    }

    private void setupCb(){
        final String[] sexes =getResources().getStringArray(R.array.sexes);
        // Tipp von https://stackoverflow.com/questions/9863378/how-to-hide-one-item-in-an-android-spinner
        // Spinner benötigt zur Verwendung des Arrays einen Adapter (bei Definition im Layout automatisch im Hintergrund):
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, // Eines von mehreren vordefinierten (Text) Layouts
                sexes // Unsere Listitems
        ){
            @Override   // Populate the spinner using a customized ArrayAdapter that hides the first (dummy) entry
            public View getDropDownView(int index, View convertView, ViewGroup parent) {
//                if (index == 0) { // If the selected is the initial dummy entry, we hide it.
//                    TextView tv = new TextView(getContext());
//                    tv.setHeight(0);
//                    tv.setVisibility(View.GONE);
//                    return tv;
//                } else {
                    // Pass convertView as null to prevent reuse of special case views
                    return super.getDropDownView(index, null, parent);
                //}
            }
        };

//        String compareValue = "some value";
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexes, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sexCb.setAdapter(adapter);
//        if (compareValue != null) {
//            int spinnerPosition = adapter.getPosition(compareValue);
//            sexCb.setSelection(spinnerPosition);
//        }

        sexCb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String sex = sexes[position]; //getResources().getStringArray(R.array.ice_cream_flavours)[index];
                if(position==0) {// Selected special item
                    if(null!=currentPerson){
                    currentPerson.setSex("");
                    setChanged(true);}
                    //Toast.makeText(PersonActivity.this, "CB klicked position="+position+", item="+sexCb.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }else if(position>0) {
                    if(null==currentPerson){currentPerson=new Person();}
                    currentPerson.setSex(sexCb.getSelectedItem().toString());
                    setChanged(true);
                    //Toast.makeText(PersonActivity.this, "CB klicked position="+position+", item="+sexCb.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }else{// clicked but not on any item
                    //currentPerson.setSex("");
                    //Toast.makeText(PersonActivity.this, "CB klicked position="+position+", item="+sexCb.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        sexCb.setAdapter(adapter);
    }




    @Override
    protected void onPause() {
        super.onPause();
        helper.close();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (ID_LOADER_PERSONS == id) {//unsere Anfrage
            return new PersonCursorLoader(this, worker);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (ID_LOADER_PERSONS == loader.getId()) {
            cursor = data;
            adapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        int id = loader.getId();

        if (ID_LOADER_PERSONS == id) {
            cursor.close();
        }

    }

    private static class PersonCursorLoader extends CursorLoader {
        private DatabaseWorker worker;

        public PersonCursorLoader(Context context, DatabaseWorker worker) {
            super(context);
            this.worker = worker;
        }

        @Override
        public Cursor loadInBackground() {//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
            return worker.fetchAllPersons();//hier im Thread, asynchrone Verarbeitung
        }
    }


    private void showCurrentPerson() {
        if (null == currentPerson) { return; }
        idT.setText(worker.displayValue(currentPerson.getId()));
        nameIndivFld.setText(worker.displayValue(currentPerson.getNameIndividual()));
        nameFamilyFld.setText(worker.displayValue(currentPerson.getNameFamily()));
        String sex=currentPerson.getSex();
        if(null==sex){ sex=""; }
        if("".equals(sex)){
            sexCb.setSelection(0);//special value
        }else {
            ArrayAdapter<String> adapter= (ArrayAdapter<String>) sexCb.getAdapter();
            sexCb.setSelection(adapter.getPosition(currentPerson.getSex()));
        }
        birthDayFld.setText(worker.displayValue(currentPerson.getBirthDay()));
        birthMonthFld.setText(worker.displayValue(currentPerson.getBirthMonth()));
        birthYearFld.setText(worker.displayValue(currentPerson.getBirthYear()));
    }

    public void onShow2BtClick(View view) {
        closeSoftKb();
        //loadList();
    }

    public void closeSoftKb() {
        //Soft-Keyboard schließen
        View v = getCurrentFocus();
        if (null == v) {
            return;
        }
        InputMethodManager m = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
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


}
