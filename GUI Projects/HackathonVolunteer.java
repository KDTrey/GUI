import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;




public class HackathonVolunteer extends Application {

   private TextField tfComplete = new TextField();
   private TextField tfName = new TextField();
   RadioButton rbYes = new RadioButton("Yes");
   RadioButton rbNo = new RadioButton("No");
   
   
   @Override
   public void start(Stage primaryStage){
   
      HBox paneForRadioButtons = new HBox(20);
      paneForRadioButtons.setPadding(new Insets(5,5,5,5));
      paneForRadioButtons.getChildren().addAll(rbYes, rbNo);
      Button btSign = new Button("Sign Up");
      
      Label info = new Label("Volunteer to Help");
      ToggleGroup group = new ToggleGroup();
      rbYes.setToggleGroup(group);
      rbNo.setToggleGroup(group);
      
      GridPane gridPane = new GridPane();
      gridPane.setHgap(5);
      gridPane.setVgap(5);
      gridPane.add(info, 0, 1);
      gridPane.add(new Label("Do you have a group"),0,2);
      gridPane.add(paneForRadioButtons,1,2);
      gridPane.add(new Label("What is your name/group name"),0,3);
      gridPane.add(tfName,1,3);
      gridPane.add(btSign,1,4);
      info.setAlignment(Pos.CENTER);
      tfComplete.setEditable(false);
      
      gridPane.setAlignment(Pos.CENTER);
      Scene scene = new Scene(gridPane, 350, 250);
      primaryStage.setTitle("Volunteer Sign Up"); // Set title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show();
      

   
   }
   
   
   public static void main(String[] args) {
    launch(args);
  }







}