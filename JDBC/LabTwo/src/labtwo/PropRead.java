
package labtwo;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.util.Properties;

public class PropRead {
    public static MysqlDataSource getMySqlDataSource(){
        Properties prop = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlIDS = new MysqlDataSource();
        try {
            fis = new FileInputStream("F:/iti/Java/JDBC/Labs/lab-one/src/config.properties");
            prop.load(fis);

            mysqlIDS.setURL(prop.getProperty("MYSQL_DB_URL"));
            mysqlIDS.setUser(prop.getProperty("USER"));
            mysqlIDS.setPassword(prop.getProperty("PASS"));

            if(mysqlIDS.getConnection() != null){
                System.out.println("Connection Done");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mysqlIDS;
    }
}

