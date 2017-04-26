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
	

	public void setAdminGUIController(ICrashAdminGUIController adminGUIController){
		this.adminGUIController = adminGUIController;
	}
	
	public void bttnConfirm_OnClick(){
		adminGUIController.logonShowPanes(true);
		dialogStage.close();
	}
	
	public void bttnCancel_OnClick(){
		dialogStage.close();
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
