package li.tmj.dbclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import li.tmj.dbclient.R;

public class UeActivity extends AppCompatActivity implements View.OnClickListener {
    /* Bei Statusänderung bspw. drehen werden alle Lifecycle Events durchlaufen.
    Dadurch verschwinden u. U. auch dynamische Informationen, wenn man keine savedInstance nutzt.
     */
    public static final int ACTIVITY1=1,ACTIVITY2=2,ACTIVITY3=4;
    public static final String ACTIVITY_TYPE="li.tmj.activitylifecycleuebergang.activity_type";// Sollte platform-eindeutig sein.
    public static final String INSTANCE_KEY = "instance.key.string.text";
    ConstraintLayout button1Lay;
    ConstraintLayout button2Lay;
    ConstraintLayout button3Lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainue);
        Log.d("***AB-MainActivity***","onCreate");

        button1Lay=findViewById(R.id.button1_lay);
        button2Lay=findViewById(R.id.button2_lay);
        button3Lay=findViewById(R.id.button3_lay);
        button1Lay.setOnClickListener(this);
        button2Lay.setOnClickListener(this);
        button3Lay.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        Log.d("***AB-MainActivity***","onRestart");
        super.onRestart();
    }

    @Override // wird gefeuert, wenn eine instance zum restore bereit steht.
    //Wird im Gegensatz zu onCreate auch aufgerufen
    protected void onRestoreInstanceState(Bundle savedInstanceState) { //Methode 2
        Log.d("***AB-MainActivity***","onRestoreInstanceState w/o PersistableBundle");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.d("***AB-MainActivity***","onRestoreInstanceState w/ PersistableBundle");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onClick(View view) {
        Log.d("***AB-MainActivity***","onClick");
        switch(view.getId()){//Verzweigung je nach gedrücktem Button
            case R.id.button1_lay: loadDetailActivity(ACTIVITY1);break;
            case R.id.button2_lay: loadDetailActivity(ACTIVITY2);break;
            case R.id.button3_lay: loadDetailActivity(ACTIVITY3);break;
            default: throw new AssertionError("Unbekannter Button:"+view.getId());
        }
    }

    private void loadDetailActivity(int activityType) {
        // Intent Erzeugung. Intent ist eine Anfrage an das Android System
        // zum öffnen einer (anderen) Activity mit oder ohne Adressat
        Intent intent = new Intent(
            this, // Context der App
            UeDetailActivity.class // Klasse der Zielactivity
        );
        //Wenn keine Daten übergeben werden sollen überspringen, sonst mit Daten:
        intent.putExtra(
            ACTIVITY_TYPE,// Key zur Identifikation beim Empfang. Sollte platform-eindeutig sein.
            activityType  // value, der übertragen werden soll
        );
        startActivity(intent); // Activity Start befehlen. Dies wird erst am Ende des aufrufenden Threads ausgeführt, also wenn der aufrufende Event beendet wird!

        //Übergangsanimationen überschreiben. Dieser
        //Vorgefertigte Möglichkeiten (android.R.anim) sehr gering.
        overridePendingTransition(
                R.anim.slide_in_right,// Animation zur neuen Activity
//                R.anim.slide_in_right,// Animation zur neuen Activity
                R.anim.slide_out_left//Animation zur alten Activity
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("***AB-MainActivity***","onStart");
    }

    @Override
    protected void onResume() {
        Log.d("***AB-MainActivity***","onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("***AB-MainActivity***","onStop");
        super.onStop();
    }

    @Override //wird u.U. nicht ausgelöst, bspw. wenn die App im Hintergrund ist und direkt (Schließknopf im Taskmanager) ohne sie erst zu aktivieren geschloossen wird.
    protected void onDestroy() {
        Log.d("***AB-MainActivity***","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("***AB-MainActivity***","onPause");
        super.onPause();
    }

    @Override//Wird bei Statusänderungen (bspw. Drehen) aufgerufen, bevor die Activity neu gestartet wird
    //hier sind also Werte, die erhalten werden sollen, zu speichern.
    protected void onSaveInstanceState(Bundle outState) {// nicht die andere Methode mit zusätzlichem PersistableBundle!
        Log.d("***AB-MainActivity***","onSaveInstanceState w/o PersistableBundle");
        outState.putString(
                INSTANCE_KEY,//key
                "Instance no PersistableBundle"//value
        );
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("***AB-MainActivity***","onSaveInstanceState w/ PersistableBundle");
        outState.putString(
                INSTANCE_KEY,//key
                "Instance PersistableBundle"//value
        );
//        outPersistentState.s
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
