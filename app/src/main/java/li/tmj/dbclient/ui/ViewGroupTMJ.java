package li.tmj.dbclient.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import li.tmj.dbclient.ui.fx.model.ControlsManager;

public class ViewGroupTMJ extends RelativeLayout{//ViewGroup {
    private static final String TAG = "**ViewGroupTMJ";
    private static final int DISTANCE=32;
    private static int distancePx;
    private  static boolean distanceCalculated=false;
	private List<View> controls=new ArrayList<>();
    private static int widthDefault=100;
    private static int heightDefault=100;
	//private View mValue;
    //private ImageView mImage;

	public ViewGroupTMJ(Context context){
		super(context);
		//init(null);
	}

	public ViewGroupTMJ(Context context, AttributeSet attrs){
		super(context, attrs);
		//init(attrs);
	}

	public ViewGroupTMJ(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		//init(attrs);
	}

    //private void init(AttributeSet attrs){
        //TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.ViewGroupTMJ);
        //String myString = arr.getString(R.styleable.ViewGroupTMJ_myString);
        //int myInteger=arr.getInt(R.styleable.ViewGroupTMJ_myInteger,-1);
        //int myColor = arr.getColor(R.styleable.ViewGroupTMJ_myColor, getResources().getColor( android.R.color.holo_blue_light) );
        //Log.d(TAG,"myString="+myString+", myInteger="+myInteger+", myColor="+String.valueOf(myColor));
        //arr.recycle();
        // more stuff
//        <attr name="left" format="integer" />
//        <attr name="top" format="integer" />
//        <attr name="width" format="integer" />
//        <attr name="height" format="integer" />
//        <attr name="leftRelation" format="integer" />
//        <attr name="topRelation" format="integer" />
//        <attr name="widthRelation" format="integer" />
//        <attr name="heigthRelation" format="integer" />
    //}

    public int getWidthDefault() {
        return widthDefault;
    }

    public void setWidthDefault(int widthDefault) {
        ViewGroupTMJ.widthDefault = widthDefault;
    }

    public int getHeightDefault() {
        return heightDefault;
    }

    public void setHeightDefault(int heightDefault) {
        ViewGroupTMJ.heightDefault = heightDefault;
    }

    public static void calculateDensity(Activity activity) {
        //MyViewGroup.activity = activity;
		DisplayMetrics metrics=new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay()//Display
			.getMetrics(metrics);//Hier wird die Metrics byReference gefüllt.
		distancePx=Math.round( DISTANCE/metrics.density );
        distanceCalculated=true;
        Log.d(TAG,"distancePx="+distancePx);
    }

    /**
     * First calculate your own measuredWidth and measuredHeight.
     * Then based on that tell all children how they need to size themselves.
     * example LinearLayout: “My measuredWidth=100 px, 2 children -> each width=50 px exactly.
     * -> pass MeasureSpec object which defines how the child should interpret the measurement its receiving: either EXACTLY, AT MOST or UNSPECIFIED.
     * child uses those cues to create its own measuredWidth & measuredHeight (by usually calling setMeasuredDimension at some point in the onMeasure).
     * @param widthMeasureSpec = imparted width of this ViewGroup
     * @param heightMeasureSpec = imparted width of this ViewGroup
     */
	//@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//	    int dist=distanceCalculated ? distancePx : DISTANCE*10;
//        Log.d(TAG,"onMeasure "+(distanceCalculated ? "distancePx="+distancePx : "DISTANCE="+DISTANCE*10));
////		At this time we need to call setMeasuredDimensions(). Lets just call the parent View's method
////		(see https://github.com/android/platform_frameworks_base/blob/master/core/java/android/view/View.java)
////		that does:
////		setMeasuredDimension( getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
////                            getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec); // Request processing of size values to be able to handle them.
//        //measureChildWithMargins()
//        // Calculate children's sizes by own means:
//		int wspec = MeasureSpec.makeMeasureSpec(getMeasuredWidth()/getChildCount()-dist, MeasureSpec.EXACTLY);
//		int hspec = MeasureSpec.makeMeasureSpec(getMeasuredHeight()-dist, MeasureSpec.EXACTLY);
//        Log.d(TAG, "Measured Width="+getMeasuredWidth()+", Height="+getMeasuredHeight());
//		for(int i=0; i<getChildCount(); i++){ // Communicate calculated size to children
//			getChildAt(i).measure(wspec, hspec);
//		}
//	}

    /**
     * onLayout: triggered after ViewGroup itself has finished laying itself out inside its own container.
     * Has to lay out children by calling each child's layout method.
     * @param changed
     * @param left = child's position
     * @param top = child's position
     * @param right = left+width <=> width = right-left
     * @param bottom = top-height <=> height = top-bottom
     */
//	@Override
//	protected void onLayout(boolean changed, int left, int top, int right, int bottom) { // pixel!
//        int dist=distanceCalculated ? distancePx : DISTANCE*10;
//        int itemWidth = (right-left)/getChildCount();
//        //int itemWidth = (right-left)/getChildCount()-DISTANCE;
//        Log.d(TAG,"onLayout "+(distanceCalculated ? "distancePx="+distancePx : "DISTANCE="+DISTANCE*10));
//		for(int i=0; i<this.getChildCount(); i++){
//			View c = getChildAt(i);
//
//           // String myString = arr.getString(R.styleable.ViewGroupTMJ_myString);
//           // int myInteger=arr.getInt(R.styleable.ViewGroupTMJ_myInteger,-1);
//           // int myColor = arr.getColor(R.styleable.ViewGroupTMJ_myColor, getResources().getColor( android.R.color.holo_blue_light) );
//           // Log.d(TAG,"myString="+myString+", myInteger="+myInteger+", myColor="+String.valueOf(myColor));
//           // arr.recycle();
//
//            // arrangeControl(c,i);
//
//            int itemLeft=i*itemWidth;
//			c.layout(itemLeft, 0, itemLeft+itemWidth-dist, bottom-top+dist);
//		}
//	}


//    @Override
//    protected void onAttachedToWindow() {//is called once the window is available.
//        super.onAttachedToWindow();
//    }


    /*
    is used when the view is removed from its parent (and if the parent is attached to a window). This happens for example if the activity is recycled (e.g. via the finished() method call) or if the view is recycled.
     */
//    @Override
//    protected void onDetachedFromWindow() {//can be used to stop animations and to clean up resources used by the view.
//        super.onDetachedFromWindow();
//    }

    //package li.tmj.cvgtmj.ui.controls.model;

//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import static android.view.View.VISIBLE;

/*
Varianten:
    absolut width, absolut height, align_parent_start
    absolut width, absolut height, RIGHT_OF <ref>, distance, höhe übernehmen
    absolut width, absolut height, BELOW, distance, right_of übernehmen übernehmen
 */
    public int insertView(View c, int width, int height, int relation, String text) {
        return insertView(c,width,height,relation,-1,-1,text);
    }
    public int insertView(View c, int width, int height, int relation, int referenceViewId, int padding) {
        return insertView(c,width,height,relation,referenceViewId,padding,null);
    }

    public int insertView(View c, int width, int height, int relation) {
        return insertView(c,width,height,relation,-1,-1,null);
    }
    public int insertView(View c, int width, int height, int relation, int referenceViewId, int padding, String text) {
        c.setId(View.generateViewId());
        int w=width==Integer.MIN_VALUE ? widthDefault:width;
        int h=height==Integer.MIN_VALUE ? heightDefault:height;
        RelativeLayout.LayoutParams para=new RelativeLayout.LayoutParams(w,h);
         //para=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, h);
        //public int insertView(View c, RelativeLayout.LayoutParams para, int leftPadding, int topPadding, int rightPadding, int bottomPadding, String text) {
        int leftPadding=0;
        int topPadding=0;
        int rightPadding=0;
        int bottomPadding=0;
        switch(relation){
            case RelativeLayout.ALIGN_PARENT_START: {
                para.addRule(relation);
                break;
            }
            case RelativeLayout.RIGHT_OF: {
                leftPadding=padding;
               // ViewGroup.LayoutParams p=controls.get(referenceViewId).getLayoutParams();
      //          ViewGroup.LayoutParams.getR
                //         int[] RelativeLayout.LayoutParams.getRules();
                //p.getRules();
                para.addRule(relation,referenceViewId);
                para.addRule(RelativeLayout.ALIGN_TOP,referenceViewId);
                break;
            }
            case RelativeLayout.BELOW: {
                topPadding=padding;
                para.addRule(relation,referenceViewId);
                para.addRule(RelativeLayout.ALIGN_START,referenceViewId);
                break;
            }
        }

        //public int insertView(View c, RelativeLayout.LayoutParams para, int leftPadding, int topPadding, int rightPadding, int bottomPadding, String text) {
        //public int insertView(View c, RelativeLayout.LayoutParams para, int leftPadding, int topPadding, int rightPadding, int bottomPadding, String text) {
        //public int insertView(View c, RelativeLayout.LayoutParams para, int leftPadding, int topPadding, int rightPadding, int bottomPadding, String text) {
//        if (c instanceof TextView) {
//            //Material.Small
//            // ((TextView) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//            // ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            if (android.os.Build.VERSION.SDK_INT < 23) {
//                ((TextView) c).setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Small);
//            } else {
//                ((TextView) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            }
//        } else if (c instanceof EditText) {
//            // ((EditText) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//            //android:textAppearance="@android:style/TextAppearance.Material.Small"
//           if (android.os.Build.VERSION.SDK_INT < 23) {
//                ((EditText) c).setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Small);
//            } else {
//                ((EditText) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
//            }
//        } else if (c instanceof Spinner) {//else Spinner
////               ((Spinner) c).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
////               //android:textAppearance="@android:style/TextAppearance.Material.Small"
//                //TextView t=findViewById(android.R.layout.simple_list_item_1);
////               if (android.os.Build.VERSION.SDK_INT < 23){
////                   ((Spinner) c).text//setTextAppearance(this,R.style.TextAppearance_AppCompat_Small);
////               } else {
////                   ((Spinner) c).setTextAppearance(R.style.TextAppearance_AppCompat_Small);
////               }
//        }
        if (null != text) {
            ControlsManager.setText(c, text);
        }
		controls.add(c);
		c.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
		addView(c, para);//View an ViewGroup mit den Parametern binden
		return c.getId();
	}

//    public static int getHeight(Context context, String text, int textSize, int deviceWidth) {
//        TextView textView = new TextView(context);
//        textView.setText(text);
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
//        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(deviceWidth, MeasureSpec.AT_MOST);
//        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
//        textView.measure(widthMeasureSpec, heightMeasureSpec);
//        return textView.getMeasuredHeight();
//    }

    public int getViewWidth(Activity activity, String text, int textStyle) {
        Display display= activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);//Hier wird die Metrics byReference gefüllt.
        int pxWidth=metrics.widthPixels;
        int pxHeight=metrics.heightPixels;

        TextView c = new TextView(getContext());
        c.setText(text);
        c.setTextAppearance(getContext(),textStyle);
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(pxWidth, MeasureSpec.AT_MOST);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        c.measure(widthMeasureSpec, heightMeasureSpec);
        return c.getMeasuredWidth();
    }


    public int getViewHeight(Activity activity, String text, int textStyle) {
        Display display= activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);//Hier wird die Metrics byReference gefüllt.
        int pxWidth=metrics.widthPixels;
        int pxHeight=metrics.heightPixels;

        TextView c = new TextView(getContext());
        c.setText(text);
        c.setTextAppearance(getContext(),textStyle);
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(pxWidth, MeasureSpec.AT_MOST);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        c.measure(widthMeasureSpec, heightMeasureSpec);
        return c.getMeasuredHeight();
    }

}
