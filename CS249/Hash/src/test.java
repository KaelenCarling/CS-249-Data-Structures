public class test
{
	public static void main(String args[])
	{
		StudentClass test = new StudentClass("aaa, c", 3, 'M', 3.41);
		StudentClass test2 = new StudentClass("aaaa, aaaaaaa", 3, 'M', 3.41);

		System.out.println(test.compareTo(test2));



	}

	public static int generateHash(StudentClass item)
	{
		int itemIndex = item.hashCode()% 10;
		return itemIndex;
	}
}
