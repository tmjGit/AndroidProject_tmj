//package li.tmj.tablelikefields.ui.fx.model;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.RelativeLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//import java.util.ArrayList;
//import java.util.List;
//
//import li.tmj.dbclient.R;
//
//public class Controls {
//	private ArrayList<View> controls=new ArrayList<>();
//	private Context context;
//	private ViewGroup viewGroup;
//
//    public Controls(Context context,ViewGroup viewGroup) {
//        this.context = context;
//        this.viewGroup=viewGroup;
//    }
//
//    public void add(View c) {
//		c.setId(View.generateViewId());
//		controls.add(c);
//	}
//
//	public void add(View c, String caption) {
////		c.setId(caption);
//		setText(c, caption);
//		add(c);
//	}
//
//	public View get(int index) {
//		return controls.get(index);
//	}
//
//	public void setLocaleText(int index, String text) {
//		String s=text;//Localization.get(text);//TODO Localization
//		setText(index,s);
//	}
//
//	public void setText(int index, String text) {
//	    setText(controls.get(index),text);
//	}
//
//	public String getText(int index) {
//		String s=null;
//		if(controls.get(index) instanceof TextView) {
//			TextView tv=(TextView) controls.get(index);
//			s= String.valueOf( ((TextView) controls.get(index)) .getText());
//		}else if(controls.get(index) instanceof EditText) {
//			s= String.valueOf(( (EditText) controls.get(index) ).getText());
////		}else if(controls.get(index) instanceof Spinner) {
////			s=((Spinner) controls.get(index)).getText();
//		}
//		return s;
//	}
//
//	private void setText(View control, String text) {
//		if(control instanceof TextView) {
//			((TextView) control).setText(text);
//            if (android.os.Build.VERSION.SDK_INT < 23) {
//                ((TextView) control).setTextAppearance(context, R.style.TextAppearance_AppCompat_Small);//TODO initialize context
//            } else {
//                ((TextView) control).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            }
//		}else if(control instanceof EditText) {
//			((EditText) control).setText(text);
//            if (android.os.Build.VERSION.SDK_INT < 23) {
//                ((TextView) control).setTextAppearance(context, R.style.TextAppearance_AppCompat_Small);
//            } else {
//                ((TextView) control).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            }
////		}else if(control instanceof Spinner) {
////			((Spinner) control).setText(text);
//		}
//	}
//
//	public void clearFields() {
//		for(View c:controls) {
//			if(c instanceof EditText) {
//				((EditText) c).setText("");
//			//}else if (c instanceof Spinner) {
////				((Spinner)c).setText("");
//			}
//		}
//	}
//
//	public int size() {
//		return controls.size();
//	}
//
//    private int insertView(View c, int leftRelation,int topRelation, int padding, String text) {
//        //int leftPadding, int topPadding,
//        int rightPadding=0;
//        int bottomPadding=0;
//        RelativeLayout.LayoutParams para;
//        if (null != text) {
//            if (c instanceof TextView) {
//                ((TextView) c).setText(text);//Material.Small
//                // ((TextView) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//                // ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//                if (android.os.Build.VERSION.SDK_INT < 23) {
//                    ((TextView) c).setTextAppearance(context, R.style.TextAppearance_AppCompat_Small);
//                } else {
//                    ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//                }
//            } else if (c instanceof EditText) {
//                ((EditText) c).setText(text);
//                // ((EditText) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//                //android:textAppearance="@android:style/TextAppearance.Material.Small"
//                if (android.os.Build.VERSION.SDK_INT < 23) {
//                    ((EditText) c).setTextAppearance(context, R.style.TextAppearance_AppCompat_Small);
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
//        parent.addView(c, para);//View an ViewGroup mit den Parametern binden
//        return c.getId();
//    }
//}
