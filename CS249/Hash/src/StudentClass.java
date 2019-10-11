public class StudentClass implements Comparable<StudentClass>
{
	private final char COMMA = ',';
	public String name;
	public int studentID;
	public char gender;
	public double gpa;

	/**
	 * constructor for student class
	 * @param inName name of student
	 * @param inStudentID student id number
	 * @param inGender gender of student
	 * @param inGPA gpa of student
	 */
	public StudentClass(String inName, int inStudentID,
						char inGender, double inGPA)
	{
		name = inName;
		studentID = inStudentID;
		gender = inGender;
		gpa = inGPA;
	}

	/**
	 * copy constructor for student class
	 * @param copied student to be copied
	 */
	public StudentClass(StudentClass copied)
	{
		this.name = copied.name;
		this.studentID = copied.studentID;
		this.gender = copied.gender;
		this.gpa = copied.gpa;
	}

	/**
	 * compares last names of students to determine which is larger
	 * @param other student that this student is being compared to
	 * @return the result of last name comparison
	 */
	public int compareTo(StudentClass other)
	{
		int sum = 0;
		int stringIndex;

		for (stringIndex = 0; name.charAt(stringIndex) != COMMA; stringIndex++)
		{
			sum += name.charAt(stringIndex);
		}

		for (stringIndex = 0; other.name.charAt(stringIndex) != COMMA;
			 stringIndex++)
		{
			sum -= other.name.charAt(stringIndex);
		}

		return sum;
	}

	/**
	 * provides hash for student
	 * @return hashed value for student
	 */
	public int hashCode()
	{
		int sum = 0;
		int index = 0;
		while (name.charAt(index) != COMMA)
		{
			sum += (int) name.charAt(index);
			index++;
		}

		return sum;
	}

	/**
	 * outputs student data in formatted string
	 * @return formatted string of student data
	 */
	public String toString()
	{
		return name + "/" + studentID + "/" + gender + "/" + gpa;
	}
}
