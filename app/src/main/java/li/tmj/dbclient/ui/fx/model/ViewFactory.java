package li.tmj.dbclient.ui.fx.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import li.tmj.dbclient.R;

/**
 * Created by TMJ on 07.01.18.
 */

public class ViewFactory {
    private Context context;
    private ViewGroup viewGroup;
    private List<View> controls;

    public ViewFactory(ViewGroup viewGroup) {
        this.viewGroup=viewGroup;
        context=viewGroup.getContext();
    }

    public TextView createTextView(int textStyle){//R.style.entryText
        TextView c=new TextView(context);
        c.setTextAppearance(context,textStyle<0 ? R.style.labelText:textStyle);
        return c;
    }

    public EditText createEditText(int textStyle){
        EditText c=new EditText(context);
        c.setTextAppearance(context,textStyle<0 ? R.style.entryText:textStyle);
        return c;
    }

    public Spinner createSpinner(int textStyle,String... items){
        ArrayAdapter adapter=new ArrayAdapter<String>(context, R.layout.spinner_item, items );
        Spinner c=new Spinner(context);
        //TextView t=c.findViewById(R.layout.spinner_item);
        //t.setTextAppearance(context,textStyle<0 ? R.style.entryText:textStyle);
        c.setAdapter(adapter);
        return c;
    }

//    private int insertView(View c, RelativeLayout.LayoutParams para, int leftPadding, int topPadding, int rightPadding, int bottomPadding, String text) {
//        if (null != text) {
//            if (c instanceof TextView) {
//                ((TextView) c).setText(text);//Material.Small
//                // ((TextView) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//                // ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//                if (android.os.Build.VERSION.SDK_INT < 23) {
//                    ((TextView) c).setTextAppearance(viewGroup.getContext(), R.style.TextAppearance_AppCompat_Small);
//                } else {
//                    ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//                }
//            } else if (c instanceof EditText) {
//                ((EditText) c).setText(text);
//                // ((EditText) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//                //android:textAppearance="@android:style/TextAppearance.Material.Small"
//                if (android.os.Build.VERSION.SDK_INT < 23) {
//                    ((EditText) c).setTextAppearance(viewGroup.getContext(), R.style.TextAppearance_AppCompat_Small);
//                } else {
//                    ((EditText) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//                }
//            } else if (c instanceof Spinner) {//else Spinner
////                ((Spinner) c).setText(text);
////                ((Spinner) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
////                //android:textAppearance="@android:style/TextAppearance.Material.Small"
////                if (android.os.Build.VERSION.SDK_INT < 23){
////                    ((Spinner) c).setTextAppearance(this,R.style.TextAppearance_AppCompat_Small);
////                } else{
////                    ((Spinner) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            }
//        }
//        controls.add(c);
//        c.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
//        c.setId(View.generateViewId());
//        viewGroup.addView(c, para);//View an ViewGroup mit den Parametern binden
//        return c.getId();
//    }
}
