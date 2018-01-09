//package li.tmj.tablelikefields.ui.fx.model;
//
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//
//import java.util.List;
//
//import static android.view.View.VISIBLE;
//
//public class Arrange {
//	public static void arrangeControls(Controls controls, Places places,ViewGroup list) {
//	//public static void arrangeControls(Controls controls, Places places,ObservableList<Node> list) {
//		int count=controls.size();
//		for(int i=0; i<count; i++) {
//			View c=controls.get(i);
//			//list.add(c); // adding control to fx Object
//			RelativeLayout.LayoutParams para;//=new RelativeLayout.LayoutParams(350,110);//Width, Height
//			para=places.arrangeControl(c,i);
//			list.addView(c, para);
////			if(null!=c.getId()) {// loading visible text
////				controls.setText(i,Localization.get(c.getId()));
////			}
//
//			c.setEnabled(true);//c.setDisable(false);
//			c.setVisibility(VISIBLE);//int: One of VISIBLE, INVISIBLE, or GONE.  c.setVisible(true);
//		}
//	}
//
//
//
//}
