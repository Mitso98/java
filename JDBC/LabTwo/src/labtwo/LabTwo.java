package labtwo;

import java.sql.Date;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

public class LabTwo extends Application {

        @Override
        public void start(Stage primaryStage) {

                GUI gui = new GUI();

        }

        public static void main(String[] args) throws SQLException {
                Application.launch(args);

                ContactDAO c = new ContactDAO();

                ContactPerson p = new ContactPerson();

                System.out.println("================== Select All ===================");
                // select all
                c.getContacts().forEach((s) -> {
                        System.out.println(" Select all from DB :" + s.getName() + " " + s.getEmail());
                });

                // Excute Bach

                c.testBatch();

                // Row Set

                c.closeConn();

        }
}