package labtwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ContactDAO {

    private boolean conFlag;
    private Connection conn;

    //  Constructor To check if DB connected or not?
    public ContactDAO() {
        if (connect()) {
            System.out.println("Connected");
        } else {
            System.out.println("DisConnected");
        }
    }

//  Open Connect
    private boolean connect() {

        conn = null;
        try {

//          Connect with mysql
            conn = PropRead.getMySqlDataSource().getConnection();
            if (conn != null) {
                conFlag = true;
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            conFlag = false;
            System.out.println(e.getMessage());

        }
        return false;
    }

//  Close Connect
    public void closeConn() {
        if (conFlag) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

//  Create The Contact
    private ContactPerson createContactPerson(ResultSet rs) {

        try {
            ContactPerson p = new ContactPerson();

            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setNickName(rs.getString(3));
            p.setAddress(rs.getString(4));
            p.setHomePhone(rs.getString(5));
            p.setWorkPhone(rs.getString(6));
            p.setCellPhone(rs.getString(7));
            p.setEmail(rs.getString(8));
            p.setBirthDate(rs.getDate(9));
            p.setWebsite(rs.getString(10));
            p.setProfession(rs.getString(11));

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // insert into DB
    public boolean insertContactPerson(ContactPerson cp) {

        try {
            String queryString = "INSERT INTO contact (name , nick_name , address ,home_phone ,work_phone,cell_phone , email , birthday, web_site , profession) VALUES ('" + cp.getName() + "' , '" + cp.getNickName() + "' , '" + cp.getAddress() + "' , '" + cp.getHomePhone() + "',  '" + cp.getWorkPhone() + "' ,  '" + cp.getCellPhone() + "' ,  '" + cp.getEmail() + "', '" + cp.getBirthDate() + "' ,'" + cp.getWebsite() + "', '" + cp.getProfession() + "') ";
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(queryString);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Create List of Contacts
    public List<ContactPerson> getContacts() {

        List<ContactPerson> list = new ArrayList<ContactPerson>();
        ContactPerson person = new ContactPerson();

        if (conFlag) {
            try {

                Statement stmt = conn.createStatement();
                String queryString = new String("select * from contact");
                ResultSet rs = stmt.executeQuery(queryString);

                while (rs.next()) {
                    person = createContactPerson(rs);
                    list.add(person);
                }

                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

//  Get Contacts For Name
    public List<ContactPerson> getContactsForName(String name) {
        List<ContactPerson> list = new ArrayList<ContactPerson>();
        ContactPerson person = new ContactPerson();

        if (conFlag) {
            try {
                Statement stmt = conn.createStatement();

//                String queryString = new String("""
//                        select * from contact where name='?'
//                        """);
                String queryString = new String("SELECT * FROM contact WHERE name like '" + name + "'");

                ResultSet res = stmt.executeQuery(queryString);
                while (res.next()) {
                    person = createContactPerson(res);
                    list.add(person);
                }
                stmt.close();
                res.close();
            } catch (Exception e) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        if (list.isEmpty()) {
            System.out.println("There is no Name match this input!");
        }

        return list;
    }

//  Delete table
    public void deleteFromTable(String name) {
        if (conFlag) {
            try {
                Statement stmt = conn.createStatement();
                String queryString = new String("delete FROM contact WHERE name like '" + name + "'");
                int res = stmt.executeUpdate(queryString);

            } catch (SQLException e) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

//  Update Table
    public void updateTable(int id, String name) {

        if (conFlag) {
            try {
                Statement stmt = conn.createStatement();
                String queryString = new String("UPDATE contact SET name = '" + name + "' WHERE id = '" + id + "'");
                stmt.executeUpdate(queryString);

            } catch (SQLException e) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

//  Text Batch
    public void testBatch() {
        String sql1 = "UPDATE contact SET email = 'iti@gmail.com' WHERE name = 'Mostafa Ahmed' ";
        String sql2 = "UPDATE contact SET email = 'iti@gmail.com' WHERE name = 'Mohamed Amed' ";

        if (conFlag) {
            try {
                conn.setAutoCommit(false);
                Statement stmt = conn.createStatement();
                stmt.addBatch(sql1);
                stmt.addBatch(sql2);

                int[] executeBach = stmt.executeBatch();
                System.out.println(executeBach.length);
                conn.commit();

            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }


}
