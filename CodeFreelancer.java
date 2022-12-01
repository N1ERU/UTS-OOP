import java.util.ArrayList;

public class Code_Freelancer extends Code_User {    
    public ArrayList<Code_Project> ListProject = new ArrayList<Code_Project>();
    public Code_Freelancer(String name, String username, String password) {
        //refer to Code_User(String name, String username, String password)
        super(name, username, password);
    }

    public void add_project(ArrayList<Code_Project> project) {
        this.ListProject.addAll(project);
    }

    void show_takem_project(){
        if(ListProject.size() == 0) 
            System.out.println("You haven't take any project");
        else{
            for (int i = 0; i < ListProject.size(); i++) {
                System.out.println("\nList Project You've Taken " + i + 1);
                System.out.println("------------------------");
                System.out.println("Project Name\t\t: " + ListProject.get(i).getName());
                System.out.println("Project Description\t: " + ListProject.get(i).getProj_desc());
                System.out.println("Project Deadline\t: " + ListProject.get(i).getProj_deadline());
                System.out.println("Payment Method\t: " + ListProject.get(i).getPayment_Method());
                System.out.println("Project Fee\t: " + ListProject.get(i).getFee());
            } 
        }        
    }

    void view_project() {
        System.out.println(this.getName());
    }
}
