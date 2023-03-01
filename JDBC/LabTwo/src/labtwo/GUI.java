package labtwo;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class GUI {

    private int id;
    ContactDAO c = new ContactDAO();
    ContactPerson p = new ContactPerson();

    GUI() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Contact View");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label emailLabe = new Label("Email:");
        grid.add(emailLabe, 0, 2);

        TextField EmailTXT = new TextField();
        grid.add(EmailTXT, 1, 2);

        Label phone = new Label("phone:");
        grid.add(phone, 0, 3);

        TextField phoneText = new TextField();
        grid.add(phoneText, 1, 3);

        Button lastBtn = new Button("Last");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(lastBtn);
        grid.add(hbBtn, 1, 4);

        Button nextBtn = new Button("Next");
        HBox nxBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(nextBtn);
        grid.add(nxBtn, 2, 4);

        Button preBtn = new Button("Previous");
        HBox prevBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(preBtn);
        grid.add(prevBtn, 3, 4);

        Button firstBtn = new Button("First");
        HBox firBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(firstBtn);
        grid.add(firBtn, 4, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        Scene sc = new Scene(grid);
        Stage st = new Stage();

//      First Element
        firstBtn.setOnAction(Action -> {
            userTextField.setText(c.getContacts().get(0).getName());
            EmailTXT.setText(c.getContacts().get(0).getEmail());
            phoneText.setText(c.getContacts().get(0).getCellPhone());
            id = c.getContacts().get(0).getId();
        });

//      Last Element   
        lastBtn.setOnAction(Action -> {
            userTextField.setText(c.getContacts().get(c.getContacts().size() - 1).getName());
            EmailTXT.setText(c.getContacts().get(c.getContacts().size() - 1).getEmail());
            phoneText.setText(c.getContacts().get(c.getContacts().size() - 1).getCellPhone());
            id = c.getContacts().get(c.getContacts().size() - 1).getId();
        });

//      next
        nextBtn.setOnAction(Action -> {

            // For loop for iterating over the List
            for (int i = 0; i < c.getContacts().size(); i++) {
                if (c.getContacts().get(i).getId() == id) {
                    if(i+1>=c.getContacts().size()){
                        i =-1;
                     }
                    id = c.getContacts().get(i+1).getId();
                    userTextField.setText(c.getContacts().get(i + 1).getName());
                    EmailTXT.setText(c.getContacts().get(i + 1).getEmail());
                    phoneText.setText(c.getContacts().get(i + 1).getCellPhone());
                    break;

                }
            }
            
        });

//      next
        preBtn.setOnAction(Action -> {

            // For loop for iterating over the List
            for (int i = 0; i < c.getContacts().size(); i++) {
                if (c.getContacts().get(i).getId() == id) {
                    if(i+1>=c.getContacts().size()){
                        i =0;
                     }
                    id = c.getContacts().get(i+1).getId();
                    userTextField.setText(c.getContacts().get(i + 1).getName());
                    EmailTXT.setText(c.getContacts().get(i + 1).getEmail());
                    phoneText.setText(c.getContacts().get(i + 1).getCellPhone());
                    break;

                }
            }
            
        });
        
        //      prev
        preBtn.setOnAction(Action -> {

            // For loop for iterating over the List
            for (int i = 0; i < c.getContacts().size(); i++) {
                if (c.getContacts().get(i).getId() == id) {
                    if(i==0){
                        i =c.getContacts().size();
                        
                     }
                    id = c.getContacts().get(i-1).getId();
                    userTextField.setText(c.getContacts().get(i - 1).getName());
                    EmailTXT.setText(c.getContacts().get(i - 1).getEmail());
                    phoneText.setText(c.getContacts().get(i - 1).getCellPhone());
                    break;

                }
            }
            
        });
        
        

        st.setScene(sc);
        st.setWidth(400);
        st.setHeight(450);
        st.show();

    }

}
