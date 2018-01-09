package li.tmj.dbclient.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import li.tmj.dbclient.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Bei Android "pustet" man eine Resource zu einer View auf.
        //Aber Ausnahme: MenuInflater gibt keine View zurück, sondern nutzt das übergebene Objekt.

        getMenuInflater().inflate(R.menu.main_menu, // Menü Resource (Inhalt)
                menu // Menü Object, das gefüllt werden soll
        );

        return super.onCreateOptionsMenu(menu);// Menü wird dargestellt.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){
            case R.id.main_menu_item1:
                Toast.makeText(this, // Context
                        "Dies ist ein Toast!",//Nachricht
                        Toast.LENGTH_SHORT// Anzeigedauer des Toasts
                ).show();
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}
