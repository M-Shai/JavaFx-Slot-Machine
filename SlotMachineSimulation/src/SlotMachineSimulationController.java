
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SlotMachineSimulationController extends AnchorPane
{
	
	//my image array field, stores image objects
	private Image[] imageArray = new Image[10];
	//my accumulator
	private double ttlAmount = 0;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="totalAmount"
    private Label totalAmount; // Value injected by FXMLLoader

    @FXML // fx:id="image3"
    private ImageView image3; // Value injected by FXMLLoader

    @FXML // fx:id="SpinButton"
    private Button spinButton; // Value injected by FXMLLoader

    @FXML // fx:id="image1"
    private ImageView image1; // Value injected by FXMLLoader

    @FXML // fx:id="spinAmount"
    private Label spinAmount; // Value injected by FXMLLoader

    @FXML // fx:id="image2"
    private ImageView image2; // Value injected by FXMLLoader

    @FXML // fx:id="textField"
    private TextField textField; // Value injected by FXMLLoader
    	
    @FXML // This method is called by the FXMLLoader
    void initialize() 
    {
        assert totalAmount != null : "fx:id=\"totalAmount\" was not injected:"
        		+ " check your FXML file 'SlotMachineSimulation.fxml'.";
        assert image3 != null : "fx:id=\"image3\" was not injected: check your"
        		+ " FXML file 'SlotMachineSimulation.fxml'.";
        assert spinButton != null : "fx:id=\"spinButton\" was not injected: "
        		+ "check your FXML file 'SlotMachineSimulation.fxml'.";
        assert image1 != null : "fx:id=\"image1\" was not injected: check "
        		+ "your FXML file 'SlotMachineSimulation.fxml'.";
        assert spinAmount != null : "fx:id=\"spinAmount\" was not injected: "
        		+ "check your FXML file 'SlotMachineSimulation.fxml'.";
        assert image2 != null : "fx:id=\"image2\" was not injected: check your"
        		+ " FXML file 'SlotMachineSimulation.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: "
        		+ "check your FXML file 'SlotMachineSimulation.fxml'.";
        
        //method to initialize the Image array
        imageArray[0] = new Image("file:Apple.png");
        imageArray[1] = new Image("file:Banana.png");
        imageArray[2] = new Image("file:Cherries.png");
        imageArray[3] = new Image("file:Grapes.png");
        imageArray[4] = new Image("file:Lemon.png");
        imageArray[5] = new Image("file:Lime.png");
        imageArray[6] = new Image("file:Orange.png");
        imageArray[7] = new Image("file:Pear.png");
        imageArray[8] = new Image("file:Strawberry.png");
        imageArray[9] = new Image("file:Watermelon.png");
    
        //System.out.println("::imageArray:: \n" + imageArray[2]);
    }
    
    //spin button event listener
    public void spinBtnlistener()
    {

    	//array to hold random integer from 0 -9
		int[] rndmArray = new int[3];
		
		//check to see if text field is empty
		if(textField.getText().isEmpty())
		{
			System.out.println("Please enter an amount");
		}
		
		else
		{
			//get amount from text field
			double amount = Double.parseDouble(textField.getText());
			//System.out.println("\nInside spinBtnListener\n");
		
			//initializes rndmArray with random integers
			Random rand = new Random();
			for(int i = 0;i < 3; i++)
			{
				//random number 0 - 9
				rndmArray[i] = rand.nextInt(10);

			}
			//decision structure to determine matches
			//if all 3 fruits match
			/*if(rndmArray[0] == rndmArray[1] && rndmArray[1] == rndmArray[2])
			{
				amount = amount * 3;
				System.out.println("Match 3");
			}*/
			//if any of the fruits match
			if(rndmArray[0] == rndmArray[1] || rndmArray[0] == rndmArray[2] || 
					rndmArray[1] == rndmArray[2])
			{
				if(rndmArray[0] == rndmArray[1] && 
						rndmArray[1] == rndmArray[2])
				{
					amount = amount * 3;
					System.out.println("Match 3::  :" + rndmArray[0] + " :" 
							+ rndmArray[1] + " :" + rndmArray[2]);
				}
				else
				{
					amount = amount * 2;
					System.out.println("Match 2::  :" + rndmArray[0] + " :" 
							+ rndmArray[1] + " :" + rndmArray[2]);
				}
			}
			//if no fruits match
			else
			{
				amount = amount * 0;
				System.out.println("No Match::  :" + rndmArray[0] + " :" 
						+ rndmArray[1] + " :" + rndmArray[2]);
			}
			//adds winnings to ttlAmount accumulator
			ttlAmount += (amount);
			//output current spin winnings to spinAmount label
			spinAmount.setText(String.format("%,.2f", amount));
			//output current total winnings to totalAmount label
			totalAmount.setText(String.format("%,.2f", ttlAmount));
    	
			//sets all 3 image containers to an image
			//corresponding to the rndmArray
			//System.out.println(imageArray[rndmArray[0]]);
			image1.setImage(imageArray[rndmArray[0]]);
			//System.out.println(imageArray[rndmArray[1]]);
			image2.setImage(imageArray[rndmArray[1]]);
			//System.out.println(imageArray[rndmArray[2]]);
			image3.setImage(imageArray[rndmArray[2]]);
		}
    }
}
