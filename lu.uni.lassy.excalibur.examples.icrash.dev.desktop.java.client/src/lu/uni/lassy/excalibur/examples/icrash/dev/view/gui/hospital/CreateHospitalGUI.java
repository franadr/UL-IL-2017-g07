package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.hospital;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActHospital;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;

public class CreateHospitalGUI implements CreatedWindows{
	
	public CreateHospitalGUI(ActHospital aActHospital, double xPosition, double yPosition){
		start(aActHospital, xPosition, yPosition);
	}
	
	private Stage stage;
	
	public void start(ActHospital aActHospital, double xPosition, double yPosition){
		try{
			URL url = this.getClass().getResource("HospitalGUI.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = (Parent)loader.load();
			stage = new Stage();
			stage.setTitle("Hospital - " + aActHospital.getName());
			stage.setScene(new Scene(root));
			stage.setX(xPosition);
			stage.setY(yPosition);
			stage.show();
			((HospitalGUIController)loader.getController()).setWindow(stage);
			((HospitalGUIController)loader.getController()).setActor(aActHospital);
			stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

				@Override
				public void handle(WindowEvent event) {
					((HospitalGUIController)loader.getController()).closeForm();
					
				}
			});
		}catch(Exception e){
			Log4JUtils.getInstance().getLogger().error(e);
		}
	}
	
	public void closeWindow(){
		if(stage != null)
			stage.close();
	}

}
