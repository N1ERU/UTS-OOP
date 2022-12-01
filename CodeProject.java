public class Code_Project {
    private String name;
    private String proj_desc;
    private String proj_deadline;
    private String projpay_method;
    private int fee;

    public Code_Project(String name, String description, String deadline, String payment_method, int fee) {
        this.name = name;
        this.proj_desc = description;
        this.proj_deadline = deadline;
        this.projpay_method = payment_method;
        this.fee = fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProj_desc(String description) {
        this.proj_desc = description;
    }

    public String getProj_desc() {
        return proj_desc;
    }

    public void setProj_deadline(String deadline) {
        this.proj_deadline = deadline;
    }

    public String getProj_deadline() {
        return proj_deadline;
    }

    public void setPayment_Method(String payment_method) {
        this.projpay_method = payment_method;
    }

    public String getPayment_Method() {
        return projpay_method;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    void viewdetailProject() {
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10d|", name, proj_desc, proj_deadline, projpay_method);
    }
}
