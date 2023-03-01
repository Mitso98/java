package lab1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author DELL
 */
public class Lab1 extends Application {
     StackPane rootpane;
    
        @Override
    public void init() throws Exception {
        super.init();
        
//      Reflection
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
       
//      Text Node 
        Text helloText = new Text("Hello World!");
        helloText.setId("text");
        
//      Rectangle Node
        Rectangle rect = new Rectangle(0, 0, 400, 300);
        rect.setId("rect");
        
//        Start The refliction effect
        helloText.setEffect(reflection);
        rootpane = new StackPane();
        rootpane.getChildren().add(rect);
        rootpane.getChildren().add(helloText);

  
    }
    
    @Override
    public void start(Stage primaryStage) {
            

        Scene scene = new Scene(rootpane, 400, 300);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
