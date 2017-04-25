package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.sms;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.CreateICrashAdminGUI;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.ICrashAdminGUIController;

public class SmsGUIController {


	private CreateICrashAdminGUI mainApp;
	private Stage dialogStage;
	private ICrashAdminGUIController adminGUIController;
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(CreateICrashAdminGUI mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setAdminGUIController(ICrashAdminGUIController adminGUIController){
		this.adminGUIController = adminGUIController;
	}
	
	public void handle(){
		adminGUIController.logonShowPanes(true);
	}

	
	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}	
	
	
}
