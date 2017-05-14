package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.log;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActCoordinator;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.LogEntry;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.AbstractGUIController;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.HasTables;

public class LogGuiControler extends AbstractGUIController implements HasTables {

	@FXML
	TableView<LogEntry> logtblvw;

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
		if (actor instanceof ActCoordinator){

		}
		return null;
	}

	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		
	}

}
