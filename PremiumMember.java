public class PremiumMember extends GymMember
{
    //declaration of all attributes required for a premium member.
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    public PremiumMember(int id, String name, String gender, String location,
    String phone, String email, String DOB, String membershipStartDate, String personalTrainer) {
        //initialize premiumMember's and super's attributes according to parameters
        super(id,name, gender,location, phone,email,DOB,membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        
    }
    
    //Accessor methods
    public double getPremiumCharge(){
        return premiumCharge;
    }
    
    public String getPersonalTrainer(){
        return personalTrainer;
    }
    
    public boolean getIsFullPayment(){
        return isFullPayment;
    }
    
    public double getPaidAmount(){
        return paidAmount;
    }
    
    public double getDiscountAmount(){
        return discountAmount;
    }
    
    //method to mark attendance and add loyalty points
    @Override
    public void markAttendance() {
        if(super.activeStatus) {
            super.attendance++;
            super.loyaltyPoints += 10; 
        }
    }
    
    //method to pay due amount
    public String payDueAmount(double paidAmount){
        if(this.isFullPayment){
            return "Full amount is already paid";
        }
        
        if(this.paidAmount>=this.premiumCharge){
            this.isFullPayment = true;
            return "Full amount is already paid";
        }
        if(this.paidAmount + paidAmount > this.premiumCharge){
            double remaining = premiumCharge - this.paidAmount;
            return "You have Rs." + remaining + " to be paid. Please pay the same or less amount.";
        }
        this.paidAmount += paidAmount;
        
        if(this.paidAmount == this.premiumCharge){
            isFullPayment = true;
        }
        
        return "Successfully paid Rs." + paidAmount + ". Remaining amount: " + (this.premiumCharge - this.paidAmount);
    }
    
    //method to calculate discount if available
    public void calculateDiscount(){
        double discount = 0;
        if(this.isFullPayment){
            discount = (10.0/100) * this.premiumCharge;
        }
        
        this.discountAmount = discount;
    }
    
    //method to reset membership
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    
    //method to display all informations including the information from super class.
    public void display(){
        super.display();
        System.out.println("Personal Trainer: "+this.personalTrainer);
        System.out.println("Paid Amount: "+this.paidAmount);
        System.out.println("Is Full Payment: "+this.isFullPayment);
        System.out.println("Remaining amount to be paid: "+ (this.premiumCharge - this.paidAmount));
        
        if(isFullPayment){
            System.out.println("Discount Amount: "+this.discountAmount);
        }
    }
}
