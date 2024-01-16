import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SlotMachineSimulation extends Application 
{
	public void start(Stage stage) throws Exception
	{
		try
		{
			//Load the FXML file
			Parent parent = FXMLLoader.load(getClass().getResource
					("SlotMachineSimulation.fxml"));
			//Build the scene graph
			Scene scene = new Scene(parent);
		
			//Display our window using scene graph
			stage.setTitle("SlotMachineSimulation");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		//Launch application
		launch(args);
	}
		
}
