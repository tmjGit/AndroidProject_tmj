package li.tmj.dbclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import li.tmj.dbclient.ui.ViewGroupTMJ;
import li.tmj.dbclient.ui.fx.model.ViewFactory;

public class MainActivity extends AppCompatActivity {
    public static final int FX_CONTROLS_DISTANCE=8;
    public static final int FX_LINE_HEIGHT=110;
    ViewGroupTMJ stageLy;
//    Controls controls;
//    Places places;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stageLy=findViewById(R.id.stage_ly);
       // setControls(this);
//        EditText t1=new EditText(this);//findViewById(R.id.editText1);
//        t1.setId(View.generateViewId());
//        //ViewGroup.LayoutParams pp=stageLy.getLayoutParams();
//        //Rules rr=pp.getRules();
//        //RelativeLayout.LayoutParams para=  stageLy.getLayoutParams();
//
//        // Parameter für die View
//        RelativeLayout.LayoutParams para=new RelativeLayout.LayoutParams(350,110);//Width, Height
//        //para.addRule(RelativeLayout.ALIGN_PARENT_END);// rechts am Parent
//        //para.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//unten am Parent
//        //para.addRule(RelativeLayout.ALIGN_PARENT_LEFT);//links am Parent
//        para.addRule(RelativeLayout.ALIGN_PARENT_TOP);//oben am Parent
//        para.addRule(RelativeLayout.ALIGN_PARENT_START);//links am Parent
//        //para.addRule(RelativeLayout.ALIGN_TOP);//Open am Parent
//        t1.setPadding(0,0,0,0);//Abstand zum Parent(Constraint) oder anderen Views
//        //t1.setPadding(8,8,8,8);
//        //stageLy.addView(t1);
//        t1.setText("Dies ist t1 ET 1");
//        stageLy.addView(t1, para);//View an ViewGroup mit den Parametern binden
//
//
//        EditText t2=new EditText(this);//findViewById(R.id.editText2);
//        t2.setId(View.generateViewId());
//        t2.setPadding(0,0,0,0);//Abstand zum Parent(Constraint) oder anderen Views
//        para=new RelativeLayout.LayoutParams(350,110);//stageLy.getLayoutParams());
//        para.addRule(RelativeLayout.ALIGN_PARENT_START);//links am Parent
//        para.addRule(RelativeLayout.BELOW, t1.getId());
//        //para.addRule(RelativeLayout.START_OF);
//        t2.setText("Dies ist t2 ET 2");
//        stageLy.addView(t2, para);
//
//
//
//        TextView t3=new TextView(this);
//        t3.setId(View.generateViewId());
//        t3.setPadding(0,0,0,0);
//        para=new RelativeLayout.LayoutParams(350,110);//stageLy.getLayoutParams());
//        para.addRule(RelativeLayout.RIGHT_OF, t1.getId());
//        t3.setText("Dies ist t2 TV 1");
//        stageLy.addView(t3, para);




        ViewFactory fac=new ViewFactory(stageLy);
        stageLy.setWidthDefault(150);
        stageLy.setHeightDefault(75);

        //int i1 = stageLy.insertView(new TextView(this), 120,Integer.MIN_VALUE,RelativeLayout.ALIGN_PARENT_START,"Name");
        int i1 = stageLy.insertView(fac.createTextView(-1), RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.ALIGN_PARENT_START,"Name");

        int i2 = stageLy.insertView(fac.createTextView(-1),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i1,8,"Individual");

        i1 = stageLy.insertView(fac.createEditText(-1),350,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,16,"Name Indiv");

        int i3=stageLy.insertView(fac.createTextView(-1),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i1,16,"Sex");

        int i4=stageLy.insertView(fac.createSpinner(-1,new String[]{"man","woman", "other"}),150,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i3,0,null);//SexCB

        i4=stageLy.insertView(fac.createTextView(-1),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i4,16,"Category");

        stageLy.insertView(fac.createSpinner(-1,new String[]{"Firma","Person"}),200,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i4,0,null);//CategoryCB

        i2=stageLy.insertView(fac.createTextView(-1) ,RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.BELOW, i2,0,"Family");

        //RelativeLayout.BELOW, i3
        i2=stageLy.insertView(fac.createSpinner(-1,new String[]{"von","de"}),120,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,8,null);//nameFamPreCb

        //para.addRule(RelativeLayout.RIGHT_OF, i2);
        i2=stageLy.insertView(fac.createEditText(-1),350,Integer.MIN_VALUE,RelativeLayout.BELOW, i1,16,"Name Fam");

        //para.addRule(RelativeLayout.RIGHT_OF, i2);
        i2=stageLy.insertView(fac.createTextView(-1),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.BELOW, i3,0,"Birth");//birthLabelT

        //para.addRule();//RelativeLayout.BELOW, i3
        i2=stageLy.insertView(fac.createEditText(-1),75,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,8,"DD");//birthDayFld

        //.addRule(RelativeLayout.BELOW, i3);
        i2=stageLy.insertView(fac.createTextView(R.style.entryText),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,0,"."); //dot

        //.addRule(RelativeLayout.BELOW, i3);
        i2=stageLy.insertView(fac.createEditText(-1),75,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,0,"MM");//birthMonthFld

        //.addRule(RelativeLayout.BELOW, i3);
        i2=stageLy.insertView(fac.createTextView(R.style.entryText),RelativeLayout.LayoutParams.WRAP_CONTENT,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,0,"."); //dot

        //.addRule(RelativeLayout.BELOW, i3);
        stageLy.insertView(fac.createEditText(-1),105,Integer.MIN_VALUE,RelativeLayout.RIGHT_OF, i2,0,"YYYY");//birthYearFld

        //controls.add(new  TableView<Address>());//addressView;

        //controls.add(new  TableView<Fone>());//phoneView;

        //controls.add(new  TableView<Person>());//personView;

//		controls.add(new  TableView<Email>());//emailView;

        //  this.setContentView(stageLy);
        //makeControls(stageLy);

        Log.d("**MainActivity","Testtext=0123456789, w="+stageLy.getViewWidth(this,"0123456789",R.style.entryText)+", h="+stageLy.getViewHeight(this,"0123456789",R.style.entryText));

    }




//    private void makeControls(ViewGroup list) {
//        controls=makeControlsList();
//        places=makePlaces();
//        Arrange.arrangeControls(controls,places,list);
//    }
//
//    private Places makePlaces() {
//        Places places=new Places();
//        Place p;
//        int i,j,k;
//
//        p=new Place(FX_CONTROLS_DISTANCE,FX_CONTROLS_DISTANCE,40,FX_LINE_HEIGHT);//nameLabelT
//        p.setHeightRelation(PlaceRelation.ABSOLUTE);
//        k=places.add(p)-1;// ArrayList.add does not return the index as documented! It returns the index+1 or the new size or something like that!
//
//        p=Place.createPlaceRightOf(k);//indivLabelT
//        p.setWidth(70);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//nameIndivFld
//        p.setWidth(200);
//        j=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(j,FX_CONTROLS_DISTANCE);//sexLabelT
//        p.setWidth(60);
//        j=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(j);//   sexCb
//        p.setWidth(80);
//        j=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(j,FX_CONTROLS_DISTANCE);//categoryLabelT;
//        p.setWidth(55);
//        j=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(j);//categoryCb;
//        p.setWidth(90);
//        places.add(p);
//
//        p=Place.createPlaceBeneath(i,FX_CONTROLS_DISTANCE);//familyLabelT
//        p.setHeight(FX_LINE_HEIGHT);
//        p.setHeightRelation(PlaceRelation.ABSOLUTE);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//nameFamPreCb
//        p.setWidth(30);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//nameFamFld
//        p.setWidth(places.get(2).getWidth()-places.get(8).getWidth()); //nameIndivFld - nameFamPreCb
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i,FX_CONTROLS_DISTANCE);//birthLabelT;
//        p.setWidth(places.get(3).getWidth());//sexLabelT
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//birthDayFld;
//        p.setWidth(35);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//dot
//        p.setWidth(10);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//birthMonthFld;
//        p.setWidth(35);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//dot
//        p.setWidth(10);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//birthYearFld;
//        p.setWidth(45);
//        places.add(p);
//
//        p=new Place(k,i,600,100);//addressView;
//        p.setLeftRelation(PlaceRelation.BENEATH);
//        p.setTopRelation(PlaceRelation.BENEATH,FX_CONTROLS_DISTANCE);
//        p.setHeightRelation(PlaceRelation.ABSOLUTE);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceBeneath(i,FX_CONTROLS_DISTANCE);//phoneView;
//        p.setHeight(100);
//        p.setHeightRelation(PlaceRelation.ABSOLUTE);
//        i=places.add(p)-1;
//
//        p=Place.createPlaceBeneath(i,FX_CONTROLS_DISTANCE);//personView;
//        p.setHeight(100);
//        p.setHeightRelation(PlaceRelation.ABSOLUTE);
//        i=places.add(p)-1;
//
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
////		p.setHeight(80);
////		p.setHeightRelation(PlaceRelation.ABSOLUTE);
////		i=places.add(p)-1;
//
//
//
//
//
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//mediaView;
////		p.setHeight(80);
////		p.setHeightRelation(PlaceRelation.ABSOLUTE);
////		i=places.add(p)-1;
//
//
////		controls.add(new  TextView(this));//infoLabel;
////		controls.add(new  TextField());//plzField;
////		controls.add(new  TextField());//ortField;
////		controls.add(new  TextField());//strasseField;
////		controls.add(new  TextField());//telfonField;
////		controls.add(new  TextField());//mobilField;
////		controls.add(new  TextField());//emailField;
//
//
//
////      <TextField fx:id="telfonField" layoutX="602.0" layoutY="440.0" promptText="Telefon" />
////      <TextField fx:id="mobilField" layoutX="441.0" layoutY="440.0" promptText="Mobil" />
////      <TextField fx:id="emailField" layoutX="267.0" layoutY="440.0" promptText="email" />
////        <TextField fx:id="plzField" layoutX="353.0" layoutY="492.0" promptText="PLZ" />
////        <TextField fx:id="ortField" layoutX="518.0" layoutY="480.0" promptText="Ort" />
////        <TextField fx:id="strasseField" layoutX="180.0" layoutY="505.0" promptText="Straße" />
////        <Button fx:id="saveBt" layoutX="28.0" layoutY="505.0" mnemonicParsing="false" text="Save" />
//
//        return places;
//    }
//
//    private Controls makeControlsList(){
//        Controls controls=new Controls();
//
//        controls.add(new  TextView(this)// nameLabelT
//                ,"Name");//language key
//
//        controls.add(new TextView(this), "Individual");//indivLabelT;
//
//        controls.add(new  EditText(this));//nameIndivFld;
//
//        controls.add(new TextView(this),"Sex" );//Localization.get("Sex")) );//sexLabelT;
//
//        controls.add(new Spinner(this));//sexCb;
//
//        controls.add(new TextView(this),"Category");//categoryLabelT;
//
//        controls.add(new  Spinner(this));//categoryCb;
//
//        controls.add(new TextView(this),"Family");//familyLabelT;
//
//        controls.add(new  Spinner(this));//nameFamPreCb;
//
//        controls.add(new  EditText(this));//nameFamFld;
//
//        controls.add(new TextView(this),"Birthday");//birthLabelT;
//
//        controls.add(new  EditText(this));//birthDayFld;
//
//        controls.add(new TextView(this),".");//dot
//
//        controls.add(new  EditText(this));//birthMonthFld;
//
//        controls.add(new TextView(this),".");//dot
//
//        controls.add(new  EditText(this));//birthYearFld;
//
//       // controls.add(new  TableView<Address>());//addressView;
//
//       // controls.add(new  TableView<Fone>());//phoneView;
//
//       // controls.add(new  TableView<Person>());//personView;
//
////		controls.add(new  TableView<Email>());//emailView;
//
//
//
//
//
//
////		controls.add(new  TableView<Media>());//mediaView;
//
////		controls.add(new  TextView(this));//infoLabel;
////		controls.add(new  EditText(this));//plzField;
////		controls.add(new  EditText(this));//ortField;
////		controls.add(new  EditText(this));//strasseField;
////		controls.add(new  EditText(this));//telfonField;
////		controls.add(new  EditText(this));//mobilField;
////		controls.add(new  EditText(this));//emailField;
//        return controls;
//    }

















//    private void setControls(Context context,ViewGroup group,View neighbour){
//        View[] views =new View[2];
//        // Parameter für die View
//        RelativeLayout.LayoutParams para=new RelativeLayout.LayoutParams(400,100);//Width, Height
//        //para.addRule(RelativeLayout.ALIGN_PARENT_END);// rechts am Parent
//        //para.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//unten am Parent
//        //para.addRule(RelativeLayout.ALIGN_PARENT_LEFT);//links am Parent
//        para.addRule(RelativeLayout.ALIGN_PARENT_TOP);//oben am Parent
//        para.addRule(RelativeLayout.ALIGN_PARENT_START);//links am Parent
//        //para.addRule(RelativeLayout.ALIGN_TOP);//Open am Parent
//        //t1.setPadding(0,0,0,0);//Abstand zum Parent(Constraint) oder anderen Views
//        //t1.setPadding(8,8,8,8);
//        views[0]=createTextView(context, group,"Testtext1",para);
//
//        //t1.setPadding(0,0,0,0);//Abstand zum Parent(Constraint) oder anderen Views
//        //t1.setPadding(8,8,8,8);
//
//
//
//       // set.setMargin(textView.getId(), 1, 80);
//       // set.setMargin(textView.getId(), 2, 80);
//    }

//    private void setControls(Context context){
//        int lastID=0;
//        View[] views =new View[2];
//        views[0]=createTextView(context, stageLy,++lastID,"Testtext1");
////        t1.setHeight(19);//android:layout_height="19dp"
////        t1.setWidth(100);  //android:layout_width="100"
//        ConstraintSet set=new ConstraintSet();
//        // set.clone(stageLy);
//     set.constrainHeight(views[0].getId(), 50);//int 100*density
//        //set.constrainWidth(t1.getId(),1000) ;
//       // set.constrainWidth(t1.getId(),ConstraintSet.WRAP_CONTENT) ;
//          System.out.println("view 0:"+views[0].getWidth()+" x "+views[0].getHeight());
//       // set.setMargin(textView.getId(), 1, 80);
//       // set.setMargin(textView.getId(), 2, 80);
//
//        set.connect(views[0].getId(), ConstraintSet.TOP, stageLy.getId(), ConstraintSet.TOP, 8);
//        views[1]=createTextView(context, stageLy,++lastID,"Testtext2");
//        set.constrainHeight(views[1].getId(), 190);//int 100*density
//        // set.constrainWidth(t2.getId(),4000) ;
//        set.constrainWidth(views[1].getId(),ConstraintSet.WRAP_CONTENT) ;
//        set.connect(views[1].getId(), ConstraintSet.TOP, views[0].getId(), ConstraintSet.BOTTOM, 8);
//        //  set.connect(t2.getId(), ConstraintSet.LEFT, t1.getId(), ConstraintSet.RIGHT, 800);
//        set.applyTo(stageLy);
    //}


}
