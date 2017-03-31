import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;
public class PasswordGenerator extends Application {

       public TextField tfNumbers = new TextField();
	    public TextField tfLetters = new TextField();
	    public TextField tfSpecial = new TextField();
       public TextField tfNewPass = new TextField();
       public CheckBox chkNum = new CheckBox();
       public CheckBox chkLetters = new CheckBox();
       public CheckBox chkSpecial = new CheckBox();
       public boolean numSelect = false;
       public boolean letterSelect = false;
       public boolean specialSelect = false;


	  public void start(Stage primaryStage) {
	    // Create a pane and set its properties
		GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(13.5, 14.5, 15.5, 16.5));
	    pane.setHgap(2.5);
	    pane.setVgap(5.5);
	    
	    
	    pane.add(new Label("Would You Like Numbers?"), 0, 0);
	    pane.add(chkNum, 1, 0);
	    pane.add(new Label("Would You Like Letters?"), 0, 2);
	    pane.add(chkLetters, 1, 2);
	    pane.add(new Label("Would You Like Any Special Characters?" +
                           "\n(!,@,#,$,%,^,&,*,-,+,/)"), 0, 4);
	    pane.add(chkSpecial, 1, 4);
	    
	    Button btGenerate = new Button("Generate");
	    pane.add(btGenerate, 1, 8);

	    
	    pane.add(new Label("How Many Digits Would You Like?"), 0, 1);
	    pane.add(tfNumbers, 1, 1);
	    pane.add(new Label("How Many Letters Would You Like?"), 0, 3);
	    pane.add(tfLetters, 1, 3);
	    pane.add(new Label("How Many Special Characters Would You Like?"), 0, 5);
	    pane.add(tfSpecial, 1, 5);
       
       pane.add(new Label("Your New Password: "), 2, 0);
       pane.add(tfNewPass, 3, 0);
	    
	    GridPane.setHalignment(btGenerate, HPos.RIGHT);
       
       
       tfNewPass.setEditable(false);
    
       btGenerate.setOnAction(e -> getPassword());	    
	    
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Random Password Generator"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	 }
    
    public void getPassword(){
      StringBuilder password = new StringBuilder();
      String letters = "";
      
      if(chkNum.isSelected())
      {
         int numberLimit = Integer.parseInt(tfNumbers.getText());
         String number = "";
         for(int i = 0; i < numberLimit; i++)
         {
            //assigns the amount of digits to number
            number += String.valueOf((int)(Math.random() * 10));
         }
         password.append(number);
      }
      
      if(chkLetters.isSelected())
      {
         String str = "abcdefghijklmnopqrstuvwxyz";
         int limit = str.length();
         Random rnd = new Random();
         int letterLimit = Integer.parseInt(tfLetters.getText());
         for(int i = 0; i < letterLimit; i++)
         {
            int x = rnd.nextInt(limit);
            letters += str.charAt(x);
         }
         password.append(letters);
      }
      if(chkSpecial.isSelected())
      {
         char[] special = {'!','@','#','$','%','^','&','*','-','+','/'};
         String character = "";
         int limit = special.length;
         Random rnd = new Random();
         int specialLimit = Integer.parseInt(tfSpecial.getText());
         for(int i = 0; i < specialLimit; i++)
         {
            int x = rnd.nextInt(limit);
            character += special[x];
         }
         password.append(character);
      }
      tfNewPass.setText(password.toString());
      
    
    }
	
	public static void main(String[] args) {
      launch(args);
	}



}
