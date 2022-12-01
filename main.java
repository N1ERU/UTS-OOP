import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    Scanner sc = new Scanner(System.in);
    Code_Admin admin1 = new Code_Admin("tigor", "nifel12", "relrel22");
    ArrayList<Code_Client> ClientList = new ArrayList<Code_Client>();
    ArrayList<Code_Freelancer> FreelancerList = new ArrayList<Code_Freelancer>();
    ArrayList<Code_Project> ProjectList = new ArrayList<Code_Project>();
    ArrayList<Code_Project> Project_TakenList = new ArrayList<Code_Project>();
    int project_num = 0;

    // mainmenu
    void mainmenu() {
        System.out.println("====== Welcome to Main Menu ======");
        System.out.println("====== Enter Your Identity ======");
        System.out.println("Press 0 to end program");
    }

    // delete client(admin only)
    void delete_client(Code_Admin admin) {
        System.out.println("====== Delete Client From Project ======");

        if (ClientList.size() == 0) 
            System.out.println("Client is unavailable");
        else {
            for (int i = 0; i < ClientList.size(); i++) {
                System.out.println((i+1) + " " + ClientList.get(i).getName());
            }

            System.out.print("Choose Client to Delete:");
                int delete_cl = sc.nextInt();
                ClientList.remove(delete_cl-1);
            System.out.println("Client has been deleted");
            System.out.print("Press Enter to continue\n");
            sc.nextLine();
        }
    }

    // delete freelancer(admin only)
    void delete_freelancer(Code_Admin admin) {
        System.out.println("====== Delete Freelancer From Project ======");

        if (FreelancerList.size() == 0)
            System.out.println("Freelancer is unavailable");
        else {
            for (int i = 0; i < FreelancerList.size(); i++) {
                System.out.println((i+1) + " " + FreelancerList.get(i).getName());
            }

            System.out.print("Choose Freelancer to Delete:");
                int delete_freelc = sc.nextInt();
                FreelancerList.remove(delete_freelc-1);
            System.out.println("Freelancer has been deleted");
            System.out.print("Press Enter to continue...\n");
            sc.nextLine();
        }
    }

    // delete projects(admin only)
    void delete_project(Code_Admin admin) {
        System.out.println("====== Delete Project From List ======");
        if (ProjectList.size() == 0)
            System.out.println("Project is unavailable");
        else {
            for (int i = 0; i < ProjectList.size(); i++) {
                System.out.println((i+1) + " " + ProjectList.get(i).getName());
            }
            System.out.print("Choose Project to Delete:");
                int delete_proj = sc.nextInt();
                ProjectList.remove(delete_proj-1);
                    project_num--;
            System.out.println("Project has been deleted");
            System.out.print("Press Enter to continue...\n");
            sc.nextLine();
        }
    }

    // admin main menu
    void admin_menu(Code_Admin admin) {
        int num_admin_menu;

        do {
            System.out.println("====== Welcome to Admin Server ======");
            System.out.println("1. Delete Client");
            System.out.println("2. Delete Freelancer");
            System.out.println("3. Delete Project");
            System.out.println("0. Back");
            System.out.print("Choose Menu: ");
            num_admin_menu = sc.nextInt();

            switch (num_admin_menu) {
                case 1: {
                    delete_client(admin);
                    break;
                }
                case 2: {
                    delete_freelancer(admin);
                    break;
                }
                case 3: {
                    delete_project(admin);
                    break;
                }
                case 0: {
                    break;
                }
            }
        } 
        while (num_admin_menu != 0);

    }

    //check deadline date validation(Untuk Client)
    int check_deadline(String deadline) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        //Deadline presentasinya adalah 2-3 bulan
        LocalDate min = localDate.plusDays(60); //Untuk 2 bulan
        LocalDate max = localDate.plusDays(90); //Untuk 3 bulan
        String deadline_min = min.format(formatter);
        String deadline_max = max.format(formatter);

        if(deadline.compareTo(deadline_min) > 0) {
            if (deadline.compareTo(deadline_max) < 0) {
                return 1;
            }
        }

        return -1;
    }

    // create project method (Untuk Client)
    void add_project(Code_Client client) {
        Scanner sc = new Scanner(System.in).useDelimiter("[\\n;]");
        String proj_name;
        String proj_descs;
        String proj_dl;
        String proj_payment_method;
        int proj_fees;
        int dl_valid = 0;

        System.out.println("====== Create/Add Project to be Post ======");

        System.out.print("Please insert your project name: ");
        proj_name = sc.next();
        System.out.print("Please insert your project description: ");
        proj_descs = sc.next();
        sc.nextLine();

        do {
            System.out.print("Please insert your project deadline [must be 2 or 3 months from today ('YYYY-MM-DD')]: ");
            proj_dl = sc.next();
            dl_valid = check_deadline(proj_dl);
        } 
        while (dl_valid != 1);

        System.out.print("Insert project payment method: ");
        proj_payment_method = sc.next();
        System.out.print("Insert project fee: ");
        proj_fees = sc.nextInt();
        
        Code_Project project = new Code_Project(proj_name, proj_descs, proj_dl, proj_payment_method,
                proj_fees);

        ProjectList.add(project);
        project_num++;

        System.out.println("\nThank You Your Project is Successfully Posted");
        System.out.print("Press Enter to continue...\n");
        sc.nextLine(); sc.nextLine();
    }

    //view project(untuk client)
    void views_project(Code_Client client) {
        if(ProjectList.size() == 0) 
            System.out.println("Project is Unavailable, Nothing Data to Show");
        else{
            System.out.println("====== List of Current Projects ======");
            
            for (int i = 0; i < ProjectList.size(); i++) {
                System.out.println("\n\nProject " + i + 1);
                System.out.println("Project Name\t\t: " + ProjectList.get(i).getName());
                System.out.println("Project Description\t: " + ProjectList.get(i).getProj_desc());
                System.out.println("Project Deadline\t: " + ProjectList.get(i).getProj_deadline());
                System.out.println("Payment Method\t: " + ProjectList.get(i).getPayment_Method());
                System.out.println("Project Fee\t: " + ProjectList.get(i).getFee());
            }
        }        
    }

    //client mainmenu
    void client_menu(Code_Client client) {
        int menu_client;

        do {
            System.out.println("====== Welcome to Client Menu  " + client.getName()+"  ======");
            System.out.println("1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("0. Back");
            System.out.print("Choose Menu: ");
            menu_client = sc.nextInt();

            switch (menu_client) {
                case 1: {
                    add_project(client);
                    break;
                }
                case 2: {
                    views_project(client);
                    break;
                }
                case 0: {
                    break;
                }
            }
        } 
        while (menu_client != 0);

    }

    //take project(Untuk Freelance)
    void get_project(Code_Freelancer freelancer){
        int proj_opt;
        System.out.println("====== Please Take Project You Want ======");
        
        for (int i = 0; i < ProjectList.size(); i++) {
            System.out.println("==    \nProject      ==" + i + 1);
            System.out.println("Project Name\t\t: " + ProjectList.get(i).getName());
            System.out.println("Project Description\t: " + ProjectList.get(i).getProj_desc());
            System.out.println("Project Deadline\t: " + ProjectList.get(i).getProj_deadline());
            System.out.println("Payment Method\t: " + ProjectList.get(i).getPayment_Method());
            System.out.println("Project Fee\t: " + ProjectList.get(i).getFee());
        }
        System.out.print("Choose Project: ");
        proj_opt = sc.nextInt();
        //If freelancer plih new project, -1 dari project list, +1 project taken list
        Project_TakenList.add(ProjectList.get(proj_opt-1));
        freelancer.add_project(Project_TakenList);
        ProjectList.remove(proj_opt-1);              
    }

    // vier project untuk freelancer
    void view_flproject(Code_Freelancer freelancer){
        System.out.println("==           My Project List          ==");
        freelancer.show_takem_project();      
    }

    // freelancer mainmenu
    void freelance_menu(Code_Freelancer freelancer) {
        int fl_option;

        do {
            System.out.println("====== Welcome to Freelancer Menu " + freelancer.getName()+" ======");
            System.out.println("1. Get Project");
            System.out.println("2. View MyProject");
            System.out.println("0. Back");
            System.out.print("Choose Menu: ");
            fl_option = sc.nextInt();

            switch (fl_option) {
                case 1: {
                    get_project(freelancer);
                    break;
                }
                case 2: {
                    view_flproject(freelancer);
                    break;
                }
                case 0: {
                    break;
                }
            }
        } 
        while (fl_option != 0);
    }

    // Mengecheck apakah Admin/Client/freelancer
    void check_userid(String user_username, String user_password) {
        int count = 0;
        if (user_username.equals(this.admin1.getUsername()) && user_password.equals(this.admin1.getPassword())) {
            count = 1;
            admin_menu(admin1);
        }
        if (ClientList.size() != 0) {
            for (int i = 0; i < ClientList.size(); i++) {
                if (user_username.equals(ClientList.get(i).getUsername()) && user_password.equals(ClientList.get(i).getPassword())) {
                    count = 1;
                    client_menu(ClientList.get(i));
                }
            }
        }
        if (FreelancerList.size() != 0) {
            for (int i = 0; i < FreelancerList.size(); i++) {
                if (user_username.equals(FreelancerList.get(i).getUsername()) && user_password.equals(FreelancerList.get(i).getPassword())) {
                    count = 1;
                    freelance_menu(FreelancerList.get(i));
                }
            }
        }

        if (count == 0) {
            System.out.println("Username & Password Unavailable");
        }
    }

    // main
    public main() {
        // Membuat list client
        Code_Client client1 = new Code_Client("Michael", "StarBeyond", "retard09");
        Code_Client client2 = new Code_Client("Jason", "oopsusah", "jsk123");
        Code_Client client3 = new Code_Client("Stephanie", "Joanna12", "Jadian87");
        Code_Client client4 = new Code_Client("Gisella", "Valencia76", "gsv76");
        ClientList.add(client1);
        ClientList.add(client2);
        ClientList.add(client3);
        ClientList.add(client4);
        Code_Freelancer freelancer1 = new Code_Freelancer("Arell", "KittenIsOdd", "bozok87");
        Code_Freelancer freelancer2 = new Code_Freelancer("Rey", "Simangunsong21", "Ferrari12");
        FreelancerList.add(freelancer1);
        FreelancerList.add(freelancer2);

        //Untuk Mengchech UserID
        String user_username;
        String user_password;

        do {
            mainmenu();
            System.out.print("Username: ");
            user_username = sc.next();   
            if(user_username.equals("0")) System.exit(0);         
                System.out.print("Password: ");
                user_password = sc.next();    
            if(user_password.equals("0")) System.exit(0);             
                check_userid(user_username, user_password);
        } 
        while (!user_username.equals("0") || !user_password.equals("0"));
    }
    public static void main(String[] args) {
        new main();
    }
}
