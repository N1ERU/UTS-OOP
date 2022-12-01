public class Code_Client extends Code_User {
    public Code_Client(String name, String username, String password) {
        //refer to Code_User(String name, String username, String password)
        super(name, username, password);
    }

    void view_project() {
        System.out.println(this.getName());
    }
}
