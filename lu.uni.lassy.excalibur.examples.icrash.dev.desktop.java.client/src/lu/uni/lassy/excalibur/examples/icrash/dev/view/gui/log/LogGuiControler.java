package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.log;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.NullValueException;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerNotBoundException;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerOfflineException;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActProxyCoordinator;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtLogEntry;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.LogEntry;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.HasTables;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.coordinator.ICrashCoordGUIController;

public class LogGuiControler extends AbstractGUIController implements HasTables {

	@FXML
	TableView<CtLogEntry> logtblvw;

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
	    System.out.println("Doing setup Tables ...");
	    setUpTables();
	    populateLogTable();



	}

	@Override
	public void setUpTables() {
		setupLogEntryTable(logtblvw);

		
	}


	public PtBoolean setActor2() {
        System.out.println("setActor2");
        userSideController.userController.getCoordImpl().listOfLogEntries.addListener((ListChangeListener<? super CtLogEntry>) c -> {
            System.out.println("Change detected adding to list");
            addLogEntryToTableView(logtblvw,c.getList());
        });

		return null;
	}

	public void populateLogTable(){
        try {
            System.out.println("Test"+userSideController.userController.getCoordImpl().listOfLogEntries.get(1).eId);
            addLogEntryToTableView(logtblvw,userSideController.userController.getCoordImpl().listOfLogEntries);
        } catch (NullPointerException e){
            Log4JUtils.getInstance().getLogger().error(e);
            showExceptionErrorMessage(new NullValueException(this.getClass()));
        }
    }

    @Override
    public PtBoolean setActor(JIntIsActor actor) {
        return null;
    }

    @Override
	public void closeForm() {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void bttn_refreshLog(){

	    userSideController.refreshLog();
	    populateLogTable();
        System.out.println("refresh on LogGuiControlelr");
	}


	public void setCoordGUIController(ICrashCoordGUIController iCrashCoordGUIController){
		this.userSideController = iCrashCoordGUIController;



	}



}
