package li.tmj.dbclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import li.tmj.dbclient.R;

public class UeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar() // heute: ApplicationBar = oberste Querleiste
            .setDisplayHomeAsUpEnabled(true); //Zurückpfeil (Navigate Up) generieren:

        //(ggf. übergebene) Daten vom System empfangen
        Intent intent=getIntent();
        if (null==intent) {throw new AssertionError();} // intent könnte theoretisch null sein, wenn die Activity nicht per intent aufgerufen wurde.
        int activityType=intent.getIntExtra(UeActivity.ACTIVITY_TYPE, 0); // value aus dem intent holen.
        String msg;
        int color;
        switch(activityType){
            case UeActivity.ACTIVITY1: msg="Erster Button"; color=getResources().getColor(android.R.color.holo_orange_dark);break;
            case UeActivity.ACTIVITY2: msg="Zweiter Button"; color=getResources().getColor(android.R.color.holo_purple); break;
            case UeActivity.ACTIVITY3: msg="Dritter Button"; color=getResources().getColor(R.color.colorPrimaryDark); break;
            default: throw new AssertionError("Unknown intent type while creating DetailActivity: "+activityType);
        }

        ViewGroup layout// Supertyp von den Layouttypen
            =findViewById(R.id.main_lay);
        TextView outT=findViewById(R.id.out_t);
        outT.setText(msg);
        layout.setBackgroundColor(color);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(//Rückweg, Effekt für ausblenden dieser Activity und Einblenden der vorherigen
                R.anim.slide_in_left,// Animation zur neuen Activity
                R.anim.slide_out_right//Animation zur alten Activity
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(android.R.id.home==item.getItemId()){//Der Pfeil in der Menüleiste (s. o.) hat fest diese ID!
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
