
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{// instance variable
    private String dateOfBirth;
    private String courseName;
    private String studentName;
    private String dateOfEnrollement;
    private int enrollmentID;
    private int courseDuration;
    private int tuitionFee;

    Student(String dateOfBirth,String studentName,int courseDuration,int tuitionFee)// initialize instance variable
    {
        this.dateOfBirth=dateOfBirth;
        this.studentName=studentName;
        this.courseDuration=courseDuration;
        this.tuitionFee=tuitionFee;
        this.courseName="";
        this.dateOfEnrollement="";
        this.enrollmentID=0;
    }// accessor method
    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getDateOfEnrollement(){
        return dateOfEnrollement;
    }

    public int getEnrollmentID(){
        return enrollmentID;
    }

    public int getCourseDuration(){
        return courseDuration;
    }

    public int getTuitionFee(){
        return tuitionFee;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    // muthator method
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public void setStudentName(String studentName){
        this.studentName=studentName;
    }  

    public void setDateOfEnrollement(String dateOfEnrollement){
        this.dateOfEnrollement=dateOfEnrollement;
    }

    public void setEnrollmentID(int enrollmentID){
        this.enrollmentID=enrollmentID;
    }

    public void setCourseDuration(int courseDuration){
        this.courseDuration=courseDuration;
    }

    public void setTuitionFee(int tuitionFee){
        this.tuitionFee=tuitionFee;
    }

    public void display(){
        if(dateOfBirth==""||courseName==""||studentName==""||dateOfEnrollement==""||enrollmentID==0||
        courseDuration==0||tuitionFee==0){
            System.out.println(" set all of your parameters");
        }
        else{
            System.out.println("dateOfBirth:"+dateOfBirth);
            System.out.println("courseName:"+courseName);
            System.out.println("StudentName:"+studentName);
            System.out.println("dateOfEnrollement:"+dateOfEnrollement);
            System.out.println("enrollmentID:"+enrollmentID);
            System.out.println("courseDuration:"+courseDuration);
            System.out.println("TutionFee:"+tuitionFee);

        }
    }

}