package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.log;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.LogEntry;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.HasTables;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.coordinator.ICrashCoordGUIController;

public class LogGuiControler extends AbstractGUIController implements HasTables {

	@FXML
	TableView<LogEntry> logtblvw;

	@FXML
	TableColumn<LogEntry,Integer> idCol;

	@FXML
	TableColumn<LogEntry,String> typeCol;

	@FXML
	TableColumn<LogEntry,String> textCol;

	@FXML
	TableColumn<LogEntry,String> dateCol;


	ICrashCoordGUIController userSideController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

	@Override
	public void setUpTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PtBoolean setActor(JIntIsActor actor) {
//		if (actor instanceof ActCoordinator){
//			try {
//				userSideController = new CoordinatorController((ActCoordinator)actor);
//				userSideController.getCoordImpl().listOfLogEntries.addListener((ListChangeListener<LogEntry>) c -> addLogEntryToTableView(logtblvw,c.getList()));
//			} catch (RemoteException e) {
//				e.printStackTrace();
//			} catch (NotBoundException e) {
//				e.printStackTrace();
//			}
//		}
		return null;
	}

	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void bttn_refreshLog(){
		userSideController.refreshLog();
	}


	public void setCoordGUIController(ICrashCoordGUIController iCrashCoordGUIController){
		this.userSideController = iCrashCoordGUIController;
	}



}
