//importing necessary packages
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class GymMemberGUI implements ActionListener  {
    //declaring all attributes required for the GUI
    //JFrame and JPanel
    private JFrame frame,displayFrame;
    private JPanel panelCommon,panelRegular,upgradePanel,panelPremium,panelActivation,panelDisplay,panelRevert,duePanel,
    panelDisplayFromFile;
    //Arraylist to store objects of gym members
    private ArrayList<GymMember> userList = new ArrayList<>();
    //JLabelg
    private JLabel heading, id, name, gender,location,phone,email,dob,memStartDates,referralSource,
    removalReason,paidAmount,trainerName,plan,regularMember,premiumMember,discount,discountedAmount,
    idToActivate,idToMarkAttendance,idForRemoval,idForRemovalPremium,idToUpgradePlan,idForDiscountAndDue,dueAmount;
    //Text field for JLabel
    private JTextField idField,nameField,locationField,phoneField,emailField,dobField,referralSourceField,
    removalReasonField,paidAmountField,trainerNameField,regularMemberPrice,premiumMemberPrice,discountPercent,
    discountedAmountField,idToActivateField,idToMarkAttendanceField,idForRemovalField,idForRemovalPremiumField,
    idToUpgradePlanField,idForDiscountAndDueField,dueAmountField;
    //Radio Buttons for gender
    private JRadioButton male, female, others;
    //All required buttons for the GUI
    private JButton upgradePlan,addRegularMember,calculateDiscount,addPremiumMember,activateMembership,
    deactivateMembership,display,clear,saveToFile,markAttendanceRegular,markAttendancePremium,readFromFile,
    payDueAmount,resetRegularMember,resetPremiumMember;
    //Combobox to handle date
    private JComboBox<String> plans,dobDays,dobMths,dobYear,memStartDateDays,memStartDateMths,memStartDateYear;
    //text area to handle display
    private JTextArea displayTitle,displayArea,displayTitleFile,fileDisplayArea;
    //buttongroup to handle selection on radio button.
    private ButtonGroup genderButton;
    public GymMemberGUI() {
        //creating a frame for the gui
        frame = new JFrame("Gym Member GUI.");
        
        //panel for primary information of user
        panelCommon = new JPanel();
        panelCommon.setBounds(80,50,1300,180);
        panelCommon.setBorder(BorderFactory.createTitledBorder("Primary Informations for Registration."));        
        
        heading = new JLabel("User Interface.");
        heading.setBounds(600,20,200,30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(heading);
        
        //primary information of user like id, name, email and so on.
        id = new JLabel("ID:");
        id.setBounds(10,20,50,20);
        id.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(id);
        
        idField = new JTextField(20);
        idField.setBounds(70,20,200,20);
        panelCommon.add(idField);
        
        name = new JLabel("Name:");
        name.setBounds(10,50,50,20);  
        name.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(name);
        
        nameField = new JTextField(20);
        nameField.setBounds(70,50,200,20);
        panelCommon.add(nameField);
        
        gender = new JLabel("Gender:");
        gender.setBounds(10,80,60,20);
        gender.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(70,80,70,20);
        panelCommon.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(140,80,80,20);
        panelCommon.add(female);
        
        others = new JRadioButton("Others");
        others.setBounds(220,80,100,20);
        panelCommon.add(others);
        
        genderButton = new ButtonGroup();
        genderButton.add(male);
        genderButton.add(female);
        genderButton.add(others);
        
        location = new JLabel("Location:");
        location.setBounds(410,20,70,20);
        location.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(location);
        
        locationField = new JTextField(20);
        locationField.setBounds(500,20,200,20);
        panelCommon.add(locationField);
        
        phone = new JLabel("Phone:");
        phone.setBounds(410,50,70,20);
        phone.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(phone);
        
        phoneField = new JTextField(10);
        phoneField.setBounds(500,50,200,20);
        panelCommon.add(phoneField);
        
        email = new JLabel("Email:");
        email.setBounds(410,80,100,20);
        email.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(email);
        
        emailField = new JTextField(50);
        emailField.setBounds(500,80,200,20);
        panelCommon.add(emailField);
        
        dob = new JLabel("Date Of Birth:");
        dob.setBounds(850,20,100,20);
        dob.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(dob);
        
        //using loop to iterate and create an array of days, months and year for combobox.
        String[] days = new String[32];
        for(int i=1;i<=days.length;i++) {
            days[i-1] = ""+i;
        }
        String[] mths = new String[12];
        for(int i=1;i<=mths.length;i++) {
            mths[i-1] = String.valueOf(i);
        }
        String[] year = new String[56];
        int j=0;
        for(int i=1970;i<=2025;i++) {
            year[j] = String.valueOf(i);
            j++;
        }
        dobDays = new JComboBox<>(days);
        dobDays.setBounds(1050,20,70,20);
        panelCommon.add(dobDays);
        
        dobMths = new JComboBox<>(mths);
        dobMths.setBounds(1120,20,70,20);
        panelCommon.add(dobMths);
        
        dobYear = new JComboBox<>(year);
        dobYear.setBounds(1190,20,100,20);
        panelCommon.add(dobYear);
        
        memStartDates = new JLabel("Membership Start Date:");
        memStartDates.setBounds(850,50,170,20);
        memStartDates.setFont(new Font("Arial", Font.PLAIN,14));
        panelCommon.add(memStartDates);
        
        memStartDateDays = new JComboBox<>(days);
        memStartDateDays.setBounds(1050,50,70,20);
        panelCommon.add(memStartDateDays);
        
        memStartDateMths = new JComboBox<>(mths);
        memStartDateMths.setBounds(1120,50,70,20);
        panelCommon.add(memStartDateMths);
        
        memStartDateYear = new JComboBox<>(year);
        memStartDateYear.setBounds(1190,50,100,20);
        panelCommon.add(memStartDateYear);
        
        //clear button to clear entered data
        clear = new JButton("Clear all Fields");
        clear.setBounds(1000,85,200,20);
        clear.addActionListener(this);
        panelCommon.add(clear);
        
        //panel for registration of regular member
        panelRegular = new JPanel();
        panelRegular.setBounds(20,110,630,55);
        panelRegular.setBorder(BorderFactory.createTitledBorder("Registration for Regular Members.")); 
        panelCommon.add(panelRegular);
        
        referralSource = new JLabel("Referral Source:");
        referralSource.setBounds(10,20,150,20);
        referralSource.setFont(new Font("Arial", Font.PLAIN,14));
        panelRegular.add(referralSource);
        
        referralSourceField = new JTextField(20);
        referralSourceField.setBounds(170,20,200,20);
        panelRegular.add(referralSourceField);
        
        addRegularMember = new JButton("Add a regular Member");
        addRegularMember.setBounds(380,20,200,20);
        addRegularMember.addActionListener(this);
        panelRegular.add(addRegularMember);
        
        upgradePanel = new JPanel();
        upgradePanel.setBounds(80,250,650,140);
        upgradePanel.setBorder(BorderFactory.createTitledBorder("Upgrade a regular package.")); 
        
        idToUpgradePlan = new JLabel("Enter your ID:");
        idToUpgradePlan.setBounds(10,20,90,20);
        upgradePanel.add(idToUpgradePlan);
        
        idToUpgradePlanField = new JTextField();
        idToUpgradePlanField.setBounds(170,20,200,20);
        upgradePanel.add(idToUpgradePlanField);
        
        plan = new JLabel("Plan:");
        plan.setBounds(10,50,50,20);
        plan.setFont(new Font("Arial", Font.PLAIN, 14));
        upgradePanel.add(plan);
        
        String diffPlans[] = {"Basic", "Standard", "Deluxe"};
        plans = new JComboBox<>(diffPlans);
        plans.setBounds(170,50,200,20);
        plans.addActionListener(this);
        upgradePanel.add(plans);
        
        regularMember = new JLabel("Regular Member Price:");
        regularMember.setBounds(10,80,200,20);
        regularMember.setFont(new Font("Arial", Font.PLAIN,14));
        upgradePanel.add(regularMember);
        
        regularMemberPrice = new JTextField("6500");
        regularMemberPrice.setBounds(170,80,200,20);
        regularMemberPrice.setEditable(false);
        upgradePanel.add(regularMemberPrice);
        
        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(20,110,300,20);
        upgradePlan.addActionListener(this);
        upgradePanel.add(upgradePlan);
        
        //panel for registration of premium member
        panelPremium = new JPanel();
        panelPremium.setBounds(650,110,630,55);
        panelPremium.setBorder(BorderFactory.createTitledBorder("Registration for Premium Members."));
        panelCommon.add(panelPremium);
        
        trainerName = new JLabel("Trainer's Name:");
        trainerName.setBounds(10,20,200,20);
        trainerName.setFont(new Font("Arial", Font.PLAIN,14));
        panelPremium.add(trainerName);
        
        trainerNameField = new JTextField(20);
        trainerNameField.setBounds(170,20,200,20);
        panelPremium.add(trainerNameField);
        
        addPremiumMember = new JButton("Add a premium Member");
        addPremiumMember.setBounds(380,20,200,20);
        addPremiumMember.addActionListener(this);
        panelPremium.add(addPremiumMember);
        
        duePanel = new JPanel();
        duePanel.setBounds(730,250,650,140);
        duePanel.setBorder(BorderFactory.createTitledBorder("Pay due amounts of premium membership!"));
        
        premiumMember = new JLabel("Premium Price:");
        premiumMember.setBounds(10,20,100,20);
        premiumMember.setFont(new Font("Arial", Font.PLAIN,14));
        duePanel.add(premiumMember);
        
        premiumMemberPrice = new JTextField("50000");
        premiumMemberPrice.setBounds(170,20,200,20);
        premiumMemberPrice.setEditable(false);
        duePanel.add(premiumMemberPrice);
        
        discount = new JLabel("Discount:");
        discount.setBounds(380,20,60,20);
        discount.setFont(new Font("Arial", Font.PLAIN,14));
        duePanel.add(discount);
        
        discountPercent = new JTextField("10");
        discountPercent.setBounds(440,20,200,20);
        discountPercent.setEditable(false);
        duePanel.add(discountPercent);
        
        idForDiscountAndDue = new JLabel("Enter you id:");
        idForDiscountAndDue.setBounds(10,50,100,20);
        duePanel.add(idForDiscountAndDue);
        
        idForDiscountAndDueField = new JTextField();
        idForDiscountAndDueField.setBounds(170,50,200,20);
        duePanel.add(idForDiscountAndDueField);
        
        calculateDiscount = new JButton("Calculate Discount");
        calculateDiscount.setBounds(380, 110,200,20);
        calculateDiscount.addActionListener(this);
        duePanel.add(calculateDiscount);
        
        discountedAmount = new JLabel("Discounted Amount:");
        discountedAmount.setBounds(10,110,140,20);
        duePanel.add(discountedAmount);
        
        discountedAmountField = new JTextField();
        discountedAmountField.setBounds(170,110,200,20);
        discountedAmountField.setEditable(false);
        duePanel.add(discountedAmountField);
        
        dueAmount = new JLabel("Enter Due Amount:");
        dueAmount.setBounds(10,80,120,20);
        duePanel.add(dueAmount);
        
        dueAmountField = new JTextField();
        dueAmountField.setBounds(170,80,200,20);
        duePanel.add(dueAmountField);
        
        payDueAmount = new JButton("Pay Due Amount");
        payDueAmount.setBounds(380,80,200,20);
        payDueAmount.addActionListener(this);
        duePanel.add(payDueAmount);
        
        //panel to activate or deactivate membership and mark attendance according to the membership
        panelActivation = new JPanel();
        panelActivation.setBounds(80,410,650,150);
        panelActivation.setBorder(BorderFactory.createTitledBorder("Member Activities."));
        
        idToActivate = new JLabel("Enter your ID:");
        idToActivate.setBounds(10,20,150,20);
        idToActivate.setFont(new Font("Arial", Font.PLAIN,14));
        panelActivation.add(idToActivate);
        
        idToActivateField = new JTextField();
        idToActivateField.setBounds(170,20,200,20);
        panelActivation.add(idToActivateField);
        
        activateMembership = new JButton("Activate Membership");
        activateMembership.setBounds(10,50,300,20);
        activateMembership.addActionListener(this);
        panelActivation.add(activateMembership);
        
        deactivateMembership = new JButton("Deactivate Membership");
        deactivateMembership.setBounds(320,50,300,20);
        deactivateMembership.addActionListener(this);
        panelActivation.add(deactivateMembership);
        
        idToMarkAttendance = new JLabel("Enter your ID:");
        idToMarkAttendance.setBounds(10,80,150,20);
        idToMarkAttendance.setFont(new Font("Arial", Font.PLAIN,14));
        panelActivation.add(idToMarkAttendance);
        
        idToMarkAttendanceField = new JTextField();
        idToMarkAttendanceField.setBounds(170,80,200,20);
        panelActivation.add(idToMarkAttendanceField);
        
        markAttendanceRegular = new JButton("Mark Attendance as Regular Member");
        markAttendanceRegular.setBounds(10,110,300,20);
        markAttendanceRegular.addActionListener(this);
        panelActivation.add(markAttendanceRegular);
        
        markAttendancePremium = new JButton("Mark Attendance as Premium Member");
        markAttendancePremium.setBounds(320,110,300,20);
        markAttendancePremium.addActionListener(this);
        panelActivation.add(markAttendancePremium);
        
        panelRevert = new JPanel();
        panelRevert.setBounds(730,410,650,150);
        panelRevert.setBorder(BorderFactory.createTitledBorder("Reset Activities"));

        idForRemoval = new JLabel("Enter Id to reset Membership:");
        idForRemoval.setBounds(10,20,200,20);
        panelRevert.add(idForRemoval);
        
        idForRemovalField = new JTextField();
        idForRemovalField.setBounds(220,20,90,20);
        panelRevert.add(idForRemovalField);
        
        removalReason = new JLabel("Removal Reason:");
        removalReason.setBounds(320,20,120,20);
        removalReason.setFont(new Font("Arial", Font.PLAIN,14));
        panelRevert.add(removalReason);
        
        removalReasonField = new JTextField(20);
        removalReasonField.setBounds(450,20,190,20);
        panelRevert.add(removalReasonField);
        
        resetRegularMember = new JButton("Reset Membership as Regular Member");
        resetRegularMember.setBounds(100,50,400,20);
        resetRegularMember.addActionListener(this);
        panelRevert.add(resetRegularMember);
        
        idForRemovalPremium = new JLabel("Enter Id to reset Membership:");
        idForRemovalPremium.setBounds(10,80,200,20);
        panelRevert.add(idForRemovalPremium);
        
        idForRemovalPremiumField = new JTextField();
        idForRemovalPremiumField.setBounds(220,80,200,20);
        panelRevert.add(idForRemovalPremiumField);
        
        resetPremiumMember = new JButton("Reset Membership as Premium Member");
        resetPremiumMember.setBounds(100,110,400,20);
        resetPremiumMember.addActionListener(this);
        panelRevert.add(resetPremiumMember);
        
        //panel to display informations of regular or premium members
        panelDisplay = new JPanel();
        panelDisplay.setBounds(80,580,1300,250);
        panelDisplay.setBorder(BorderFactory.createTitledBorder("Preview information before saving to the file."));
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(1280, 200));
        scrollPane.setBounds(10,20,1280,200);
        panelDisplay.add(scrollPane);
        
        display = new JButton("Display");
        display.setBounds(50,220,300,20);
        display.addActionListener(this);
        panelDisplay.add(display);
        
        saveToFile = new JButton("Save to file");
        saveToFile.setBounds(500,220,300,20);
        saveToFile.addActionListener(this);
        panelDisplay.add(saveToFile);
        
        readFromFile = new JButton("Read from file and display");
        readFromFile.setBounds(900,220,300,20);
        readFromFile.addActionListener(this);
        panelDisplay.add(readFromFile);
        
        //setting layout null for all the panels
        panelActivation.setLayout(null);
        panelCommon.setLayout(null);
        panelRegular.setLayout(null);
        panelPremium.setLayout(null);
        upgradePanel.setLayout(null);
        duePanel.setLayout(null);
        panelDisplay.setLayout(null);
        panelRevert.setLayout(null);
        
        //adding all the panel to the frame
        frame.add(panelActivation);
        frame.add(upgradePanel);
        frame.add(panelCommon);
        frame.add(duePanel);
        frame.add(panelDisplay);
        frame.add(panelRevert);
        
        //default frame settings
        frame.setLayout(null);
        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //declaring and initializing variables to get informations from text field.
        int id;
        String name,phone,gender,email,location,referralSource,memStartDate,dobDate,trainersName,dobDay,
        dobMth,dobYears,memStartDay,memStartMth,memStartYear;
        
        //function to add a regular member 
        if(e.getSource() == addRegularMember){
            try {
                id = Integer.parseInt(idField.getText());
            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!isIdUnique(id) ) { 
                //if isIdUnique method returns false and the id is duplicate, then new object of premium 
                //member is not created and the process stops.
                JOptionPane.showMessageDialog(frame,"Id already exists","Duplicate Id",JOptionPane.ERROR_MESSAGE);
                return;
            }
            name = nameField.getText();
            phone = phoneField.getText();
            email = emailField.getText();
            location = locationField.getText();
            referralSource = referralSourceField.getText();
            trainersName = trainerNameField.getText();
            gender = "";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (others.isSelected()) {
                gender = "Others";
            }
            dobDay = String.valueOf(dobDays.getSelectedItem());
            dobMth = String.valueOf(dobMths.getSelectedItem());
            dobYears = String.valueOf(dobYear.getSelectedItem());
            memStartDay = String.valueOf(memStartDateDays.getSelectedItem());
            memStartMth = String.valueOf(memStartDateMths.getSelectedItem());
            memStartYear = String.valueOf(memStartDateYear.getSelectedItem());
                    
            dobDate = dobDay + "/" + dobMth + "/" + dobYears;
            memStartDate = memStartDay + "/" + memStartMth + "/" + memStartYear;
        
            // Check if any field is  empty
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your name.");
                return;
            }
            
            if(location.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your location.");
                return;
            }
            
            if(gender.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your gender.");
                return;
            }
            
            if(!isValidPhone(phone)){
                JOptionPane.showMessageDialog(frame, "Please provide a valid phone number.");
                return;
            }
            
            if(!isValidEmail(email)){
                JOptionPane.showMessageDialog(frame, "Please provide a valid email.");
                return;
            }
            if(referralSource.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please provide referral source.");
                return;
            }
            try {
                RegularMember regularUser = new RegularMember(id,name,gender,location,phone,email,
                dobDate,memStartDate,referralSource);
                userList.add(regularUser);
                JOptionPane.showMessageDialog(frame,"Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame,ex,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //function to add a premium member 
        if(e.getSource() == addPremiumMember){
            try {
                id = Integer.parseInt(idField.getText());
            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!isIdUnique(id)) { 
                //if isIdUnique method returns false and the id is duplicate, then new object of premium 
                //member is not created and the process stops.
                JOptionPane.showMessageDialog(frame,"Id already exists","Duplicate Id",JOptionPane.ERROR_MESSAGE);
                return;
            }
            name = nameField.getText();
            phone = phoneField.getText();
            email = emailField.getText();
            location = locationField.getText();
            referralSource = referralSourceField.getText();
            trainersName = trainerNameField.getText();
            gender = "";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (others.isSelected()) {
                gender = "Others";
            }
            dobDay = String.valueOf(dobDays.getSelectedItem());
            dobMth = String.valueOf(dobMths.getSelectedItem());
            dobYears = String.valueOf(dobYear.getSelectedItem());
            memStartDay = String.valueOf(memStartDateDays.getSelectedItem());
            memStartMth = String.valueOf(memStartDateMths.getSelectedItem());
            memStartYear = String.valueOf(memStartDateYear.getSelectedItem());
                    
            dobDate = dobDay + "/" + dobMth + "/" + dobYears;
            memStartDate = memStartDay + "/" + memStartMth + "/" + memStartYear;
            
            // Check if any field is empty
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your name.");
                return;
            }
            
            if(location.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your location.");
                return;
            }
            
            if(gender.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please provide your gender.");
                return;
            }
            
            if(!isValidPhone(phone)){
                JOptionPane.showMessageDialog(frame, "Please provide a valid phone number.");
                return;
            }
            
            if(!isValidEmail(email)){
                JOptionPane.showMessageDialog(frame, "Please provide a valid email.");
                return;
            }
            try {
                // Check if trainer name is empty
                if (trainersName.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please provide the trainer's name.");
                    return;
                }
                PremiumMember premiumUser = new PremiumMember(id,name,gender,location,phone,email,
                dobDate,memStartDate,trainersName);
                userList.add(premiumUser);
                JOptionPane.showMessageDialog(frame,"Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(frame,ex,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //To set price of regular member according to the plan.
        if(e.getSource() == plans) {
            if(plans.getSelectedItem() == "Basic"){
                regularMemberPrice.setText("Rs.6500");
            }
            else if(plans.getSelectedItem() == "Deluxe") {
                regularMemberPrice.setText("Rs.18500");
            }
            else if(plans.getSelectedItem() == "Standard") {
                regularMemberPrice.setText("Rs.12500");
            }
        }
        
        ////functionality to clear text field.
        if(e.getSource() == clear) {
            idField.setText("");
            nameField.setText("");
            genderButton.clearSelection();
            phoneField.setText("");
            emailField.setText("");
            locationField.setText("");
            dobDays.setSelectedIndex(0);
            dobMths.setSelectedIndex(0);
            dobYear.setSelectedIndex(0);
            memStartDateDays.setSelectedIndex(0);
            memStartDateMths.setSelectedIndex(0);
            memStartDateYear.setSelectedIndex(0);
            referralSourceField.setText("");
            trainerNameField.setText("");
            discountedAmountField.setText("");
            referralSourceField.setText("");
            trainerNameField.setText("");
            
        }
        
        //functionality to activate membership
        if(e.getSource() == activateMembership) {
            String idText = idToActivateField.getText();
            if(!idText.isEmpty()){
                try{
                    int idForActivation = Integer.parseInt(idText);
                    GymMember userToActivate = doesUserExists(idForActivation);
                    
                    if(userToActivate != null){
                        if(!userToActivate.getActiveStatus()) {
                            userToActivate.activateMembership();
                            JOptionPane.showMessageDialog(frame, "Activation Success. \n Active Status: "
                            +userToActivate.getActiveStatus());
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Membership already activated!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Member not found!","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(frame,"Please provide an id!");
            }
        }
        
        //functionality to deactivate membership
        if(e.getSource() == deactivateMembership) {
            String idText = idToActivateField.getText();
            if(!idText.isEmpty()){
                try {
                    int idForDectivation = Integer.parseInt(idText);
                    GymMember userToDeactivate = doesUserExists(idForDectivation);
                    
                    if(userToDeactivate != null){
                        if(userToDeactivate.getActiveStatus()) {
                        userToDeactivate.deactivateMembership();
                        JOptionPane.showMessageDialog(frame, "Deactivation Success.\nActive Status: "+userToDeactivate.getActiveStatus());
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Membership is already deactivated!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Member not found!","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id!");
            }
        }
        
        //functionality to mark attendance of a regular member
        if(e.getSource() == markAttendanceRegular){
            String idText = idToMarkAttendanceField.getText();
            if(!idText.isEmpty()){
                try {
                    int idForAttendance = Integer.parseInt(idText);
                    GymMember userToMarkAttendance = doesUserExists(idForAttendance);
                    
                    if(userToMarkAttendance != null) {
                        if(userToMarkAttendance instanceof RegularMember){
                            if(userToMarkAttendance.getActiveStatus()){
                                ((RegularMember) userToMarkAttendance).markAttendance();
                                String attendanceAndLoyaltyPoints = "Attendance: "+userToMarkAttendance.getAttendance()
                                +"\n"+"Loyalty Points: "+userToMarkAttendance.getLoyaltyPoints();
                                JOptionPane.showMessageDialog(frame,attendanceAndLoyaltyPoints);
                            }
                            else {
                                JOptionPane.showMessageDialog(frame,"Membership not activated","error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Not a Regular Member","Error",JOptionPane.ERROR_MESSAGE);
        
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame,"Member not found!.","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id!");
            }
        }
        
        //functionality to mark attendance of a premium member
        if(e.getSource() == markAttendancePremium){
            String idText = idToMarkAttendanceField.getText();
            if(!idText.isEmpty()){
                try{
                    int idForAttendance = Integer.parseInt(idText);
                    GymMember userToMarkAttendance = doesUserExists(idForAttendance);
        
                    if(userToMarkAttendance != null) {
                        if(userToMarkAttendance instanceof PremiumMember){
                            if(userToMarkAttendance.getActiveStatus()){
                                ((PremiumMember) userToMarkAttendance).markAttendance();
                                String attendanceAndLoyaltyPoints = "Attendance: "+userToMarkAttendance.getAttendance()
                                +"\n"+"Loyalty Points: "+userToMarkAttendance.getLoyaltyPoints();
                                JOptionPane.showMessageDialog(frame,attendanceAndLoyaltyPoints);
                            }
                            else {
                                JOptionPane.showMessageDialog(frame,"Membership not activated","error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Not a premium Member","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame,"Enter a valid id.","Invalid Id",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Nun-Numeric Id",JOptionPane.WARNING_MESSAGE);
                }
            }    
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id!");
            }
        }
        
        //functionality to reset a regular member
        if (e.getSource() == resetRegularMember) {
            String idText = idForRemovalField.getText();
            if(!idText.isEmpty()){
                try{    
                    int resetId = Integer.parseInt(idText);
                    String reason = removalReasonField.getText();
                    GymMember userToReset = doesUserExists(resetId);
        
                    if (userToReset instanceof RegularMember) {
                        if (!reason.isEmpty()) {
                            ((RegularMember) userToReset).revertRegularMember(reason);
                            JOptionPane.showMessageDialog(frame, "Revert Successful");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Removal Reason musn't be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Enter a valid Regular Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ep) {
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Nun-Numeric Id",JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id.");
            }
        }
        
        
        //functionality to reset a premium member
        if (e.getSource() == resetPremiumMember) {
            String idText = idForRemovalPremiumField.getText();
            if(!idText.isEmpty()){
                try{
                    int resetIdPremium = Integer.parseInt(idText);
                    GymMember userToReset = doesUserExists(resetIdPremium);
        
                    if (userToReset instanceof PremiumMember) {
                        ((PremiumMember) userToReset).revertPremiumMember();
                        JOptionPane.showMessageDialog(frame, "Revert Successful");
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Enter a valid Premium Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Not a valid Id","Nun-Numeric Id",JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id.");
            }
        }
        
        //functionality to display information of the gym members
        if(e.getSource() == display) {
            displayArea.setText("");
            if(!userList.isEmpty()) {
                for(GymMember info : userList) {
                    if (info instanceof RegularMember) {
                        RegularMember regular = (RegularMember) info;
                        displayArea.append(
                            "Member: Regular"+
                            "\nId: "+regular.getId() + 
                            "\nName: " + regular.getName() + 
                            "\nGender: " + regular.getGender() + 
                            "\nLocation: " +regular.getLocation() + 
                            "\nPhone: " + regular.getPhone() + 
                            "\nEmail: " + regular.getEmail() + 
                            "\nDate of Birth: " + regular.getDOB() + 
                            "\nMembership Start Date: " + regular.getMembershipStartDate() + 
                            "\nReferral Source: " +regular.getReferralSource() +
                            "\nPlan: " + regular.getPlan() +
                            "\nPrice: " + regular.getPrice() +
                            "\nActive Status: " +regular.getActiveStatus()+
                            "\nAttendance: " +regular.getAttendance()+
                            "\nLoyalty Points: "+regular.getLoyaltyPoints()+
                            "\n\n");
                    }
                    else if (info instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) info;
                        displayArea.append(
                            "Member: Premium"+
                            "\nMember Id: "+premium.getId() + 
                            "\nName: " + premium.getName() + 
                            "\nGender: " + premium.getGender() + 
                            "\nLocation: " +premium.getLocation() + 
                            "\nPhone: " + premium.getPhone() + 
                            "\nEmail: " + premium.getEmail() + 
                            "\nDate of Birth: " + premium.getDOB() + 
                            "\nMembership Start Date: " + premium.getMembershipStartDate() + 
                            "\nTrainer's Name: " +premium.getPersonalTrainer() +
                            "\nPrice: " + premium.getPremiumCharge() +
                            "\nPaid Amount: "+premium.getPaidAmount() +
                            "\nDiscount Amount: " + premium.getDiscountAmount() +
                            "\nActive Status: " +premium.getActiveStatus()+
                            "\nAttendance: " +premium.getAttendance()+
                            "\nLoyalty Points: "+premium.getLoyaltyPoints()+
                            "\n\n");
                    }
                }
            }else{
                  JOptionPane.showMessageDialog(frame,"No member to display.");  
            }
            displayArea.setCaretPosition(0);
        }
        
        if(e.getSource() == upgradePlan) {
            String idText = idToUpgradePlanField.getText();
            String newPlan = String.valueOf(plans.getSelectedItem());
            if(!idText.isEmpty()) {
                try {
                    int idToUpgrade = Integer.parseInt(idText);
                    GymMember memToUpgrade = doesUserExists(idToUpgrade);
                    
                    if(memToUpgrade != null) {
                        if(memToUpgrade instanceof RegularMember) {
                            RegularMember member = ((RegularMember) memToUpgrade);
                            String upgradePlanMessage = member.upgradePlan(newPlan);
                            String planDesc = "Plan: "+(member.getPlan()
                            +"\nPrice: "+(member.getPrice()));
                            JOptionPane.showMessageDialog(frame,upgradePlanMessage+"\n"+planDesc);
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Not a regular member","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame,"Member not found!","Error",JOptionPane.ERROR_MESSAGE); 
                    }
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"Please enter a valid id.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Please provide an id.");
            }
        }
        
        if(e.getSource() == payDueAmount) {
            String idText = idForDiscountAndDueField.getText();
            String dueText = dueAmountField.getText();
            if(!idText.isEmpty() && !dueText.isEmpty()) {
                try {
                    int idToUpgrade = Integer.parseInt(idText);
                    double amountDue = Double.parseDouble(dueText);
                    GymMember memToPayDue = doesUserExists(idToUpgrade);
                    if(memToPayDue != null){
                        if(memToPayDue instanceof PremiumMember) {
                            PremiumMember member = ((PremiumMember) memToPayDue);
                            if(member.getActiveStatus()){
                                String duePaid = member.payDueAmount(amountDue);
                                JOptionPane.showMessageDialog(frame,duePaid);
                            }
                            else{
                                JOptionPane.showMessageDialog(frame,"Member not active","Error",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Not a premium Member","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame,"Member not found!","Error",JOptionPane.ERROR_MESSAGE); 
                    }
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"Please enter a valid id.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(frame,"Please provide both id and due amount.");
            }
        }
        
        //functionality to add a calculate disount in case of a premium membership
        if(e.getSource() == calculateDiscount) {
            String idText = idForDiscountAndDueField.getText();
            if(!idText.isEmpty()) {
                try {
                    int idToUpgrade = Integer.parseInt(idText);
                    GymMember memToCalculateDiscount = doesUserExists(idToUpgrade);
                    if(memToCalculateDiscount != null){
                        if (memToCalculateDiscount instanceof PremiumMember){
                            PremiumMember member = ((PremiumMember) memToCalculateDiscount);
                            member.calculateDiscount();
                            String discountAmount = String.valueOf(member.getDiscountAmount());
                            discountedAmountField.setText(discountAmount);
                            JOptionPane.showMessageDialog(frame, "Discount amount: "+discountAmount);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Member not found!","Error",JOptionPane.ERROR_MESSAGE); 
                    }
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"Please enter a valid id.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(frame,"Please provide an id.");
            }
        }
        
        if(e.getSource() == saveToFile) {
            try{
                FileWriter writeToFile = new FileWriter("users.txt");
                if(!userList.isEmpty()) {
                    for(GymMember info : userList) {
                        if (info instanceof RegularMember) {
                            RegularMember regular = (RegularMember) info;
                            writeToFile.append(String.format(
                            "%-4s %-18s %-15s %-13s %-25s %-12s %-8s %-10s %-12s %-14s %-13s %-13s %-15s %-15s\n",
                            regular.getId(), regular.getName(), regular.getLocation(), regular.getPhone(), regular.getEmail(),
                            regular.getMembershipStartDate(), regular.getPlan(), regular.getPrice(), regular.getAttendance(),
                            regular.getLoyaltyPoints(), regular.getActiveStatus(), "N/A", "N/A", "N/A"));
                        }
                        else if (info instanceof PremiumMember) {
                            PremiumMember premium = (PremiumMember) info;
                            writeToFile.append(String.format(
                            "%-4s %-18s %-15s %-13s %-25s %-12s %-8s %-10s %-12s %-14s %-13s %-13s %-15s %-15s\n",
                            premium.getId(), premium.getName(), premium.getLocation(), premium.getPhone(), premium.getEmail(),
                            premium.getMembershipStartDate(), "N/A", "N/A", premium.getAttendance(),
                            premium.getLoyaltyPoints(), premium.getActiveStatus(), premium.getIsFullPayment(), 
                            premium.getDiscountAmount(), premium.getPaidAmount()));
                        }
                    }
                    JOptionPane.showMessageDialog(frame,"Your details are successfully saved!");
                }else {
                    JOptionPane.showMessageDialog(frame,"No member to save.");
                }
                writeToFile.close();
            }
            catch(IOException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
        }
        
        if(e.getSource() == readFromFile) {
            if(displayFrame == null || !displayFrame.isDisplayable()) {
                displayFrame = new JFrame();
                panelDisplayFromFile = new JPanel();
                panelDisplayFromFile.setBounds(10,10,1420,450);
                panelDisplayFromFile.setBorder(BorderFactory.createTitledBorder("Panel to display informations"));
                
                displayTitle = new JTextArea();
                displayTitle.setBounds(10,20,1400,20);
                displayTitle.setEditable(false);
                displayTitle.setFocusable(false);
                displayTitle.setFont(new Font("Monospaced", Font.PLAIN, 12));
                panelDisplayFromFile.add(displayTitle);
                displayTitle.append(String.format(
                "%-4s %-18s %-15s %-13s %-25s %-12s %-8s %-10s %-12s %-14s %-13s %-13s %-15s %-15s\n",
                "ID", "Name", "Location", "Phone", "Email","StartDate", "Plan", "Price", "Attendance",
                "LoyaltyPoints", "ActiveStatus", "FullPayment", "DiscountAmount", "NetAmountPaid"));
                
                fileDisplayArea = new JTextArea();
                fileDisplayArea.setEditable(false);
                fileDisplayArea.setFocusable(false);
                fileDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                JScrollPane scrollPane = new JScrollPane(fileDisplayArea);
                scrollPane.setPreferredSize(new Dimension(1400, 450));
                scrollPane.setBounds(10,40,1400,400);
                panelDisplayFromFile.add(scrollPane);
                
                panelDisplayFromFile.setLayout(null);
                
                displayFrame.add(panelDisplayFromFile);
                displayFrame.setSize(1500,500);
                displayFrame.setLayout(null);
                displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                displayFrame.setVisible(true);
            }
            else {
                displayFrame.toFront();
            }
            fileDisplayArea.setText("");
            try {
                BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    fileDisplayArea.setText(fileDisplayArea.getText() + line + "\n");
                }
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
            fileDisplayArea.setCaretPosition(0);
        }
    }
    
    //method to check if the id is unique
    public boolean isIdUnique(int id) {
        for(GymMember userId:userList) {
            if(id == userId.getId()){
                return false; //false because the entered id is duplicate
            }
        }
        return true; //the entered id is not duplicate
    }
    
    //function to check if the member exists in the arraylist
    public GymMember doesUserExists(int id) {
        GymMember checkedUser = null;
        for(GymMember user:userList) {
            if(id == user.getId()){
                checkedUser = user;
                break;
            }
        }
        return checkedUser;
    }
    
    // function to validate phone number
    public boolean isValidPhone(String phone) {
        if(phone.equals("") || phone.length()!=10) {
            return false;
        }
        for(char c: phone.toCharArray()){
         if(!Character.isDigit(c)){
             return false;
         }
        }
        return true;
    }
    
    // function to validate email
    public boolean isValidEmail(String email) {
        if(email.equals("") || !email.contains("@") || !email.contains(".")){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        new GymMemberGUI();
    }
}