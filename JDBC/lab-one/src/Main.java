public class Main {
    public static void main(String[] args) {
        ContactDAO c = new ContactDAO();

        ContactPerson p = new ContactPerson();

        System.out.println("================== Select All ===================");
        //     select all
        c.getContacts().forEach((s)->{
            System.out.println(" Select all from DB :" +s.getName() +" "+s.getId());
        });


        System.out.println("================== Select Where name ===================");
        String name = new String("Mostafa Ahmed");
        c.getContactsForName(name).forEach(s->{
            System.out.println("Select From DB Where Name = Mostafa Ahmed : " + s.getName() + " " + s.getId());
        });



        System.out.println("=================== Delete From Table ==================");
        c.deleteFromTable("Ahmed");



        System.out.println("==================== Update Name Where id =================");
        c.updateTable(12,"hamda");


        System.out.println("================== Select All After Update ===================");
        //     select all
        c.getContacts().forEach((s)->{
            System.out.println(" Select all from DB :" +s.getName() +" "+s.getId());
        });


        c.closeConn();
    }
}