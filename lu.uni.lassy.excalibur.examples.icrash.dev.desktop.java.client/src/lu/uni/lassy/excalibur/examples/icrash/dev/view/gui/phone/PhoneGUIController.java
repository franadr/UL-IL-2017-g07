package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.phone;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.HasTables;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.ICrashAdminGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.sms.CreateSMSGUI;

public class PhoneGUIController extends AbstractGUIController implements HasTables {

	private Stage stage;
	private ICrashAdminGUIController adminGUIController;
	private Window window;
	private CreatedWindows createdSMSWindow;
		
	@FXML Text warningMessage;
	@FXML TextField phoneField;
	
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
	
	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		phoneField.setText("Whatever");
		
	}

	@Override
	public void setUpTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PtBoolean setActor(JIntIsActor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		adminGUIController.logoff();
	}	
	
	public void bttnConfirm_OnClick(){
		if(phoneField.getText().isEmpty()){									//Condition adapted for convenience
			warningMessage.setText("Phone Number Field is empty!!");
		}else{
		createdSMSWindow = new CreateSMSGUI(adminGUIController, 150, 150);
		stage.close();
		}
	}
	
	public void bttnCancel_OnClick(){
		closeForm();
		stage.close();
	}

	

	
}
