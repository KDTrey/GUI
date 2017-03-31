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


//Lets you know how many kalories to consume to maintain your weight
public class BonusQuiz2 extends Application {
  private TextField tfAge = new TextField();
  private TextField tfHeight = new TextField();
  private TextField tfWeight = new TextField();
  private TextField tfResult = new TextField();
  Button btKalculate = new Button("Kalculate");
  RadioButton rbGenderM = new RadioButton("Male");
  RadioButton rbGenderF = new RadioButton("Female");
  RadioButton rbNVA = new RadioButton("Little or no Exercise");//not very active
  RadioButton rbSA = new RadioButton("Exercise 1-3 times/week");//somewhat active
  RadioButton rbMA = new RadioButton("Exercise 3-5 times/week");//moderatley active
  RadioButton rbVA = new RadioButton("Exercise 5-7 times/week");//very active
  private String[] exerciseLevel = {"Little or no Exercise", "Exercise 1-3 times/week", 
      "Exercise 3-5 times/week", "Exercise 5-7 times/week"};
  
  private ComboBox<String> cbo = new ComboBox<>();
  
   @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
  
    HBox paneForRadioButtons = new HBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
    paneForRadioButtons.getChildren().addAll(rbGenderM, rbGenderF);
    HBox paneForActivityLevel = new HBox(20); 
    
    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setCenter(cbo);

    cbo.setPrefWidth(300);
    tfResult.setEditable(false);
    
    ObservableList<String> items = 
      FXCollections.observableArrayList(exerciseLevel);
    cbo.getItems().addAll(items); 
    
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Age"), 0, 0);
    gridPane.add(tfAge, 1, 0);
    gridPane.add(new Label("Gender"), 0, 1);
    gridPane.add(paneForRadioButtons, 1, 1);
    gridPane.add(new Label("Height in cm"), 0, 2);
    gridPane.add(tfHeight, 1, 2);
    gridPane.add(new Label("Weight in pounds"), 0, 3);
    gridPane.add(tfWeight, 1, 3);
    gridPane.add(new Label("Activity"), 0, 4);
    gridPane.add(paneForComboBox, 1, 4);
    gridPane.add(new Label("Result"), 0, 5);
    gridPane.add(tfResult, 1, 5);
    gridPane.add(btKalculate, 1, 6);
    
    GridPane.setHalignment(btKalculate, HPos.RIGHT);
    btKalculate.setOnAction(e -> kompute(items.indexOf(cbo.getValue())));
    


    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfAge.setAlignment(Pos.BOTTOM_RIGHT);
    tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
    
    ToggleGroup group = new ToggleGroup();
    rbGenderM.setToggleGroup(group);
    rbGenderF.setToggleGroup(group);
    rbNVA.setToggleGroup(group);
    rbSA.setToggleGroup(group);
    rbMA.setToggleGroup(group);
    rbVA.setToggleGroup(group);
     
     // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 750, 250);
    primaryStage.setTitle("Kalorie Kounter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
       
   }
   
   private void kompute(int index)
   {
      double bmr;
      double height = Double.parseDouble(tfHeight.getText());
      double weight = Double.parseDouble(tfWeight.getText()) / 2.2;//switch to kg
      int age = Integer.parseInt(tfAge.getText());
   
      if(rbGenderM.isSelected())
      {
         bmr = 10 * weight + 6.25 * height - 5 * age + 5;
      }
      else
         bmr = 10 * weight + 6.25 * height - 5 * age - 161;
         
      switch(index)
      {
         case 0: tfResult.setText("You need " + Math.floor(bmr * 1.2) + " calories/day to maintain your weight");
                                break;
         case 1: tfResult.setText("You need " + Math.floor(bmr * 1.375) + " calories/day to maintain your weight");
                                break;
         case 2: tfResult.setText("You need " + Math.floor(bmr * 1.55) + " calories/day to maintain your weight");
                                break;
         case 3: tfResult.setText("You need " + Math.floor(bmr * 1.95) + " calories/day to maintain your weight");
                                break;

      }
   }
   
   public static void main(String[] args) {
    launch(args);
  }
}