public class StudentClass
{
    public String name;
    public int studentID;
    public char gender;
    public double gpa;

    public StudentClass(java.lang.String inName, int inStudentID, char inGender,
                        double inGPA)
    {
        name = inName;
        studentID = inStudentID;
        gender = inGender;
        gpa = inGPA;
    }

    public StudentClass(StudentClass copied)
    {
        this.name = copied.name;
        this.studentID = copied.studentID;
        this.gender = copied.gender;
        this.gpa = copied.gpa;
    }

    public int compareTo(StudentClass other)
    {
        return (int) ((this.gpa - other.gpa) * 100000);
    }

    public String toString()
    {
        return name + "/" + studentID + "/" + gender + "/" + gpa;
    }

}
