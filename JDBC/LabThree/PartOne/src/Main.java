import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        FileInputStream fis = null;
        try {

            fis = new FileInputStream("F:\\iti\\Java\\JDBC\\Labs\\LabThree\\PartOne\\src\\configRowSet.properties");
            props.load(fis);


            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl(props.getProperty("MY_SQL_DB"));
            rowSet.setUsername(props.getProperty("USER"));
            rowSet.setPassword(props.getProperty("PASS"));


            rowSet.setCommand("select * from contact");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("Row Number : " + rowSet.getRow());

                System.out.println("id: " + rowSet.getInt("id") +" "+ "Name : " + rowSet.getString("name"));
            }
        }catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}