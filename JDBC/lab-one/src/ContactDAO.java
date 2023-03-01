import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDAO {

    private boolean conFlag;
    private Connection conn;


    //  Constructor To check if DB connected or not?
    public ContactDAO() {
        if(connect()){
            System.out.println("Connected");
        }else {
            System.out.println("DisConnected");
        }
    }


//  Open Connect
    private boolean connect() {
        String url = "jdbc:mysql://localhost:3306/addressbook";
        String username = "root";
        String password = "1234";
        conn = null;
        try {

//          Connect with mysql
            conn = DriverManager.getConnection(url, username, password);

            if(conn != null){
                conFlag = true;
                return true;
            }else {return false;}

        } catch ( SQLException e) {
            conFlag = false;
            System.out.println(e.getMessage());

        }
        return false;
    }


//  Close Connect
    public void closeConn(){
        if (conFlag){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


//  Create The Contact
    private ContactPerson createContactPerson(ResultSet rs){

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


// Create List of Contacts
    public List<ContactPerson> getContacts(){

        List<ContactPerson> list = new  ArrayList<ContactPerson>();
        ContactPerson person = new ContactPerson();

        if(conFlag) {
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
    public List<ContactPerson> getContactsForName(String name){
        List<ContactPerson> list = new ArrayList<ContactPerson>();
        ContactPerson person = new ContactPerson();


        if(conFlag){
            try {
                Statement stmt = conn.createStatement();

//                String queryString = new String("""
//                        select * from contact where name='?'
//                        """);

                String queryString = new String( "SELECT * FROM contact WHERE name like '" + name + "'" );

                ResultSet res = stmt.executeQuery(queryString);
                while (res.next()){
                    person = createContactPerson(res);
                    list.add(person);
                }
                stmt.close();
                res.close();
            }catch (Exception e){
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        if (list.isEmpty()){
            System.out.println("There is no Name match this input!");
        }

        return list;
    }


    // insert into DB
    public boolean insertContactPerson(ContactPerson cp){

        try {
            String queryString = new String("""
                                 INSERT INTO contact
                                 (name, nick_name, address, home_phone, work_phone, cell_phone, email, birthday, web_site, profession)
                                        VALUES (?,?,?,?,?, ?, ?,?,?,?);
                                        """);
            System.out.println(conn);
            PreparedStatement stmt = conn.prepareStatement(queryString);

            stmt.setString(1, cp.getName());
            stmt.setString(2, cp.getNickName());
            stmt.setString(3, cp.getAddress());
            stmt.setString(4, cp.getHomePhone());
            stmt.setString(5, cp.getWorkPhone());
            stmt.setString(6, cp.getCellPhone());
            stmt.setString(7, cp.getEmail());
            stmt.setDate(8, (Date) cp.getBirthDate());
            stmt.setString(9, cp.getWebsite());
            stmt.setString(10, cp.getProfession());

            int ch = stmt.executeUpdate();

            return ch != 0;

        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


//  Delete table
    public void deleteFromTable(String name){
        if (conFlag){
            try {
                Statement stmt = conn.createStatement();
                String queryString = new String( "delete FROM contact WHERE name like '" + name + "'" );
                int res = stmt.executeUpdate(queryString);

            } catch (SQLException e) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }


//  Update Table
    public void updateTable(int id, String name){

        if(conFlag){
            try {
                Statement stmt = conn.createStatement();
                String queryString = new String("UPDATE contact SET name = '"+name+"' WHERE id = '"+id+"'");
                stmt.executeUpdate(queryString);

            }catch (SQLException e){
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}

