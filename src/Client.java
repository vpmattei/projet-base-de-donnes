public class Client {
    private int ID;
    private String lastName, name;
    private String mail;
    private String password;
    private String postalAddress;

    public Client() {
        this.ID = -1;
    }

    public Client(int id, String name, String lastName, String mail, String password) {
        this.ID = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public Client(int id, String name, String lastName, String mail, String password, String postalAddress) {
        this.ID = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.postalAddress = postalAddress;
    }

    public int ID() {
        return ID;
    }

    public String lastName() {
        return lastName;
    }

    public String name() {
        return name;
    }

    public String mail() {
        return mail;
    }

    public String password() {
        return password;
    }

    public String postalAddress() {
        return postalAddress;
    }

    public void setID(int ID) {
        this.ID  = ID;
    }

    public void changeLastName(String newLastName) {
        lastName = newLastName;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changeMail(String newMail) {
        mail = newMail;
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }

    public void changePostalAdress(String newPostalAddress) {
        postalAddress = newPostalAddress;
    }
}
