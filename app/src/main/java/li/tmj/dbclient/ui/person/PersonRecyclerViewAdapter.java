package li.tmj.dbclient.ui.person;


import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import li.tmj.dbclient.R;
import li.tmj.dbclient.db.DatabaseContract;

class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonRecyclerViewAdapter.ViewHolder>{
    private Cursor cursor;
    private Context context;

    public PersonRecyclerViewAdapter(Context context, Cursor cursor){
        this.context=context;
        this.cursor =cursor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ItemView "aufpusten" und mit dem Holder verbinden:
        View itemView= LayoutInflater.from(context).inflate(R.layout.personsactivity_griditem,parent,false);
        ViewHolder holder=new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Daten aus Cursor zur via Adapter angefragten Position holen:
        cursor.moveToPosition(position);
        try {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.PersonEntry._ID));
            String nameFam = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.PersonEntry.CLM_NAME_FAMILY));
//            String breeder = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.BreederEntry.COLUMN_NAME));
//            String src = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ImageEntry.COLUMN_SRC));
            holder.fillData(id, nameFam);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if(null== cursor){
            return 0;//Dummy value
        }
        return cursor.getCount();
    }

    public void changeCursor(Cursor cursor) {
        if(null!= this.cursor){
            this.cursor.close();
        }
        this.cursor =cursor;
        notifyDataSetChanged();// Nachricht an die Adapter-Superklasse, dass sich die Daten geändert haben.
    }

    public class ViewHolder extends RecyclerView.ViewHolder {//Repräsentation einer Karte im Code
        ImageView animalImg;
        TextView idT,nameFamT;

        public ViewHolder(View itemView) {
            super(itemView);
            //animalImg=itemView.findViewById(R.id.animal_img);
            idT=itemView.findViewById(R.id.id2_t);
            nameFamT=itemView.findViewById(R.id.name_fam2_t);
        }

        public void fillData(int id,String nameFam){
            //Bild Ressource /drawable aus Name suchen:
            //int drawable=context.getResources().getIdentifier(src,"drawable",context.getPackageName());
           // animalImg.setImageResource(drawable);
            idT.setText(String.valueOf(id));
            nameFamT.setText(nameFam);
        }
    }
}
