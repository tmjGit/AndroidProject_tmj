//package li.tmj.tablelikefields.activities;
//
//import android.app.LoaderManager;
//import android.content.Context;
//import android.content.CursorLoader;
//import android.content.Loader;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import li.tmj.dbclient.R;
//import li.tmj.dbclient.db.DatabaseOpenHelper;
//import li.tmj.dbclient.db.DatabaseWorker;
//
////import android.support.v4.content.CursorLoader;
////import android.support.v4.content.Loader;
//
//public class AnimalsActivity extends AppCompatActivity
//        implements LoaderManager.LoaderCallbacks<Cursor> {// Generic: Rückgabetyp des Threads, der auf die DB zugreift
//    private static final int ID_LOADER_ANIMALS = 42;
//    private RecyclerView recycler;
//    private DatabaseOpenHelper helper;
//    private DatabaseWorker worker;
//    private Cursor animalCursor;
//    private AnimalsRecyclerViewAdapter adapter;
//
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
//
//    private void initializeWorker(){
//        worker=new DatabaseWorker(helper.getWritableDatabase());//Hier wird erst helper.onCreate aufgerufen!
//    }
//
//    private void initializeRecyclerView(RecyclerView recycler) {
//        //Cursor animalCursor=worker.fetchAllImages();//schlecht, synchron auf den main thread; besser:
//        getLoaderManager().initLoader(//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
//                ID_LOADER_ANIMALS,// Identifikation des Loaders
//                null, // hier kein Bundle zu übergeben
//                this // Klasse, die Interface für Callbacks implementiert, hier diese Activity
//        );
//        //Für RecyclerView benötigt:
//        GridLayoutManager manager=new GridLayoutManager(this,2);
//        recycler.setLayoutManager(manager);
//        //Für ein Recyclerview benötigen wir einen eigenen Adapter:
//        //AnimalsRecyclerViewAdapter adapter
//        adapter= new AnimalsRecyclerViewAdapter(this,animalCursor);
//        recycler.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        initializeWorker();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        helper.close();
//    }
//
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        if(ID_LOADER_ANIMALS==id){//unsere Anfrage
//            return new AnimalCursorLoader(this,worker );
//        }
//        return null;
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        if(ID_LOADER_ANIMALS==loader.getId()){
//            animalCursor=data;
//            adapter.changeCursor(data);
//        }
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//        int id=loader.getId();
//
//        if(ID_LOADER_ANIMALS==id){
//            animalCursor.close();
//        }
//
//    }
//
//    private static class AnimalCursorLoader extends CursorLoader {
//        private DatabaseWorker worker;
//
//        public AnimalCursorLoader(Context context,DatabaseWorker worker) {
//            super(context);
//            this.worker=worker;
//        }
//
//        @Override
//        public Cursor loadInBackground() {//Der Loader cached den Cursor, so dass bei erneuten Anfragen ggf. gar nicht neu geladen werden muss.
//            return worker.fetchAllPersons();//hier im Thread, asynchrone Verarbeitung
//        }
//    }
//}
