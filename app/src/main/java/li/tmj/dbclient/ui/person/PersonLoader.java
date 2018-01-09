package li.tmj.dbclient.ui.person;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import li.tmj.dbclient.db.DatabaseOpenHelper;
import li.tmj.dbclient.db.DatabaseWorker;
//import android.support.v4.content.CursorLoader;
//import android.support.v4.content.Loader;

public class PersonLoader implements LoaderManager.LoaderCallbacks<Cursor> {// Generic: Rückgabetyp des Threads, der auf die DB zugreift
    private static final int ID_LOADER_PERSONS = 42;
    private Context context;
    //    private RecyclerView recycler;
    private DatabaseOpenHelper helper;
    private DatabaseWorker worker;
    private Cursor personCursor;
//    private PersonRecyclerViewAdapter adapter;

    public PersonLoader(Context context,DatabaseWorker worker) {
        this.context=context;
        this.worker=worker;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.animalsactivity);
//        helper=new DatabaseOpenHelper(this);
//
//        recycler=findViewById(R.id.acmain_rec_lst);
//        initializeWorker();
//        initializeRecyclerView(recycler);
//    }

//    private void initializeWorker(){
//        worker=new DatabaseWorker(helper.getWritableDatabase());//Hier wird erst helper.onCreate aufgerufen!
//    }

//    private void initializeRecyclerView(RecyclerView recycler) {
//        //Cursor personCursor=worker.fetchAllImages();//schlecht, synchron auf den main thread; besser:
//        getLoaderManager().initLoader(//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
//                ID_LOADER_PERSONS,// Identifikation des Loaders
//                null, // hier kein Bundle zu übergeben
//                this // Klasse, die Interface für Callbacks implementiert, hier diese Activity
//        );
//        //Für RecyclerView benötigt:
//        GridLayoutManager manager=new GridLayoutManager(this,2);
//        recycler.setLayoutManager(manager);
//        //Für ein Recyclerview benötigen wir einen eigenen Adapter:
//        //AnimalsRecyclerViewAdapter adapter
//        adapter= new PersonRecyclerViewAdapter(this,personCursor);
//        recycler.setAdapter(adapter);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        initializeWorker();
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        helper.close();
//    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if(ID_LOADER_PERSONS ==id){//unsere Anfrage
            return new PersonCursorLoader(context,worker );
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(ID_LOADER_PERSONS ==loader.getId()){
            personCursor =data;
           // adapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        int id=loader.getId();
        if(ID_LOADER_PERSONS ==id){
            personCursor.close();
        }
    }

    private static class PersonCursorLoader extends CursorLoader {
        private DatabaseWorker worker;

        public PersonCursorLoader(Context context, DatabaseWorker worker) {
            super(context);
            this.worker=worker;
        }

        @Override
        public Cursor loadInBackground() {//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
            return worker.fetchAllPersons();//hier im Thread, asynchrone Verarbeitung
        }
    }
}
