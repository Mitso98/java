package notepad;

import java.io.File;
import java.io.FileWriter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class NotePadClass {

    NotePadClass() {
//      Menu Bar 
        MenuBar menubar = new MenuBar();

//      Menu elements 
        Menu file = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Mhelp = new Menu("Help");

//      Open Drop menu
        MenuItem undo = new MenuItem("Undo");
        MenuItem cut = new MenuItem("cut");
        MenuItem copy = new MenuItem("copy");
        MenuItem paste = new MenuItem("paste");
        MenuItem delete = new MenuItem("delete");
        MenuItem selectAll = new MenuItem("select All");

//      New Drop Menu
        MenuItem New = new MenuItem("New");
        MenuItem Save = new MenuItem("Save");
        MenuItem SaveAs = new MenuItem("Save as");
        MenuItem Exit = new MenuItem("Exit");
        
//      Help
        MenuItem helpinfo = new MenuItem("Help info");


//      DropDown menu add menu items
        file.getItems().addAll(New, Save, SaveAs, Exit);
        Edit.getItems().addAll(undo, cut, copy, paste, delete, selectAll);
        Mhelp.getItems().addAll(helpinfo);


//      Text Area
        TextArea textarea = new TextArea("This is some random very long text");
        textarea.setWrapText(true);
        textarea.setMaxWidth(600);
        textarea.setMaxHeight(500);

//      Menubar set elemnts 
        menubar.getMenus().addAll(file, Edit, Mhelp);

//      Create grid pane and set menubar in the pane
        GridPane gp = new GridPane();
        gp.add(menubar, 0, 0);
        gp.add(textarea, 0, 1);

//      Create group         
        Group gr = new Group();
        gr.getChildren().add(gp);

        //      Event Listner
//      Open
        New.setOnAction(Action -> {
            textarea.setText("");
        });

//      save file
        Save.setOnAction(Action -> {

            //        File Choicer
            FileChooser fileCho = new FileChooser();
            FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("tex files", "*.txt");
            File saveFile = fileCho.showSaveDialog(null);
            try {
                FileWriter fileWr = new FileWriter(saveFile);
                fileWr.write(textarea.getText());
                fileWr.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        });

        //   Save As file
        SaveAs.setOnAction(Action -> {

            //        File Choicer
            FileChooser fileCho = new FileChooser();
            FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("tex files", "*.txt");
            File saveFile = fileCho.showSaveDialog(null);
            try {
                FileWriter fileWr = new FileWriter(saveFile);
                fileWr.write(textarea.getText());
                fileWr.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        });
// ****************     Edit Drop menue Events        *********************

// Select all
        cut.setOnAction(Action -> {
            textarea.cut();
        });

//      cut 
        selectAll.setOnAction(Action -> {
            textarea.selectAll();
        });

//      cut 
        copy.setOnAction(Action -> {
            textarea.copy();
        });

//      undo 
        undo.setOnAction(Action -> {
            textarea.undo();
        });

//      paste 
        paste.setOnAction(Action -> {
            textarea.paste();
        });

//      Delete
        delete.setOnAction(Action -> {
            textarea.setText("");
        });

        // ****************     Help        *********************
        //      help
        helpinfo.setOnAction(Action -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Hello Mostafa Ahmed ");
            alert.setHeaderText(null);
            alert.setContentText("I am itian");
            alert.showAndWait();
        });

//      Create secene
        Scene sc = new Scene(gr);
        Stage st = new Stage();
        st.setScene(sc);
        st.setMaxWidth(600);
        st.setMaxHeight(500);
        st.setTitle("Mostafa's NotePad");
        st.show();

//      Exit Button
        Exit.setOnAction(Action -> {
            st.close();
        });

    }

}
