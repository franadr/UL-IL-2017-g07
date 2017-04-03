package lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.log;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.view.gui.abstractgui.CreatedWindows;


public class CreateLog implements CreatedWindows {

	
	public CreateLog(double xPosition, double yPosition){
		start(xPosition, yPosition);
	}
	/** The stage that will host the form. */
	private Stage stage;
	
	
	/**
	 * Generates and shows the window on the screen
	 *
	 * @param xPosition the x position of where to put the window on the screen
	 * @param yPosition the y position of where to put the window on the screen
	 */
	public void start(double xPosition, double yPosition){
		try {
			URL url = this.getClass().getResource("LogGUI.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = (Parent)loader.load();
            stage = new Stage();
            stage.setTitle("Coordinator log");
            stage.setScene(new Scene(root));
            stage.setX(xPosition);
            stage.setY(yPosition);
            stage.show();
            ((LogGuiControler)loader.getController()).setWindow(stage);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					((LogGuiControler)loader.getController()).closeForm();
				}
			});
		} catch(Exception e) {
			Log4JUtils.getInstance().getLogger().error(e);
		}
	}
	
	
	@Override
	public void closeWindow() {
		
		
	}
	
	

}
