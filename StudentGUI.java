
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class StudentGUI
{
    private JFrame StudentGUI;
    private JPanel panel1, panel2, panel3;
    private JButton selectRegularbtn1,dropoutbtn2,btnBack1, btnBack2,btnBack3,  btnAdd1, btnAdd2,btnGrant,btnPayBills;
    private JButton btnDispaly1,btnDispaly2, btnClear1, btnClear2, btnRemove;
    private JLabel label,lbldateOfBirth,lblcourseName,lblstudentName,lbldateOfEnrollement,lblenrollmentID,lblcourseDuration,lbltutionFee,lblnumOfModules,lblnumOfCreditHours,lbldaysPresent;
    private JTextField  txtcourseName,txtstudentName,txtenrollmentId,txtcourseDuration,txttutionFee,txtnumOfModules,txtnumOfCreditHours,txtdaysPresent;
    private JLabel header,dateOfBirth,courseName,studentName,dateOfEnrollement,enrollmentID,courseDuration,tuitionFee,numOfRemainingModules,numOfMonthsAttended,dateofDropout,remainingAmount,hasPaid;
    private JTextField  lxtcourseName,lxtstudentName,lxtenrollmentId,lxtcourseDuration,lxttutionFee,txtnumOfRemainingModules,txtnumOfMonthsAttended,txtremainingAmount;
    private JComboBox<String> dayOfBirthComboBox, monthOfBirthComboBox, yearOfBirthComboBox, dayOfEnrollmentComboBox, monthOfEnrollmentComboBox, yearOfEnrollmentComboBox, dayOfDropoutComboBox, monthOfDropoutComboBox, yearOfDropoutComboBox,ddaydateOfBirth,dmonthdateOfBirth,dyeardateOfBirth,ddayDateOfEnrollement,dmonthDateOfEnrollement,dyearDateOfEnrollement;

    private ArrayList <Student> students = new ArrayList<Student>();
    public StudentGUI()
    {
        initialFrame();
        myFrameA();
    }
    // Regular declare
    public int getEnrollmentID()
    {
        String EnrollmentID = txtenrollmentId.getText();
        int enrollmentID = -1;
        try
        {
            enrollmentID = Integer.parseInt(EnrollmentID);

        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to entered in enrollmentID!!! ","Invalid Input",0);   

        }
        return enrollmentID;

    }

    public String getDateOfBirth() {
        int year = Integer.parseInt(yearOfBirthComboBox.getSelectedItem().toString());
        int monthIndex = monthOfBirthComboBox.getSelectedIndex() + 1; 
        int day = Integer.parseInt(dayOfBirthComboBox.getSelectedItem().toString());

        String formattedDateOfBirth = day + "_" + monthIndex + "_" + year;
        return formattedDateOfBirth;
    }

    public String getStudentName()
    {
        return txtstudentName.getText();

    }

    public String getCourseName(){
        return txtcourseName.getText();
    }

    public String getDateOfEnrollement() {
        int year = Integer.parseInt(yearOfEnrollmentComboBox.getSelectedItem().toString());
        int monthIndex = monthOfEnrollmentComboBox.getSelectedIndex() + 1; // Adding 1 since months are 0-indexed
        int day = Integer.parseInt(dayOfEnrollmentComboBox.getSelectedItem().toString());

        String formattedDateOfEnrollment = day + "_" + monthIndex + "_" + year;
        return formattedDateOfEnrollment;
    }

    public int getCourseDuration(){
        String courseDuration = txtcourseDuration.getText();
        int CourseDurations = -1;
        try{
            CourseDurations = Integer.parseInt(courseDuration);

        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to entered in courseDuration!!!","Invalid Input",0);   

        }
        return CourseDurations;

    }

    public int getTuitionFee(){
        String tuitionFee = txttutionFee.getText();
        int TuitionFee = -1;
        try{
            TuitionFee = Integer.parseInt(tuitionFee);

        }
        catch(NumberFormatException nfe )
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to entered in tutionFee !!!","Invalid Input",0);
        }
        return TuitionFee;
    }

    public int getNumOfModules(){
        String numofModules = txtnumOfModules.getText();
        int numOfmodules = -1;
        try{
            numOfmodules = Integer.parseInt(numofModules);
        }
        catch(NumberFormatException nfe )
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to enteredinnumofModules!!!","Invalid Input",0);
        }
        return numOfmodules;

    }

    public int getNumOfCreditHours(){
        String numofCreditHours = txtnumOfCreditHours.getText();
        int numOfCreditHours = -1;
        try{
            numOfCreditHours = Integer.parseInt(numofCreditHours);
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to entered in numofCreditHours!!!","Invalid Input",0);
        }
        return numOfCreditHours;
    }

    public double getDaysPresent(){
        String daysPresent = txtdaysPresent.getText();
        double dayspresent = -1;
        try{
            dayspresent = Double.parseDouble(daysPresent);

        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(StudentGUI,"Only numeric values are allowed to entered in DaysPresent!!!","Invalid Input",0);
        }
        return dayspresent;

    }
    //Dropout declare
    public int getDropoutEnrollmentID() {
        String enrollmentID = lxtenrollmentId.getText();
        int dropoutEnrollmentID = -1;
        try {
            dropoutEnrollmentID = Integer.parseInt(enrollmentID);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered in enrollmentID!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutEnrollmentID;
    }

    public String getDropoutDateOfBirth() {
        int year = Integer.parseInt(dyeardateOfBirth.getSelectedItem().toString());
        int monthIndex = dmonthdateOfBirth.getSelectedIndex() + 1; 
        int day = Integer.parseInt(ddaydateOfBirth.getSelectedItem().toString());

        String formattedDateOfBirth = day + "_" + monthIndex + "_" + year;
        return formattedDateOfBirth;
    }

    public String getDropoutStudentName() {
        return lxtstudentName.getText();
    }

    public String getDropoutCourseName() {
        return lxtcourseName.getText();
    }

    public String getDropoutDateOfEnrollment() {
        int year = Integer.parseInt(dyearDateOfEnrollement.getSelectedItem().toString());
        int monthIndex = dmonthDateOfEnrollement.getSelectedIndex() + 1;
        int day = Integer.parseInt(ddayDateOfEnrollement.getSelectedItem().toString());

        String formattedDateOfEnrollment = day + "_" + monthIndex + "_" + year;
        return formattedDateOfEnrollment;
    }

    public int getDropoutCourseDuration() {
        String courseDuration = lxtcourseDuration.getText();
        int dropoutCourseDuration = -1;
        try {
            dropoutCourseDuration = Integer.parseInt(courseDuration);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered in courseDuration!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutCourseDuration;
    }

    public int getDropoutTuitionFee() {
        String tuitionFee = lxttutionFee.getText();
        int dropoutTuitionFee = -1;
        try {
            dropoutTuitionFee = Integer.parseInt(tuitionFee);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered tutionFee!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutTuitionFee;
    }

    public int getDropoutNumOfRemainingModules() {
        String numOfRemainingModules = txtnumOfRemainingModules.getText();
        int dropoutNumOfRemainingModules = -1;
        try {
            dropoutNumOfRemainingModules = Integer.parseInt(numOfRemainingModules);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered in numofRemainingModules!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutNumOfRemainingModules;
    }

    public int getDropoutNumOfMonthsAttended() {
        String numOfMonthsAttended = txtnumOfMonthsAttended.getText();
        int dropoutNumOfMonthsAttended = -1;
        try {
            dropoutNumOfMonthsAttended = Integer.parseInt(numOfMonthsAttended);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered in numOfMonthsAttended!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutNumOfMonthsAttended;
    }

    public int getDropoutRemainingAmount() {
        String remainingAmount = txtremainingAmount.getText();
        int dropoutRemainingAmount = -1;
        try {
            dropoutRemainingAmount = Integer.parseInt(remainingAmount);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(StudentGUI, "Only numeric values are allowed to be entered in Remainingamount!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return dropoutRemainingAmount;
    }

    public String getDropoutDateOfDropout() {
        int year = Integer.parseInt(yearOfDropoutComboBox.getSelectedItem().toString());
        int month = monthOfDropoutComboBox.getSelectedIndex()+ 1; // Replace with the actual array of month names
        int day = Integer.parseInt(dayOfDropoutComboBox.getSelectedItem().toString()); // Assuming you have a similar JComboBox for days

        String formattedDateOfDropout = year + "_" + month + "_" + day;
        return formattedDateOfDropout;
    }

    public boolean getHasPaid() {
        String hasPaidText = hasPaid.getText();
        return Boolean.parseBoolean(hasPaidText);
    }

    public void initialFrame()
    {
        StudentGUI = new JFrame("StudentGUI");
        StudentGUI.setSize(450,300);
        StudentGUI.setLayout(null);
        StudentGUI.setResizable(false);
        StudentGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        StudentGUI.add(panel1);
        panel1.setBounds(0,0,450,300);
        panel1.setLayout(null);
        panel1.setBackground(Color.white); 

        panel2 = new JPanel();
        StudentGUI.add(panel2);
        panel2.setBounds(0,0,1100,800);
        panel2.setLayout(null);
        panel2.setVisible(false);
        panel2.setBackground(Color.white);

        panel3 = new JPanel();
        StudentGUI.add(panel3);
        panel3.setBounds(0,0,1100,800);
        panel3.setLayout(null);
        panel3.setVisible(false);
        panel3.setBackground(Color.white);

    }

    public void myFrameA()
    {

        header= new JLabel("Welcome to IslingtonCollege Student Registration.");
        header.setBounds(60,10,500,35);
        header.setFont(new Font("Serif", Font.PLAIN, 18 ));
        header.setBackground(Color.DARK_GRAY);
        panel1.add(header);
        //regular
        selectRegularbtn1 = new JButton("Regular");
        panel1.add(selectRegularbtn1);
        selectRegularbtn1.setBounds(140,75,175,25);
        selectRegularbtn1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    panel1.setVisible(false);
                    StudentGUI.setSize(1100,800);
                    panel2.setVisible(true);
                }

            });

        label = new JLabel("Regular Registration Form");
        label.setBounds(325,34,464,30);
        label.setFont(new Font("Arial",Font.PLAIN,30));
        panel2.add(label);

        lblstudentName = new JLabel("StudentName:");
        lblstudentName.setBounds(68,77,107,43);
        panel2.add(lblstudentName);

        lblcourseName = new JLabel("CourseName:");
        lblcourseName.setBounds(667,77,107,43);
        panel2.add(lblcourseName);

        lbldateOfBirth = new JLabel("DateOfBirth:");
        lbldateOfBirth.setBounds(68,167,107,43);
        panel2.add(lbldateOfBirth);

        lbldateOfEnrollement =new JLabel ("DateOFEnrollement");
        lbldateOfEnrollement.setBounds(667,167,116,43);
        panel2.add(lbldateOfEnrollement);

        lblenrollmentID = new JLabel("EnrollmentID:");
        lblenrollmentID.setBounds(68,262,107,43);
        panel2.add(lblenrollmentID);

        lblnumOfModules = new JLabel ("NumOfModules:");
        lblnumOfModules.setBounds(667,267,116,43);
        panel2.add(lblnumOfModules);

        lblcourseDuration = new JLabel("CourseDuration:");
        lblcourseDuration.setBounds(68,357,107,43);
        panel2.add(lblcourseDuration);

        lbltutionFee = new JLabel ("TuitionFee:");
        lbltutionFee.setBounds(667,357,116,43);
        panel2.add(lbltutionFee);

        lblnumOfCreditHours = new JLabel("NumOfCreditHours:");
        lblnumOfCreditHours.setBounds(68,452,125,43);
        panel2.add(lblnumOfCreditHours);

        lbldaysPresent = new JLabel("DaysPresent:");
        lbldaysPresent.setBounds(667,447,116,43);
        panel2.add(lbldaysPresent);

        txtstudentName = new JTextField();
        txtstudentName.setBounds(192,79,234,32);
        panel2.add(txtstudentName);

        txtcourseName = new JTextField();
        txtcourseName.setBounds(796,77,234,32);
        panel2.add(txtcourseName);

        String Days[]={"1","2","3","4","5","6","7","8","9","10"};
        dayOfBirthComboBox = new JComboBox(Days);
        dayOfBirthComboBox.setBounds(193,173,67,32);
        panel2.add(dayOfBirthComboBox);

        String Months[] = {"january","February","March","April","May","June","July","August","September","October","November","December"};
        monthOfBirthComboBox = new JComboBox(Months);
        monthOfBirthComboBox.setBounds(276,173,66,32);
        panel2.add(monthOfBirthComboBox);

        String Year[] = {"2020","2021","2022","2023","2024"};
        yearOfBirthComboBox = new JComboBox(Year);
        yearOfBirthComboBox.setBounds(353,173,74,32);
        panel2.add(yearOfBirthComboBox);

        String Day[]={"1","2","3","4","5","6","7","8","9","10"};
        dayOfEnrollmentComboBox = new JComboBox(Day);
        dayOfEnrollmentComboBox.setBounds(796,167,67,32);
        panel2.add( dayOfEnrollmentComboBox);

        String Month[] = {"january","February","March","April","May","June","July","August","September","October","November","December"};
        monthOfEnrollmentComboBox = new JComboBox(Month);
        monthOfEnrollmentComboBox.setBounds(879,167,66,32);
        panel2.add( monthOfEnrollmentComboBox);

        String Years[] = {"2001","2005","2010","2015","2020"};
        yearOfEnrollmentComboBox = new JComboBox(Years);
        yearOfEnrollmentComboBox.setBounds(956,167,74,32);
        panel2.add( yearOfEnrollmentComboBox);

        txtenrollmentId = new JTextField();
        txtenrollmentId.setBounds(193,267,234,32);
        panel2.add(txtenrollmentId);

        txtnumOfModules = new JTextField();
        txtnumOfModules.setBounds(795,267,234,32);
        panel2.add(txtnumOfModules);

        txtcourseDuration = new JTextField();
        txtcourseDuration.setBounds(193,357,234,32);
        panel2.add(txtcourseDuration);

        txttutionFee = new JTextField();
        txttutionFee.setBounds(795,357,234,32);
        panel2.add(txttutionFee);

        txtnumOfCreditHours = new JTextField();
        txtnumOfCreditHours.setBounds(193,452,234,32);
        panel2.add(txtnumOfCreditHours);

        txtdaysPresent = new JTextField();
        txtdaysPresent.setBounds(795,447,234,32);
        panel2.add(txtdaysPresent);

        btnBack1 = new JButton("Back");
        panel2.add(btnBack1);
        btnBack1.setBounds(909,617,120,32);
        btnBack1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    panel1.setVisible(true);
                    StudentGUI.setSize(450,300);
                    panel2.setVisible(false);
                }
            });

        btnAdd1 = new JButton("Add");
        panel2.add(btnAdd1);
        btnAdd1.setBounds(754,617,120,32);
        btnAdd1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    addRegular();

                }
            });
        btnBack3 = new JButton("Book");
        panel2.add(btnBack3);
        btnBack3.setBounds(599,617,120,32);
        btnBack3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    calculateRegularPresentage();
                }
            });

        btnClear1 = new JButton("Clear");
        panel2.add(btnClear1);
        btnClear1.setBounds(444,617,120,32);
        btnClear1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    clearRegular();

                }
            });
        btnDispaly1 = new JButton("Display");
        panel2.add(btnDispaly1);
        btnDispaly1.setBounds(289,617,120,32);
        btnDispaly1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    displayRegular();
                }
            });

        btnGrant = new JButton("GrantCertificate");
        panel2.add(btnGrant);
        btnGrant.setBounds(134,617,120,32);
        btnGrant.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    grantCertificateToRegular();
                }
            });

        //dropout
        dropoutbtn2 = new JButton("Dropout");
        panel1.add(dropoutbtn2);
        dropoutbtn2.setBounds(140,150,175,25);
        dropoutbtn2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    panel1.setVisible(false);
                    StudentGUI.setSize(1100,800);
                    panel3.setVisible(true);
                }
            });

        label = new JLabel("Dropout Registration Form");
        label.setBounds(325,34,510,35);
        label.setFont(new Font("Arial",Font.PLAIN,30));
        panel3.add(label);

        studentName = new JLabel("StudentName:");
        studentName.setBounds(68,77,107,43);
        panel3.add(studentName);

        courseName = new JLabel("CourseName:");
        courseName.setBounds(667,77,107,43);
        panel3.add(courseName);

        dateOfBirth = new JLabel("DateOfBirth:");
        dateOfBirth.setBounds(68,167,107,43);
        panel3.add(dateOfBirth);

        dateOfEnrollement =new JLabel ("DateOFEnrollement:");
        dateOfEnrollement.setBounds(667,167,116,43);
        panel3.add(dateOfEnrollement);

        enrollmentID = new JLabel("EnrollmentID:");
        enrollmentID.setBounds(68,262,107,43);
        panel3.add(enrollmentID);

        dateofDropout = new JLabel("DateofDropOUt:");
        dateofDropout.setBounds(67,536,125,43);
        panel3.add(dateofDropout);

        numOfRemainingModules = new JLabel ("NumOfRemainingModules:");
        numOfRemainingModules.setBounds(667,267,116,43);
        panel3.add(numOfRemainingModules);

        courseDuration = new JLabel("CourseDuration:");
        courseDuration.setBounds(68,357,107,43);
        panel3.add(courseDuration);

        tuitionFee = new JLabel ("TuitionFee:");
        tuitionFee.setBounds(667,357,116,43);
        panel3.add(tuitionFee);

        numOfMonthsAttended = new JLabel("NumOfMonthsAttended:");
        numOfMonthsAttended.setBounds(68,452,125,43);
        panel3.add(numOfMonthsAttended);

        remainingAmount = new JLabel("RemainingAmount:");
        remainingAmount.setBounds(667,447,116,43);
        panel3.add(remainingAmount);

        lxtstudentName = new JTextField();
        lxtstudentName.setBounds(192,79,234,32);
        panel3.add(lxtstudentName);

        lxtcourseName = new JTextField();
        lxtcourseName.setBounds(796,77,234,32);
        panel3.add(lxtcourseName);

        String Dayss[]={"1","2","3","4","5","6","7","8","9","10"};
        ddaydateOfBirth = new JComboBox(Dayss);
        ddaydateOfBirth.setBounds(192,172,67,32);
        panel3.add(ddaydateOfBirth);

        String Monthss[] = {"january","February","March","April","May","June","July","August","September","October","November","December"};
        dmonthdateOfBirth = new JComboBox(Monthss);
        dmonthdateOfBirth.setBounds(276,172,66,32);
        panel3.add(dmonthdateOfBirth);

        String Yearss[] = {"2020","2021","2022","2023","2024"};
        dyeardateOfBirth = new JComboBox(Yearss);
        dyeardateOfBirth.setBounds(353,172,74,32);
        panel3.add(dyeardateOfBirth);

        String Daysss[]={"1","2","3","4","5","6","7","8","9","10"};
        ddayDateOfEnrollement = new JComboBox(Daysss);
        ddayDateOfEnrollement.setBounds(796,167,67,32);
        panel3.add(ddayDateOfEnrollement);

        String Monthsss[] = {"january","February","March","April","May","June","July","August","September","October","November","December"};
        dmonthDateOfEnrollement = new JComboBox(Monthsss);
        dmonthDateOfEnrollement.setBounds(879,167,66,32);
        panel3.add(dmonthDateOfEnrollement);

        String Yearsss[] = {"2001","2005","2010","2015","2020"};
        dyearDateOfEnrollement = new JComboBox(Yearsss);
        dyearDateOfEnrollement.setBounds(956,167,74,32);
        panel3.add(dyearDateOfEnrollement);

        lxtenrollmentId = new JTextField();
        lxtenrollmentId.setBounds(193,267,234,32);
        panel3.add(lxtenrollmentId);

        txtnumOfRemainingModules = new JTextField();
        txtnumOfRemainingModules.setBounds(795,267,234,32);
        panel3.add(txtnumOfRemainingModules);

        lxtcourseDuration = new JTextField();
        lxtcourseDuration.setBounds(193,357,234,32);
        panel3.add(lxtcourseDuration);

        lxttutionFee = new JTextField();
        lxttutionFee.setBounds(795,357,234,32);
        panel3.add(lxttutionFee);

        txtnumOfMonthsAttended = new JTextField();
        txtnumOfMonthsAttended.setBounds(193,452,234,32);
        panel3.add(txtnumOfMonthsAttended);

        txtremainingAmount = new JTextField();
        txtremainingAmount.setBounds(795,452,234,32);
        panel3.add(txtremainingAmount);

        String dropoutDays[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        dayOfDropoutComboBox = new JComboBox(dropoutDays);
        dayOfDropoutComboBox.setBounds(192,536,67,32);
        panel3.add(dayOfDropoutComboBox);

        String dropoutMonths[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthOfDropoutComboBox = new JComboBox(dropoutMonths);
        monthOfDropoutComboBox.setBounds(276,536,66,32);
        panel3.add(monthOfDropoutComboBox);

        String dropoutYears[] = {"2021", "2022", "2023", "2024", "2025"};
        yearOfDropoutComboBox = new JComboBox(dropoutYears);
        yearOfDropoutComboBox.setBounds(353,537,74,32);
        panel3.add(yearOfDropoutComboBox);

        hasPaid = new JLabel("hasPaid");
        hasPaid.setBounds(450,537,70,20);
        panel3.add(hasPaid);

        JRadioButton radio = new JRadioButton("False");
        radio.setBounds(500,537,50,20);
        panel3.add(radio);

        JRadioButton radio1 = new JRadioButton("True");
        radio1.setBounds(550,537,50,20);
        panel3.add(radio1);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio);
        bg.add(radio1);

        btnBack2 = new JButton("Back");
        panel3.add(btnBack2);
        btnBack2.setBounds(909,611,120,32);
        btnBack2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    panel1.setVisible(true);
                    panel3.setVisible(false);
                    StudentGUI.setSize(450,300);

                }
            });
        btnAdd2 = new JButton("Add");
        panel3.add(btnAdd2);
        btnAdd2.setBounds(754,611,120,32);
        btnAdd2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    addDropout();
                }
            });
        btnPayBills = new JButton("Pay Bills");
        panel3.add(btnPayBills);
        btnPayBills.setBounds(599,611,120,32);
        btnPayBills.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    payBillsForDropout();
                }
            });
        btnRemove = new JButton("RemoveDropout");
        panel3.add(btnRemove);
        btnRemove.setBounds(444,611,120,32);
        btnRemove.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    removeDropoutStudent();
                }
            });
        btnDispaly2 = new JButton("Display");
        panel3.add(btnDispaly2);
        btnDispaly2.setBounds(289,611,120,32);
        btnDispaly2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    displayDropout();
                }
            });
        btnClear2 = new JButton("Clear");
        panel3.add(btnClear2);
        btnClear2.setBounds(134,611,120,32);
        btnClear2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    clearDropout();
                }
            });

    }
    //Regular butoon function
    public void addRegular(){

        int enrollmentID = this.getEnrollmentID();
        String dateofBirth=this.getDateOfBirth(); 
        String  studentName = this.getStudentName();
        String coursename = this . getCourseName();
        String dateofenrollement = this.getDateOfEnrollement();
        int courseduration = this.getCourseDuration();
        int tutionfee = this.getTuitionFee();
        int numofmodules = this.getNumOfModules();
        int numofcredithours = this.getNumOfCreditHours();
        double dayspresent = this.getDaysPresent();
        boolean flag = false;

        if(enrollmentID==-1||dateofBirth.equals("")||studentName.equals("")||coursename.equals("")||dateofenrollement.equals("")||courseduration==-1||tutionfee==-1||numofmodules==-1||numofcredithours==-1||dayspresent==-1){
            JOptionPane.showMessageDialog(StudentGUI,"Fields Empty.\nPlease fill the required data","Empty Field",2);
            return;
        }else{
            if(students.isEmpty()){
                flag=true;

            }
            else{
                for(Student stu : students){
                    if(stu.getEnrollmentID()==(enrollmentID)){
                        JOptionPane.showMessageDialog(StudentGUI,"The Student data is already added","Repeated Data",2);
                        return;
                    }else{
                        flag=true;
                    }}
            }

        }

        if(flag==true){
            students.add(new Regular(enrollmentID,dateofBirth,studentName,coursename,dateofenrollement,courseduration,tutionfee,numofmodules,numofcredithours,dayspresent));
            String message = "EnrollmentID:"+enrollmentID+"\nDateofBirth:"+dateofBirth+"\nStudentName:"+studentName+"\nCourseName:"+coursename+"\nDateofEnrollement:"+dateofenrollement+"\nCourseDuration:"+courseduration+"\nTuitionFee"+tutionfee+"\nNumofModules:"+numofmodules+"\nNumofCreditHours:"+numofcredithours+"\nDaysPresent:"+dayspresent;
            JOptionPane.showMessageDialog(StudentGUI,message," successfully Added",1);

        }}

    public void calculateRegularPresentage() {
        int enrollmentID = this.getEnrollmentID();
        double daysPresent = this.getDaysPresent();

        String enrollmentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter Enrollment ID:");
        if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid Enrollment ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String daysPrsentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter daysPresent:");
        if(daysPrsentIDbox == null || daysPrsentIDbox.isEmpty()){
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid daysPresent ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;

        }

        int enteredEnrollmentID = Integer.parseInt(enrollmentIDbox);
        double daysPresentIDbox = Double.parseDouble(daysPrsentIDbox);
        boolean studentFound = false;

        for (Student stu : students) {
            if (stu instanceof Regular) {
                if (stu.getEnrollmentID() == enteredEnrollmentID) {
                    Regular regularStudent = (Regular) stu;
                    double presentPercentage = regularStudent.presentPercentage(daysPresent);
                    String grade;

                    if (presentPercentage >= 80) {
                        grade = "A";
                    } else if (presentPercentage >= 60) {
                        grade = "B";
                    } else if (presentPercentage >= 40) {
                        grade = "C";
                    } else if (presentPercentage >= 20) {
                        grade = "D";
                    } else {
                        grade = "E";
                    }

                    String message = "Enrollment ID: " + enteredEnrollmentID +"\nDaysPresent:"+daysPresentIDbox +"\nPresent Percentage: " + presentPercentage +"%\nGrade: " + grade ;
                    JOptionPane.showMessageDialog(StudentGUI, message, "Regular Student Present Percentage", JOptionPane.INFORMATION_MESSAGE);
                    studentFound = true;
                    break;
                }
            }
        }

        if (!studentFound) {
            JOptionPane.showMessageDialog(StudentGUI, "No Regular student found with the entered Enrollment ID.", "Student Not Found", JOptionPane.WARNING_MESSAGE);
        }
    } 

    public void clearRegular(){
        int Clear = JOptionPane.showConfirmDialog(StudentGUI,"ARE you sure you want to clear all text field?","Clear",JOptionPane.YES_NO_OPTION);
        if(Clear == JOptionPane.YES_OPTION){
            txtenrollmentId.setText("");

            txtstudentName.setText("");
            txtcourseName.setText("");

            txtcourseDuration.setText("");
            txttutionFee.setText("");
            txtnumOfModules.setText("");
            txtnumOfCreditHours.setText("");
            txtdaysPresent.setText("");}

    }

    public void displayRegular(){
        int count = 0;
        if(students.isEmpty()){
            count = 0;
        }else{
            for(Student stu : students){
                if(stu instanceof Regular){
                    Regular ac = (Regular)stu;
                    ac.display();
                    count++;
                }
            }
            if(count==0){
                JOptionPane.showMessageDialog(StudentGUI,"The Regular to display.","Display",1);
                return;
            }
        }
    }

    public void grantCertificateToRegular() {
        int enrollmentID = this.getEnrollmentID();
        String courseName = this.getCourseName();
        String dateOfEnrollment = this.getDateOfEnrollement();
        double daysPresent= this.getDaysPresent();
        String enrollmentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter Enrollment ID:");
        if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid Enrollment ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String daysPrsentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter daysPresent:");
        if(daysPrsentIDbox == null || daysPrsentIDbox.isEmpty()){
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid daysPresent ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;

        }
        String dateOfEnrollmentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter dateOfEnrollment:");
        if(dateOfEnrollmentIDbox == null || dateOfEnrollmentIDbox.isEmpty()){
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid dateOfEnrollmentID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;

        }
        int enteredEnrollmentID = Integer.parseInt(enrollmentIDbox);
        double daysPresentIDbox = Double.parseDouble(daysPrsentIDbox);
    

        boolean studentFound = false;
        for (Student stu : students) {
            if (stu instanceof Regular) {
                if (stu.getEnrollmentID() == enrollmentID) {
                    Regular regularstudent = (Regular) stu;

                    String certificateMessage = regularstudent.grandCertificate(courseName, enrollmentID, dateOfEnrollment);
                    JOptionPane.showMessageDialog(StudentGUI, certificateMessage, " Grand Certificate ", JOptionPane.INFORMATION_MESSAGE);
                    studentFound = true;
                    break;
                }
            }
        }

        if (!studentFound) {
            JOptionPane.showMessageDialog(StudentGUI, "No Regular student found with the entered Enrollment ID.", "Student Not Found", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Dropout button function
    public void addDropout() {
        int enrollmentID = this.getDropoutEnrollmentID();
        String dateOfBirth = this.getDropoutDateOfBirth();
        String studentName = this.getDropoutStudentName();
        String courseName = this.getDropoutCourseName();
        String dateOfEnrollment = this.getDropoutDateOfEnrollment();
        int courseDuration = this.getDropoutCourseDuration();
        int tuitionFee = this.getDropoutTuitionFee();
        int numOfRemainingModules = this.getDropoutNumOfRemainingModules();
        int numOfMonthsAttended = this.getDropoutNumOfMonthsAttended();
        int remainingAmount = this.getDropoutRemainingAmount();
        String dateOfDropout = this.getDropoutDateOfDropout();

        boolean flag = false;
        if (enrollmentID == -1 || dateOfBirth.equals("") || studentName.equals("") || courseName.equals("") || dateOfEnrollment.equals("") || courseDuration == -1 || tuitionFee == -1 || numOfRemainingModules == -1 || numOfMonthsAttended == -1 || remainingAmount == -1) {
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease fill the required data", "Empty Field", 2);
            return;
        } else {
            if (students.isEmpty()) {
                flag = true;
            } else {
                for (Student stu : students) {
                    if (stu.getEnrollmentID() == enrollmentID) {
                        JOptionPane.showMessageDialog(StudentGUI, "The Student data is already added", "Repeated Data", 2);
                        return;
                    } else {
                        flag = true;
                    }
                }
            }
        }

        if (flag == true) {
            students.add(new Dropout(enrollmentID, dateOfBirth, studentName, courseName, dateOfEnrollment, courseDuration, tuitionFee, numOfRemainingModules, numOfMonthsAttended, remainingAmount, dateOfDropout));
            String message = "EnrollmentID:" + enrollmentID + "\nDateofBirth:" + dateOfBirth + "\nStudentName:" + studentName + "\nCourseName:" + courseName + "\nDateofEnrollement:" + dateOfEnrollment + "\nCourseDuration:" + courseDuration + "\nTuitionFee:" + tuitionFee + "\nNumofRemainingModules:" + numOfRemainingModules + "\nNumofMonthsAttended:" + numOfMonthsAttended + "\nRemainingAmount:" + remainingAmount + "\nDateOfDropout:" + dateOfDropout;
            JOptionPane.showMessageDialog(StudentGUI, message, "Successfully Added", 1);
        }
    }

    public void payBillsForDropout() {
        int enrollmentID = this.getDropoutEnrollmentID();

        if (enrollmentID == -1) {
            JOptionPane.showMessageDialog(StudentGUI, "Invalid Enrollment ID. Please enter a valid Enrollment ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean flag = false;
        for (Student stu : students) {
            if (stu instanceof Dropout){ 
                if  ( stu.getEnrollmentID() == enrollmentID) {
                    Dropout dropoutStudent = (Dropout) stu;
                    dropoutStudent.billsPayable();
                    JOptionPane.showMessageDialog(StudentGUI,"The Bill has paid","payBill",2);
                    return;
                }else{

                    JOptionPane.showMessageDialog(StudentGUI,"The Bill has not paid","payBill",2);
                    return;

                }
            }

        }
    }

    public void removeDropoutStudent() {
        int enrollmentID = getDropoutEnrollmentID();
        String enrollmentIDbox = JOptionPane.showInputDialog(StudentGUI, "Enter Enrollment ID:");
        if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
            JOptionPane.showMessageDialog(StudentGUI, "Fields Empty.\nPlease enter valid Enrollment ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean found = false;
        for (Student stu : students) {
            if (stu instanceof Dropout && stu.getEnrollmentID() == enrollmentID) {
                students.remove(stu);
                JOptionPane.showMessageDialog(StudentGUI,"The Student is removed","Remove Data",2);
                return;
            }else{

                JOptionPane.showMessageDialog(StudentGUI,"The student  is already removed","Removed Data",2);
                return;

            }
        }

    }

    public void displayDropout(){
        int count = 0;
        if(students.isEmpty()){
            count = 0;

        }else{
            for(Student stu : students){
                if(stu instanceof Dropout){
                    Dropout d = (Dropout)stu;
                    d.display();
                    count++;
                }
            }
            if(count==0){
                JOptionPane.showMessageDialog(StudentGUI,"The  Dropout Student to display.","Display",2);
                return;
            }
        }
    }

    public void clearDropout(){
        int Clear2 = JOptionPane.showConfirmDialog(StudentGUI,"ARE you sure you want to clear all text field?","Clear",JOptionPane.YES_NO_OPTION);
        if(Clear2 == JOptionPane.YES_OPTION){
            lxtenrollmentId.setText("");

            lxtstudentName.setText("");
            lxtcourseName.setText("");

            lxtcourseDuration.setText("");
            lxttutionFee.setText("");
            txtnumOfRemainingModules.setText("");
            txtnumOfMonthsAttended.setText("");
            txtremainingAmount.setText("");
        }

    }

    public static void main(String []args){
        new StudentGUI().StudentGUI.setVisible(true);
    } 

}

