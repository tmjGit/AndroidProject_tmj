package li.tmj.dbclient.ui.fx.model;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by tmj on 07.01.18.
 */

public class ControlsManager {
    public static String getText(View control) {
		String s=null;
		if(control instanceof TextView) {
			//TextView tv=(TextView) control;
			s= String.valueOf( ((TextView) control) .getText());
		}else if(control instanceof EditText) {
			s= String.valueOf(( (EditText) control ).getText());
//		}else if(control instanceof Spinner) {
//			s=((Spinner) control.getText();
		}
		return s;
	}

	public static void setText(View control, String text) {
		if(control instanceof TextView) {
			((TextView) control).setText(text);
		}else if(control instanceof EditText) {
			((EditText) control).setText(text);
//		}else if(control instanceof Spinner) {
//			((Spinner) control).setText(text);
		}
	}
}
