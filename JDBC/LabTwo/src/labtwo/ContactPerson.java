    
package labtwo;

import java.sql.Date;

public class ContactPerson {
    private int id;
    private String name;
    private String nickName;
    private String address;
    private String homePhone;
    private String workPhone;
    private String cellPhone;
    private String email;
    private Date birthDate;
    private String website;
    private String profession;

    public ContactPerson() {

    }

// Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }


//  Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNickName() {
        return nickName;
    }
    public String getAddress() {
        return address;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public String getCellPhone() {
        return cellPhone;
    }
    public String getEmail() {
        return email;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public String getWebsite() {
        return website;
    }
    public String getProfession() {
        return profession;
    }
}
