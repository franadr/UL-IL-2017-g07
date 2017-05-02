package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.sms;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.ICrashAdminGUIController;

public class CreateSMSGUI implements CreatedWindows {

		
		public CreateSMSGUI(ICrashAdminGUIController adminGUIController){
			start(adminGUIController);
		}
		/** The stage that will host the form. */
		private Stage stage;
		
		
		/**
		 * Generates and shows the window on the screen
		 */
		public void start(ICrashAdminGUIController adminGUIController){
			try {
				URL url = this.getClass().getResource("SmsGUI.fxml");
				FXMLLoader loader = new FXMLLoader(url);
				Parent root = (Parent)loader.load();
	            stage = new Stage();
	            stage.setTitle("SMS Authentication");
	            stage.setScene(new Scene(root));
	            stage.show();
//	            ((SmsGUIController)loader.getController()).setWindow(stage);
	            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						((SmsGUIController)loader.getController()).closeForm();
					}
				});
	            
	            ((SmsGUIController) loader.getController()).setAdminGUIController(adminGUIController);
				((SmsGUIController) loader.getController()).setStage(stage);
	            
	            
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
