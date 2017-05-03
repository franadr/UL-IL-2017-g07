package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.phone;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.ICrashAdminGUIController;

public class CreatePhoneGUI implements CreatedWindows {

		
		public CreatePhoneGUI(ICrashAdminGUIController adminGUIController, double x, double y){
			start(adminGUIController, x, y);
		}
		/** The stage that will host the form. */
		private Stage stage;
		
		
		/**
		 * Generates and shows the window on the screen
		 */
		public void start(ICrashAdminGUIController adminGUIController, double x, double y){
			try {
				URL url = this.getClass().getResource("PhoneGUI.fxml");
				FXMLLoader loader = new FXMLLoader(url);
				Parent root = (Parent)loader.load();
	            stage = new Stage();
	            stage.setTitle("Requesting Phone Number");
	            stage.setScene(new Scene(root));
	            stage.initOwner(adminGUIController.getWindow());
				stage.initModality(Modality.WINDOW_MODAL);
	            stage.setX(x);
	            stage.setY(y);
	            stage.show();
	            ((PhoneGUIController)loader.getController()).setWindow(stage);
	            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						((PhoneGUIController)loader.getController()).closeForm();
					}
				});
	            
	            ((PhoneGUIController) loader.getController()).setAdminGUIController(adminGUIController);
				((PhoneGUIController) loader.getController()).setStage(stage);
				

	            
	            
			} catch(Exception e) {
				Log4JUtils.getInstance().getLogger().error(e);
			}
		}
		
		
		@Override
		public void closeWindow() {
			if (stage != null)
				stage.close();
			
		}
		
		

	}
