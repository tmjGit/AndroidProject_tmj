//package li.tmj.ui.fx;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.ResourceBundle;
//import org.pmw.tinylog.Logger;
//import javafx.concurrent.Task;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.event.ActionEvent;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import li.tmj.app.Application;
//import li.tmj.db.hibernate.DataHiberDAO;
//import li.tmj.dbclient.db.model.Address;
//import li.tmj.dbclient.db.model.Data;
////import li.tmj.db.model.Email;
//import li.tmj.dbclient.db.model.Person;
//import li.tmj.dbclient.db.model.Fone;
//import li.tmj.ui.fx.controls.ObjectCombobox;
//import li.tmj.ui.fx.model.Arrange;
//import li.tmj.ui.fx.model.Controls;
//import li.tmj.ui.fx.model.Place;
//import li.tmj.ui.fx.model.PlaceRelation;
//import li.tmj.ui.fx.model.Places;
//import li.tmj.ui.lang.Localization;
//
//public class PersonController implements Initializable {
//	@FXML AnchorPane anchorPane;
//	@FXML Button searchBt;
//	@FXML Button menuBt;
//	@FXML Button newWindowBt;
//	@FXML Button submitBt;
//	@FXML Label infoT;
//	@FXML Label idT;
//	@FXML TextField idFld;
//
//	Controls controls;
//	Places places;
//	Person currentPerson;
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		setFxText();
//		makeControls(anchorPane.getChildren());
//		objectOut(currentPerson);
//	}
//
//	private void setFxText() {
//		searchBt.setText(Localization.get("Find"));
//		menuBt.setText(Localization.get("Menu"));
//		newWindowBt.setText(Localization.get("NewWindow"));
//		submitBt.setText((Localization.get("Save")));
//	}
//
//	private void makeControls(ObservableList<Node> list) {
//		controls=makeControlsList();
//		places=makePlaces();
//		Arrange.arrangeControls(controls,places,list);
//	}
//
//	private Places makePlaces() {
//		Places places=new Places();
//		Place p;
//		int i,j,k;
//
//		p=new Place(Application.FX_CONTROLS_DISTANCE,Application.FX_CONTROLS_DISTANCE,40,Application.FX_LINE_HEIGHT);//nameLabelT
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		k=places.add(p)-1;// ArrayList.add does not return the index as documented! It returns the index+1 or the new size or something like that!
//
//		p=Place.createPlaceRightOf(k);//indivLabelT
//		p.setWidth(70);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//nameIndivFld
//		p.setWidth(200);
//		j=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(j,Application.FX_CONTROLS_DISTANCE);//sexLabelT
//		p.setWidth(60);
//		j=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(j);//   sexCb
//		p.setWidth(80);
//		j=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(j,Application.FX_CONTROLS_DISTANCE);//categoryLabelT;
//		p.setWidth(55);
//		j=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(j);//categoryCb;
//		p.setWidth(90);
//		places.add(p);
//
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//familyLabelT
//		p.setHeight(Application.FX_LINE_HEIGHT);
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		i=places.add(p)-1;
//
//        p=Place.createPlaceRightOf(i);//nameFamPreCb
//		p.setWidth(30);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//nameFamFld
//		p.setWidth(places.get(2).getWidth()-places.get(8).getWidth()); //nameIndivFld - nameFamPreCb
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i,Application.FX_CONTROLS_DISTANCE);//birthLabelT;
//		p.setWidth(places.get(3).getWidth());//sexLabelT
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//birthDayFld;
//		p.setWidth(35);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//dot
//		p.setWidth(10);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//birthMonthFld;
//		p.setWidth(35);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//dot
//		p.setWidth(10);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceRightOf(i);//birthYearFld;
//		p.setWidth(45);
//		places.add(p);
//
//		p=new Place(k,i,600,100);//addressView;
//		p.setLeftRelation(PlaceRelation.BENEATH);
//		p.setTopRelation(PlaceRelation.BENEATH,Application.FX_CONTROLS_DISTANCE);
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
//		p.setHeight(100);
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		i=places.add(p)-1;
//
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
//		p.setHeight(100);
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		i=places.add(p)-1;
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
////		controls.add(new  Label());//infoLabel;
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
//		return places;
//	}
//
//	private Controls makeControlsList(){
//		Controls controls=new Controls();
//
//		controls.add(new  Label()// nameLabelT
//				,"Name");//language key
//
//		controls.add(new Label(), "Individual");//indivLabelT;
//
//		controls.add(new  TextField());//nameIndivFld;
//
//		controls.add(new Label(Localization.get("Sex")) );//sexLabelT;
//
//		controls.add(new  ObjectCombobox());//sexCb;
//
//		controls.add(new Label(Localization.get( "Category")));//categoryLabelT;
//
//		controls.add(new  ObjectCombobox());//categoryCb;
//
//		controls.add(new Label(Localization.get( "Family")));//familyLabelT;
//
//		controls.add(new  ObjectCombobox());//nameFamPreCb;
//
//		controls.add(new  TextField());//nameFamFld;
//
//		controls.add(new Label(Localization.get("Birthday" )));//birthLabelT;
//
//		controls.add(new  TextField());//birthDayFld;
//
//		controls.add(new Label(Localization.get(".")));//dot
//
//		controls.add(new  TextField());//birthMonthFld;
//
//		controls.add(new Label(Localization.get(".")));//dot
//
//		controls.add(new  TextField());//birthYearFld;
//
//		controls.add(new  TableView<Address>());//addressView;
//
//		controls.add(new  TableView<Fone>());//phoneView;
//
//		controls.add(new  TableView<Person>());//personView;
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
////		controls.add(new  Label());//infoLabel;
////		controls.add(new  TextField());//plzField;
////		controls.add(new  TextField());//ortField;
////		controls.add(new  TextField());//strasseField;
////		controls.add(new  TextField());//telfonField;
////		controls.add(new  TextField());//mobilField;
////		controls.add(new  TextField());//emailField;
//		return controls;
//	}
//
////	private ArrayList<String> makeContentList(){
////		ArrayList<String> texts=new ArrayList<>();
////
////		controls.add(new Label(Localization.get( );// nameLabelT;
////		c.setId("Name");//language key
////		controls.add(c);
////
////		controls.add(new Label(Localization.get( );//indivLabelT;
////		c.setId("Individual");
////		controls.add(c);
////
////		controls.add(new  TextField());//nameIndivFld;
////
////		controls.add(new Label(Localization.get( );//sexLabelT;
////		c.setId("Sex");//Geschlecht
////		controls.add(c);
////
////		controls.add(new  ObjectCombobox());//sexCb;
////
////		controls.add(new Label(Localization.get( );//categoryLabelT;
////		c.setId("Category");
////		controls.add(c);
////
////		controls.add(new  ObjectCombobox());//categoryCb;
////
////		controls.add(new Label(Localization.get( );//familyLabelT;
////		c.setId("Family");
////		controls.add(c);
////
////		controls.add(new  ObjectCombobox());//nameFamPreCb;
////
////		controls.add(new  TextField());//nameFamFld;
////
////		controls.add(new Label(Localization.get( );//birthLabelT;
////		c.setId("Birthday");
////		controls.add(c);
////
////		controls.add(new  TextField());//birthDayFld;
////
////		controls.add(new Label());//dot
////
////		controls.add(new  TextField());//birthMonthFld;
////
////		controls.add(new Label());//dot
////
////		controls.add(new  TextField());//birthYearFld;
////
////		controls.add(new  TableView<Address>());//addressView;
////
////		controls.add(new  TableView<Fone>());//phoneView;
////
////		controls.add(new  TableView<Person>());//personView;
////
////		controls.add(new  TableView<Email>());//emailView;
////
////
////	}
////
////	private void placeControls(ArrayList<Control> controls, ArrayList<Place> places) {
////		int count=controls.size();
////		for(int i=0;i<count; i++) {
////			if(null!=controls.get(i)) {
////				double d=places.get(i).getLeft();
////				if(0>=d) {//special value means relative to
////
////				}
////				controls.get(i).setLayoutX(places.get(i).getLeft());
////				controls.get(i).setLayoutY(places.get(i).getTop());
////			}
////		}
////
////	}
//
//
//	@FXML
//	private void menuBtAction(ActionEvent event)  {
//		try {
//			FxScene.MAIN.showOnNewStage();
//		} catch (IOException e) {
//			Logger.error(e,"Could not open new window!");
//		}
////		FxManager.closeMyStage(parent);
//	}
//
//	@FXML private void newWindowBtAction(ActionEvent event)  {
//		try {
//			FxScene.PERSON.showOnNewStage();
//		} catch (IOException e) {
//			Logger.error(e,"Could not open new window!");
//		}
//	}
//
//	@FXML private void searchBtAction(ActionEvent event) {
//		Button b=(Button) event.getSource();//searchBt
//		if(b.getText().equals(Localization.get("Find"))) { // invoking search mode
//			idT.setText(Localization.get("Find"));
//			searchBt.setText(Localization.get("Cancel"));
//			submitBt.setText(Localization.get("Search"));
//			idFld.setText("");
//			currentPerson=objectIn();
//			controls.clearFields();
//			info("Search mode started.");;
//
//		}else { // canceling search
//			idT.setText(Localization.get("ID"));
//			searchBt.setText(Localization.get("Find"));
//			submitBt.setText(Localization.get("Save"));
//			if(null!=currentPerson) {
//				objectOut(currentPerson);
//			}
//			info("Search canceled.");
//		}
//	}
//
//	private void submitBtActionNoTask(ActionEvent event) {// w/o Task, Task sometimes produces "no fx thread" errors.
//		Button b=(Button) event.getSource();//submitBt
//		b.setDisable(true);// Disable this function until we finished.
//		searchBt.setDisable(true);
//		if(b.getText().equals(Localization.get("Search"))) { // do a search
//			b.setText(Localization.get("Searching"+"..."));
//			info("Searching...");
//			DAOcall("read");
//
//		}else if(b.getText().equals(Localization.get("Save"))) { // save information
//			b.setText(Localization.get("Saving"+"..."));
//			info("Saving...");
//			DAOcall("save");
//
//		}
//	}
//
//	protected void DAOcall(String mode) { // w/o Task
//		DataHiberDAO dao=new DataHiberDAO();
//		Person person = objectIn();
//		System.out.println("PersonController.DAO.call: mode="+mode+", person="+person);
//		switch(mode) {
//			case "read": {
//				System.out.println("Reading by example person="+person);
//				List<Data> persons=dao.find(person);
//				System.out.println("Found " + persons.size() + " persons="+persons);
//				info("Found " + persons.size() + " persons="+persons);
//				currentPerson=(Person) persons.get(0);//erster Datensatz des Suchergebnisses
//				objectOut(currentPerson);
//				break;
//			}
//			case "save":{
//				System.out.println("Saving person="+person);
//				dao.save(person);
//				break;
//			}
//		}
//
//	}
//
//	public void DAOfinished(String mode) { // w/o Task
//		System.out.println("PersonController.DAO.finished: mode="+mode);
//		switch(mode) {
//			case "read":{
//				searchBt.setText(Localization.get("Find"));
////				info("Searched.");
//				break;
//			}
//			case "save":{
////				info("Saved.");
//				break;
//			}
//		}
//		submitBt.setText(Localization.get("Save"));
//		submitBt.setDisable(false);// We finished.
//		searchBt.setDisable(false);
//	}
//
//	@FXML private void submitBtAction(ActionEvent event) {
////		submitBtActionNoTask(event);
//		Button b=(Button) event.getSource();//submitBt
//		b.setDisable(true);// Disable this function until we finished.
//		searchBt.setDisable(true);
//		DaoTask d=new DaoTask();
//		Thread th=new Thread(d);	// we need the thread to uncouple the FX Thread from the database action
//		if(b.getText().equals(Localization.get("Search"))) { // do a search
//			b.setText(Localization.get("Searching"+"..."));
//			info("Searching...");
//			d.mode="read";
//
//		}else if(b.getText().equals(Localization.get("Save"))) { // save information
//			b.setText(Localization.get("Saving"+"..."));
//			info("Saving...");
//			d.mode="save";
//
//		}
//		th.start();
//	}
//
//
//	private class DaoTask extends Task<String>{
//		public String mode;
//
//		public DaoTask() {
//			setOnSucceeded(e->{ finished(); });
//		}
//
//		@Override
//		protected String call() throws Exception {
//			DataHiberDAO dao=new DataHiberDAO();
//			Person person = objectIn();
//			System.out.println("PersonController.DAO.call: mode="+mode+", person="+person);
//			switch(mode) {
//				case "read": {
//					System.out.println("Reading by example person="+person);
//					List<Data> persons=dao.find(person);
//					System.out.println("Found " + persons.size() + " persons="+persons);
//					info("Found " + persons.size() + " persons="+persons);
//					if(null==persons) {//Exception?
//						Logger.error("Datenbankabfrage lieferte einen leeren Verweis (null)!");
//					}else {//TODO Listenverarbeitung, anzeige des ResultSets
//						info(persons.size()+" "+Localization.get("Datensätze gefunden!"));//TODO Spracheintrag!
//						if(persons.size()<1) {
//							currentPerson=new Person();
//						}else {
//							currentPerson=(Person) persons.get(0);//erster Datensatz des Suchergebnisses als Workaround
//						}
//						objectOut(currentPerson);
//						break;
//					}
//				}
//				case "save":{
//					System.out.println("Saving person="+person);
//					dao.save(person);
//					break;
//				}
//			}
//			return ""; // value
//
//		}
//
//		public void finished() {
//			System.out.println("PersonController.DAO.finished: mode="+mode);
//			switch(mode) {
//				case "read":{
//					searchBt.setText(Localization.get("Find"));
////					info("Searched.");
//					break;
//				}
//				case "save":{
////					info("Saved.");
//					break;
//				}
//			}
//			submitBt.setText(Localization.get("Save"));
//			submitBt.setDisable(false);// We finished.
//			searchBt.setDisable(false);
//		}
//	}
//
//	private void objectOut(Person person) {
//		idT.setText("ID");
//		if(null==person) {
//			idFld.setText("");
//			controls.setText(2, "");//nameIndivFld;
//			controls.setText(8, "");//nameFamPreCb
//			controls.setText(9, "");//nameFamFld;
//			controls.setText(4, "");//sexCb;
//			controls.setText(6, "");//categoryCb;
//			controls.setText(11, "");//birthDayFld;
//			controls.setText(13, "");//birthMonthFld;
//			controls.setText(15, "");//birthYearFld;
//		}else {
//			idFld.setText(Integer.toString(person.getId()));
//			controls.setText(2, person.getNameIndividual());//nameIndivFld;
//			controls.setText(8, person.getNameFamilyPre());//nameFamPreCb
//			controls.setText(9, person.getNameFamily());//nameFamFld;
//			controls.setText(4, person.getSex());//sexCb
//			controls.setText(6, person.getCategory());//categoryCb
//			controls.setText(11, Integer.toString(person.getBirthDay()));//birthDayFld;
//			controls.setText(13, Integer.toString(person.getBirthMonth()));//birthMonthFld;
//			controls.setText(15, Integer.toString(person.getBirthYear()));//birthYearFld;
//		}
////		p=new Place(k,i,600,100);//addressView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
//	}
//
//	private Person objectIn() {
//		Person person=new Person();
//		String s;
//		s=idFld.getText();
//		if(null!=s && !"".equals(s)) {
//			person.setId(Integer.parseInt(s));
////			callByName(person, person.getClass().getName(), "setId",new Class[] {Integer.class},new Object[] {  Integer.parseInt(s) }) ;
//		}
//		s=controls.getText(2);//nameIndivFld
//		if(null!=s && !"".equals(s)) {
//			person.setNameIndividual(s);
//		}
//		s=controls.getText(8);//nameFamPreFld
//		if(null!=s && !"".equals(s)) {
//			person.setNameFamilyPre(s);
//		}
//		s=controls.getText(9);//nameFamFld
//		if(null!=s && !"".equals(s)) {
//			person.setNameFamily(s);
//		}
//		s=controls.getText(4);//sexCb
//		if(null!=s && !"".equals(s)) {
//			person.setSex(s);
//		}
//		s=controls.getText(6);//categoryCb
//		if(null!=s && !"".equals(s)) {
//			person.setCategory(s);
//		}
//		s=controls.getText(11);//birthDayFld
//		if(null!=s && !"".equals(s)) {
//			person.setBirthDay(Integer.parseInt(s));
//		}
//		s=controls.getText(13);//birthMonthFld
//		if(null!=s && !"".equals(s)) {
//			person.setBirthMonth(Integer.parseInt(s));
//		}
//		s=controls.getText(15);//birthYearFld
//		if(null!=s && !"".equals(s)) {
//			person.setBirthYear(Integer.parseInt(s));
//		}
////		p=new Place(k,i,600,100);//addressView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
////		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
//		return person;
//	}
//
//	public void callByName(Object objectToInvokeOn, String Classname,String methodName,Class[] parameterTypes,Object[] params) {
////		Use reflection:
////		http://java.sun.com/docs/books/tutorial/reflect/member/methodInvocation.html
////			Class<?> c = Class.forName("class name");
////			Method  method = c.getDeclaredMethod ("method name", parameterTypes)
////			method.invoke (objectToInvokeOn, params)
////			Where:
////			"class name" is the name of the class
////			objectToInvokeOn is of type Object and is the object you want to invoke the method on "method name" is the name of the method you want to call
////			parameterTypes is of type Class [] and decalres the parameters the method takes
////			params is of type Object [] and declares the parameters to be passed to the method
//
////			Object objectToInvokeOn=new Person();
//			try {
//				Class<?> c = Class.forName(Classname);//"Person");
////				String methodName="setSex";
////				Class[] parameterTypes=new Class[] {String.class};
////				Object[] params=new Object[] {"männlich"};
//				Method  method = c.getDeclaredMethod (methodName, parameterTypes);
//				method.invoke (objectToInvokeOn, params);
//
//			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//
//	private void info(String msg) {
//		infoT.setText(LocalDateTime.now().toString()+" "+msg);
//	}
//}
//
//
