import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class student {
    private String name;
    private Date dob;
    private int age;

    public student(String name, String dob) throws ParseException {
        this.name = name;
        this.dob = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
        this.age = calculateAge();
    }

    private int calculateAge() {
        Date today = new Date();
        long ageInMillis = today.getTime() - dob.getTime();
        return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365)); // approximate year length of 365 days
    }

    public void displayStudentDetails() {
        // Correct the date format to "dd-MM-yyyy"
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + new SimpleDateFormat("dd-MM-yyyy").format(dob));
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) throws ParseException {
        student student = new student("Alice", "15-08-2002");
        student.displayStudentDetails();
    }
}