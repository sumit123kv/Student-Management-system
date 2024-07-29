
/**
 * Write a description of class Regular here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Regular extends Student
{//instance variable
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship=false;
    public  Regular(int enrollmentID, String dateOfBirth, String studentName,String courseName,String dateOfEnrollement, int courseDuration, int tuitionFee,
    int numOfModules, int numOfCreditHours, double daysPresent)// initialize instance variable and from student class variable
    {//used  super keyword to call from student class
        super(dateOfBirth,studentName,courseDuration,tuitionFee);
        setCourseName(courseName);
        setEnrollmentID(enrollmentID);
        setDateOfEnrollement(dateOfEnrollement);
        this.numOfModules=numOfModules;
        this.numOfCreditHours=numOfCreditHours;
        this.daysPresent=daysPresent;
        this.isGrantedScholarship=false;
    }// accessor method
    public int getNumOfModules(){
        return numOfModules;
    }

    public int getNumOfCreditHours(){
        return numOfCreditHours;
    }

    public double getDaysPresent(){
        return daysPresent;
    }

    public boolean getIsGrantedScholarship(){
        return isGrantedScholarship;
    }
    // creating presentPercentage method to check GrantedScholarship 
    public double presentPercentage(double DaysPresent){
        double presentPercentage=(DaysPresent/30/super.getCourseDuration())*100;
        if(super.getCourseDuration()<DaysPresent/30){
            System.out.println("result not found try again");
        }
        else if(presentPercentage>=80){
            isGrantedScholarship=true;
            System.out.println('A');
        }
        else if(presentPercentage>=60&&presentPercentage<=79){
            System.out.println('B');
        }
        else if(presentPercentage>=40&&presentPercentage<=59){
            System.out.println('C');
        }
        else if(presentPercentage>=20&&presentPercentage<=39){
            System.out.println('D');
        }
        else{
            System.out.println('E');
        }
        return presentPercentage;
    }// creating grandCertificate method to check whether is granted scholarship or not
    public String grandCertificate(String courseName, int enrollmentID, String dateOfEnrollment) {
        String message = "Course Name of student: " + courseName + "\n" +
            "Enrollment ID of student: " + enrollmentID + "\n" +
            "Date of enrollment of student: " + dateOfEnrollment + "\n" +
            "Student has graduated.\n";

        if (isGrantedScholarship) {
            message += "The scholarship has been granted.";
        } else {
            message += "The scholarship has not been granted.";
        }

        return message;
    }

    public void display(){
        super.display();
        System.out.println("Number of Module of student: "+this.numOfModules);
        System.out.println("Number of credit hours of student: "+this.numOfCreditHours);
        System.out.println("Number of days present of student: "+this.daysPresent);
    }    
}
