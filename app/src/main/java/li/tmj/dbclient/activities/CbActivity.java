package li.tmj.dbclient.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import li.tmj.dbclient.R;

public class CbActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    TextView textView;
    ImageView imageView;
    Button submitBt;
    Map<String,Integer> imagesMap=new HashMap<>();// =  imagesMap.keySet().;
    private String[] flavourNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb);

        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.txt);
        imageView=findViewById(R.id.img_v);
        submitBt =findViewById(R.id.submit_bt);

        imagesMap=new HashMap<>();
        imagesMap.put("Bitte Eissorte wählen...",0);
        imagesMap.put( "Brauner Bär",R.drawable.button_style);
        imagesMap.put("Capri",R.drawable.ic_check_black_24dp);
        imagesMap.put("Domino",R.drawable.ic_child_care_black_24dp);
        imagesMap.put("Nogger",R.drawable.ic_launcher_background);
        imagesMap.put("Sandwich",R.drawable.ic_launcher_foreground);
        Set<String> keys=imagesMap.keySet();
        flavourNames =keys.toArray( new String[keys.size()] ); // toArray benötigt ein passendes Array als Parameter.
        Arrays.sort(flavourNames);

        // Tipp von https://stackoverflow.com/questions/9863378/how-to-hide-one-item-in-an-android-spinner
        //Spinner benötigt zur Verwendung des Arrays einen Adapter (bei Definition im Layout automatisch im Hintergrund):
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this, // Context = Activity, in dem der Spinner ist - häufig gebraucht in Android
                android.R.layout.simple_list_item_1, // Eines von mehreren vordefinierten (Text) Layouts
                flavourNames // Unsere Listitems
        ){
            @Override   // Populate the spinner using a customized ArrayAdapter that hides the first (dummy) entry
            public View getDropDownView(int index, View convertView, ViewGroup parent)
            {
                View v = null;
                // If this is the initial dummy entry, make it hidden
                if (index == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(index, null, parent);
                }
                return v;
            }
        };

        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
//        submitBt.setOnClickListener(this);

    }


    private void showImage(int index) {
        String name = flavourNames[index]; //getResources().getStringArray(R.array.ice_cream_flavours)[index];
        boolean somethingSelected=index>0;
        if(index>0) {
            textView.setText(String.format("Du hast %s gewählt!", name));
        }else{
            textView.setText("");
        }
        imageView.setImageResource(imagesMap.get(name));
        submitBt.setEnabled(somethingSelected);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View textV, int index, long id) {
        showImage(index);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Interface View.onClickListener
    @Override
    public void onClick(View view) {// support library, da abwärtskompatibel. Möglichst bei importen immer eine support library verwenden.
        // Für einen Dialog: Builder mit innerer Klasse AlertDialogs.
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        AlertDialog dialog=builder.create();
        dialog.setTitle("Danke");
        dialog.setMessage("Ihr Eis wird gedruckt.");
        //ACHTUNG Solche Dialoge verschwinden
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Lieber doch abhholen?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
}
