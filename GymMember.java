public abstract class GymMember {
    // Declaration of instance variables as attributes of the class.
    protected int id;
    protected String name;
    protected String gender;
    protected String location;
    protected String phone;
    protected String email;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    public GymMember(int id, String name, String gender, String location,
    String phone, String email, String DOB, String membershipStartDate) {
        // Getting the values from constructor and assigning it to the attributes.
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;

    }
    
    //Declaration of all the accessor methods.
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getDOB(){
        return this.DOB;
    }
    
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }
    
    public boolean getActiveStatus() {
        return this.activeStatus;
    }
    
    public double getLoyaltyPoints() {
        return this.loyaltyPoints;
    }
    
    public int getAttendance() {
        return this.attendance;
    }
    
    //abstract method to mark atttendance. Override will be used.
    public abstract void markAttendance();
    
    //method to activate membership
    public void activateMembership() {
        if(!this.activeStatus) {
            this.activeStatus = true;
        }
    }
    
    //method to deactivate membership
    public void deactivateMembership() {
        if(this.activeStatus) {
            this.activeStatus = false;
        }
    }
    
    //method to reset membership which resets attendance and loyalty points.
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
    }
    
    //method to display informations of the gymmember.
    public void display() {
        System.out.println("Personal information of gym-member:");
        System.out.println("Id: "+this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Gender: "+this.gender);
        System.out.println("Location: "+this.location);
        System.out.println("Phone Number: "+this.phone);
        System.out.println("Email Address: "+this.email);
        System.out.println("Date of Birth: "+this.DOB);
        System.out.println("Membership start date: "+this.membershipStartDate);
        System.out.println("Attendance: "+this.attendance);
        System.out.println("Accumulated Loyalty Points: "+this.loyaltyPoints);
        System.out.println("Active Status: "+this.activeStatus);
    }
}