package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.sms;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerNotBoundException;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerOfflineException;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActProxyAuthenticated.UserType;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractAuthGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.HasTables;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.CreateICrashAdminGUI;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.admin.ICrashAdminGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.log.CreateLog;

public class SmsGUIController extends AbstractGUIController implements HasTables {


	private CreateICrashAdminGUI mainApp;
	private Stage stage;
	private AbstractAuthGUIController userGUIController;
	private Window window;
	private CreatedWindows createdLogWindow;
	
	@FXML Text warningMessage;
	@FXML TextField vCodeField;	
	
	
	public void setAdminGUIController(AbstractAuthGUIController userGUIController){
		this.userGUIController = userGUIController;
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
		try {
			if (userGUIController.getUserController().oeCancelLogin().getValue()){
				stage.close();
			}else{
				System.err.println("Something went wrong in oeCancelLogin");
			}
		}catch(ServerOfflineException | ServerNotBoundException e){
				showExceptionErrorMessage(e);
		}
	}	
	
	public void bttnConfirm_OnClick(){		
//		if(!vCodeField.getText().isEmpty()){									
			try {
				Screen screen = Screen.getPrimary();
				Rectangle2D bounds = screen.getVisualBounds();
				if (userGUIController.getUserController().oeLoginPhaseTwo(vCodeField.getText()).getValue()){
					userGUIController.logonShowPanes(true);
					if (userGUIController.getUserController().getUserType() == UserType.Coordinator){
						createdLogWindow = new CreateLog(bounds.getMaxX()/2,bounds.getMaxY()/2, userGUIController);
						userGUIController.setLogWindow(createdLogWindow);
					}
					stage.close();
				}else{
					warningMessage.setText("Wrong Code !!");
				}
			}catch(ServerOfflineException | ServerNotBoundException e){
					showExceptionErrorMessage(e);
			}
//		}
	}
		
		
	public void bttnCancel_OnClick(){
		closeForm();
	}

	

	
}
