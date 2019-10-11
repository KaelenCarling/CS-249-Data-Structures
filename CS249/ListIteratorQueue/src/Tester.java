public class Tester
{
    public static void main(String args[])
    {
        BasicLinkedListClass LinkedList = new BasicLinkedListClass();

        for (int i = 0; i < 10; i++)
        {
            LinkedList.setAtIndex(i, i, BasicLinkedListClass.INSERT_AFTER);
        }

        for (int i =0; i < 10; i++)
        {
            System.out.print(LinkedList.getAtIndex(i) + " ");
        }

        System.out.println("");
        BasicLinkedListClass copiedList = new BasicLinkedListClass(LinkedList);

        for (int i = 0; i < copiedList.getCurrentSize(); i++)
        {
            System.out.print(copiedList.getAtIndex(i) + "");
        }
    }
}
