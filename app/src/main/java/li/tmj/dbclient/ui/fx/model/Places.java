//package li.tmj.tablelikefields.ui.fx.model;
//
//import android.view.View;
//import android.widget.RelativeLayout;
//
//import java.util.ArrayList;
//
//public class Places {
//	private ArrayList<Place> places=new ArrayList<>();
//
//	public Place get(int index) {
//		return places.get(index);
//	}
//
//	/**
//	 *
//	 * @param p	new element
//	 * @return	Index of the added element
//	 */
//	public int add(Place p) {
//		places.add(p);
//		return places.size();
//	}
//
//	public void set(int index,Place p) {
//		places.set(index, p);
//	}
//
////	public int getLeft(int index) {
////		return places.get(index).getLeft();
////	}
//	public void setLeft(int index,int left) {
//		places.get(index).setLeft( left );
//	}
////	public int getTop(int index) {
////		return places.get(index).getTop();
////	}
//	public void setTop(int index, int top) {
//		places.get(index).setTop(top);
//	}
////	public int getWidth(int index) {
////		return places.get(index).getWidth();
////	}
//	public void setWidth(int index, int width) {
//		places.get(index).setWidth(width);
//	}
////	public int getHeight(int index) {
////		return places.get(index).getHeight();
////	}
//	public void setHeight(int index, int height) {
//		places.get(index).setHeight(height);
//	}
//
//	public int left(int index) {
//		//TODO Logger.debug("Places.left: index={}",index);
//		switch(places.get(index).getLeftRelation()) {
//		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
//		case ABSOLUTE: return places.get(index).getLeft();
//		case RIGHT_OF: {
//			int i=(int) places.get(index).getLeft() ;
//			int d= left(i)+width(i)+places.get(index).getLeftRelationDistance();//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
//			//TODO Logger.debug("Places.left({}): RIGHT_OF i={}, d={}",i,d);
//			return d;
//		}
//		case BENEATH: {
//			int i=(int) places.get(index).getLeft() ;
//			int d= left(i);//TODO exception falls null
//			//TODO Logger.debug("Places.left({}): BENEATH i={}, d={}",index,i,d);
//			return d;
//		}
//		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
//		}
//	}
//
//	public int top(int index) {
//		switch(places.get(index).getTopRelation()) {
//		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
//		case ABSOLUTE: return places.get(index).getTop();
//		case RIGHT_OF: {
//			int i=(int) places.get(index).getTop() ;
//			int d= top(i);//TODO exception falls null
//			//TODO Logger.debug("Places.top({}): RIGHT_OF i={}, d={}",index,i,d);
//			return d;
//		}
//		case BENEATH: {
//			int i=(int) places.get(index).getTop() ;
//			int d= top(i)+height(i)+places.get(index).getTopRelationDistance();//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
//			//TODO Logger.debug("Places.top({}): BENEATH i={}, d={}",index,i,d);
//			return d;
//		}
//		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
//		}
//	}
//
//	public int width(int index) {
//		switch(places.get(index).getWidthRelation()) {
//		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
//		case ABSOLUTE: return places.get(index).getWidth();
//		case RIGHT_OF: //falls through
//		case BENEATH: {
//			int i=(int) places.get(index).getWidth() ;
//			int d= width(i);//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
//			//TODO Logger.debug("Places.width({}): BENEATH i={}, d={}",index,i,d);
//			return d;
//		}
//		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
//		}
//	}
//
//	public int height(int index) {
//		switch(places.get(index).getHeightRelation()) {
//		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
//		case ABSOLUTE: return places.get(index).getHeight();
//		case RIGHT_OF: // falls through
//		case BENEATH: {
//			int i=(int) places.get(index).getHeight() ;
//			int d= height(i);//TODO exception falls null
//			//TODO Logger.debug("Places.height({}): BENEATH i={}, d={}",index,i,d);
//			return d;
//		}
//		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
//		}
//	}
//
//	public RelativeLayout.LayoutParams arrangeControl(View control, int placeIndex) {
//		//TODO Logger.trace("Places.arrangeControl: placeIndex={}",placeIndex);
//        int wid=0;
//        int hei=0;
//		if(!places.get(placeIndex).getLeftRelation().equals(PlaceRelation.DEFAULT)) {
//			//TODO Logger.debug("Places.arrangeControl: placeIndex={}, left not default...",placeIndex);
//			int d=left(placeIndex);
//			if(0!=d) {
//				control.setLayoutX(d);
//			}
//		}
//		if(!places.get(placeIndex).getTopRelation().equals(PlaceRelation.DEFAULT)) {
//			//TODO Logger.debug("Places.arrangeControl: placeIndex={}, top not default...",placeIndex);
//			int d=top(placeIndex);
//			if(0!=d) {
//				control.setLayoutY(d);
//			}
//		}
//		if(!places.get(placeIndex).getWidthRelation().equals(PlaceRelation.DEFAULT)) {
//			//TODO Logger.debug("Places.arrangeControl: placeIndex={}, width not default...",placeIndex);
//			int d=width(placeIndex);
//			if(0!=d) {
//				//control.setMinWidth(d);
//				//control.setMaxWidth(d);
//				wid=d;
//			}
//		}
//		if(!places.get(placeIndex).getHeightRelation().equals(PlaceRelation.DEFAULT)) {
//			//TODO Logger.debug("Places.arrangeControl: placeIndex={}, height not default...",placeIndex);
//			int d=height(placeIndex);
//			if(0!=d) {
//				//control.setMinHeight(d);
//				//control.setMaxHeight(d);
//                hei=d;
//			}
//		}
//        RelativeLayout.LayoutParams para=new RelativeLayout.LayoutParams(wid,hei);//Width, Height
//        return para;
//    }
//
//}