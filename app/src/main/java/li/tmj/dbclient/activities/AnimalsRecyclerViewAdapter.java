//package li.tmj.tablelikefields.activities;
//
//
//import android.content.Context;
//import android.database.Cursor;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import li.tmj.dbclient.R;
//import li.tmj.dbclient.db.DatabaseContract;
//
//class AnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AnimalsRecyclerViewAdapter.ViewHolder>{
//    private Cursor animalCursor;
//    private Context context;
//
//    public AnimalsRecyclerViewAdapter(Context context,Cursor animalCursor){
//        this.context=context;
//        this.animalCursor=animalCursor;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //ItemView "aufpusten" und mit dem Holder verbinden:
//        View itemView= LayoutInflater.from(context).inflate(R.layout.animalsactivity_griditem,parent,false);
//        ViewHolder holder=new ViewHolder(itemView);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        //Daten aus Cursor zur via Adapter angefragten Position holen:
//        animalCursor.moveToPosition(position);
//        try {
//            String title = animalCursor.getString(animalCursor.getColumnIndexOrThrow(DatabaseContract.PersonEntry.COLUMN_TITLE));
////            String breeder = animalCursor.getString(animalCursor.getColumnIndexOrThrow(DatabaseContract.BreederEntry.COLUMN_NAME));
////            String src = animalCursor.getString(animalCursor.getColumnIndexOrThrow(DatabaseContract.ImageEntry.COLUMN_SRC));
//            holder.fillData(src, title, breeder);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        if(null==animalCursor){
//            return 0;//Dummy value
//        }
//        return animalCursor.getCount();
//    }
//
//    public void changeCursor(Cursor cursor) {
//        if(null!=animalCursor){
//            animalCursor.close();
//        }
//        animalCursor=cursor;
//        notifyDataSetChanged();// Nachricht an die Adapter-Superklasse, dass sich die Daten geändert haben.
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {//Repräsentation einer Karte im Code
//        ImageView animalImg;
//        TextView titleT,breederT;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            animalImg=itemView.findViewById(R.id.animal_img);
//            titleT=itemView.findViewById(R.id.title_t);
//            breederT=itemView.findViewById(R.id.breeder_t);
//        }
//
//        public void fillData(String src,String title,String breeder){
//            //Bild Ressource /drawable aus Name suchen:
//            int drawable=context.getResources().getIdentifier(src,"drawable",context.getPackageName());
//            animalImg.setImageResource(drawable);
//            titleT.setText(src);
//            breederT.setText(breeder);
//        }
//    }
//}
