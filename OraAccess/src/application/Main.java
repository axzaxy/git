package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	APPConnector con=new APPConnector();

	SQLmaker sql =new SQLmaker();

	@Override
	public void start(Stage primaryStage) {
		try {
			
			//scene1 is log in
			Group root1=new Group();
			Scene scene1=new Scene(root1,300,300);
			//scene2 is menu and result
			Group root2= new Group();
			Scene scene2 =new Scene(root2, 1000, 800);
			
			//for scene1---------------------------------------------------------------
			//logging button
			Button login = new Button("Log In");
			login.setFont(new Font(20));
			login.setLayoutX(200);
			login.setLayoutY(250);
			login.setOnAction(new EventHandler<ActionEvent>(){
			    @Override 
			    public void handle(ActionEvent e) {
			    	//switch to menu, establish the connection
			    	String s=con.CreateConnection("root", "axzaxy1", "jdbc:mysql://localhost:3306");
			    	Stage dialogStage =new Stage();
			    	VBox vbox = new VBox(new Text(s));
			    	vbox.setAlignment(Pos.CENTER);
			    	dialogStage.setScene(new Scene (vbox));
			    	dialogStage.show();
			    	primaryStage.setScene(scene2);

			        }
			});
			
			//Header
			Text OraAccess = new Text("OraAccess");
			OraAccess.setFont(new Font(45));
			OraAccess.setX(50);
			OraAccess.setY(50);
			
			//User name
			TextField User=new TextField("User Name");
			User.setMinSize(200, 30);
			User.setLayoutX(50);
			User.setLayoutY(100);
			
			//pass word
			TextField Password=new TextField("Password");
			Password.setMinSize(200, 30);
			Password.setLayoutX(50);
			Password.setLayoutY(150);
			
			//connection string
			TextField ConString=new TextField("Connection String");
			ConString.setMinSize(200, 30);
			ConString.setLayoutX(50);
			ConString.setLayoutY(200);
			
			root1.getChildren().addAll(login,OraAccess,User,Password,ConString);
			
			
			
			//for menu-------------------------------------------------------------------
			
			//title for result
			Text rname = new Text("Result");
			rname.setFont(new Font(45));
			rname.setX(500);
			rname.setY(50);
			
			//table for results
			TableView resultarea=new TableView();
			resultarea.setLayoutX(500);
			resultarea.setLayoutY(60);
			resultarea.setMaxWidth(450);
			resultarea.setMinWidth(450);
			resultarea.setMinHeight(600);
			
			//middle line
			Line line = new Line();
			line.setStartX(400);
			line.setStartY(0);
			line.setEndX(400);
			line.setEndY(800);
			
			//title for result
			Text menutext = new Text("Menu");
			menutext.setFont(new Font(45));
			menutext.setX(100);
			menutext.setY(50);
			
			//title for table
			Text tablehead = new Text("Table");
			tablehead.setFont(new Font(30));
			tablehead.setX(50);
			tablehead.setY(120);
			
			//table list, by listview
			ListView tablelist =new ListView();
			tablelist.setLayoutX(50);
			tablelist.setLayoutY(150);
			tablelist.setMaxWidth(120);
			tablelist.setMinWidth(120);
			tablelist.setMinHeight(200);
			tablelist.setMaxHeight(200);
			
			//title for column
			Text colmhead = new Text("Column");
			colmhead.setFont(new Font(30));
			colmhead.setX(220);
			colmhead.setY(120);
			
			//column list, by listview,
			ListView colmlist =new ListView();
			colmlist.setLayoutX(220);
			colmlist.setLayoutY(150);
			colmlist.setMaxWidth(120);
			colmlist.setMinWidth(120);
			colmlist.setMinHeight(200);
			colmlist.setMaxHeight(200);

			//generated sql, textfield
			TextArea sqlr=new TextArea();
			sqlr.setLayoutX(50);
			sqlr.setLayoutY(450);
			sqlr.setMaxWidth(300);
			sqlr.setMinWidth(300);
			sqlr.setMinHeight(200);
			sqlr.setMaxHeight(200);

			
			//button to select table
			Button selecttable = new Button("SelectTab");
			selecttable.setFont(new Font(25));
			selecttable.setLayoutX(50);
			selecttable.setLayoutY(360);
			selecttable.setOnAction(new EventHandler<ActionEvent>(){
			    @Override 
			    public void handle(ActionEvent e) {
			    	//call sqlmaker and pass the tablename, table type

			    	//notify the sqlr with temporary sqlmaker.result
			        }
			});
			
			//button to select column, it will also pop up a window asking for conditions.
			Button selectcolm = new Button("SelectCol");
			selectcolm.setFont(new Font(25));
			selectcolm.setLayoutX(220);
			selectcolm.setLayoutY(360);
			selectcolm.setOnAction(new EventHandler<ActionEvent>(){
			    @Override 
			    public void handle(ActionEvent e) {
			    	//pop up and ask for conditions, which then call for sqlmaker
	    	
			    	//notify the sqlr with temporary sqlmaker.result
			        }
			});
			
			root2.getChildren().addAll(rname,resultarea,line,menutext,sqlr,tablehead,colmhead,tablelist,colmlist,selecttable,selectcolm);
			
			//-------------------

			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		launch(args);
	}
}
