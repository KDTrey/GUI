import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckBox;

import java.util.*;

public class Hackathon extends Application {
   private TextField tfName = new TextField();
   private TextField tfCity = new TextField();
   private TextField tfNumber = new TextField();
   private TextField tfState = new TextField();
   private TextField tfZip = new TextField();
   private TextField tfID = new TextField();
   Button btSubmit = new Button("Submit");
   private String[] typeDisaster = {"Tornado", "Hurricane", 
      "Earthquake", "Wildfire", "Flood"};
   private ComboBox<String> disasters = new ComboBox<>();
   CheckBox chkFood = new CheckBox("Food");
   CheckBox chkWater = new CheckBox("Water");
   CheckBox chkShelter = new CheckBox("Shelter");
   CheckBox chkMed = new CheckBox("Medical");
   
   @Override
   public void start(Stage primaryStage){
   
   BorderPane paneForComboBox = new BorderPane();
   paneForComboBox.setCenter(disasters);
   disasters.setPrefWidth(200);
   
   VBox paneForSupplies = new VBox(15);
   paneForSupplies.getChildren().addAll(chkFood, chkWater, chkShelter, chkMed);
   paneForSupplies.setPadding(new Insets(5,5,5,5));
   
   ObservableList<String> items = 
   FXCollections.observableArrayList(typeDisaster);
   disasters.getItems().addAll(items);
   
   
   GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Name"), 0, 0);
    gridPane.add(tfName, 1, 0);
    gridPane.add(new Label("City"), 0, 1);
    gridPane.add(tfCity, 1, 1);
    gridPane.add(new Label("State"), 0, 2);
    gridPane.add(tfState, 1, 2);
    gridPane.add(new Label("Zip code"), 0, 3);
    gridPane.add(tfZip, 1, 3);
    gridPane.add(new Label("Phone Number: "), 0, 4);
    gridPane.add(tfNumber, 1, 4);
    gridPane.add(new Label("Type of Disaster"), 0, 5);
    gridPane.add(paneForComboBox, 1, 5);
    gridPane.add(new Label("Supplies Needed"), 0, 6);
    gridPane.add(paneForSupplies, 1, 6);
    gridPane.add(new Label("ID Number: "), 0, 7);
    gridPane.add(tfID, 1, 7);
    gridPane.add(btSubmit, 1, 8);
    
    tfID.setEditable(false);
    
    
    gridPane.setAlignment(Pos.CENTER);
    
    GridPane.setHalignment(btSubmit, HPos.RIGHT);
    
    btSubmit.setOnAction(e -> submission(items.indexOf(disasters.getValue())));
    
    Scene scene = new Scene(gridPane, 550, 550);
    primaryStage.setTitle("Submit A Ticket"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); 

   
   
   }
   
   private void submission(int index){
      
      String str1 = "";
      String str2 = "";
   
      for(int i = 0; i < 5;i++)
      {
         str1 += String.valueOf((int)(Math.random() * 10));
      
      }
      for(int i = 0; i < 5;i++)
      {
         str2 += String.valueOf(((int)(Math.random() * 10)));
      
      }
      switch(index)
      {
         case 0:
         
         case 1:
         
         case 2:
         
         case 3:
         
         case 4:
      
      }
      
      tfID.setText(str1 + str2);
   
   
   
   
   }
   
   
   public static void main(String[] args) {
    launch(args);
  }


   







}