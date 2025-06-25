public class RegularMember extends GymMember {
    //declaration of all attributes required for a regular member.
    private final int attendanceLimit = 30; 
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    public RegularMember(int id, String name, String gender, String location,
    String phone, String email, String DOB, String membershipStartDate, String referralSource) {
        //passing values for gymmember attributes through regularmember's constructor.
        super(id,name,gender,location,phone,email,DOB,membershipStartDate);
        //default values of a regular member
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
    }
    
    //declaration of all accessor methods of regularmember class
    public int getAttendanceLimit(){
        return this.attendanceLimit;
    }
    
    public boolean getisEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }
    
    public String getRemovalReason(){
        return this.removalReason;
    }
    
    public String getReferralSource(){
        return this.referralSource;
    }
    
    public String getPlan(){
        return this.plan;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    //method to update attendance and loyaltypoints
    @Override
    public void markAttendance() {
        super.attendance++;
        super.loyaltyPoints += 5;
    }
    
    //return plan price according to the plan
    public double getPlanPrice(String plan){
        switch(plan){
            case "Basic":
                return 6500;
            case "Standard":
                return 12500;
            case "Deluxe":
                return 18500;
            default:
                return -1;
        }
    }
    
    //method to upgrade plan if eligible.
    public String upgradePlan(String plan){
        if(this.getAttendance() >= this.attendanceLimit) {
            this.isEligibleForUpgrade = true;
        }
        if(isEligibleForUpgrade){
            if(this.plan == plan){
                return "You are already subscribed to this plan";
            }
            else{
                //getting plan price according to the plan.
                double planPrice = getPlanPrice(plan);
                //return error in case of wrong plan
                if(planPrice == -1){
                    return "Please select a valid plan";
                }
                //upgrading the plan, if there are no errors.
                else{
                    this.plan = plan;
                    this.price = getPlanPrice(plan);
                    return "Plan upgraded successfully";
                }
            }
        }
        else{
            //if isEligibleForUpgrade is false.
            return "You are not eligible to upgrade the plan."+
            "\nYour attendance: "+this.getAttendance()+"\nRequired Attendance: "+this.attendanceLimit;
        }
    }
    
    //method to reset a membership
    public void revertRegularMember(String removalReason){
            super.resetMember();
            isEligibleForUpgrade = false;
            plan = "Basic";
            price = 6500;
            this.removalReason = removalReason;
    }
    
    //method to display all informations including the informations from super class.
    public void display(){
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        
        if(removalReason != ""){
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}