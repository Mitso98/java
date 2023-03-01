package notepad;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Notepad extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        NotePadClass npc = new NotePadClass();
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
