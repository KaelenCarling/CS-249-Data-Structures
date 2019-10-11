package p5_package;
public class StackClass
{
    /**
     * array class used for the stack class
     */
    private BasicArrayClass stackData;

    /**
     * default stack constructor that uses the default array constructor
     */
    public StackClass()
    {
        stackData = new BasicArrayClass();
    }

    /**
     * constructor that initializes stack data with capacity parameter
     * @param capacitySetting
     */
    public StackClass(int capacitySetting)
    {
        stackData = new BasicArrayClass(capacitySetting);
    }

    /**
     * copied constructor
     * @param copied copied Stack class
     */
    public StackClass(StackClass copied)
    {
        stackData = new BasicArrayClass(copied.stackData.getCurrentCapacity());
    }

    /**
     * clears stack
     */
    public void clear()
    {
        stackData.clear();
    }

    /**
     * displays the stack
     */
    public void displayStack()
    {
        int stackIndex;
        for (stackIndex = 0; stackIndex < (stackData.getCurrentSize()-1); stackIndex++)
        {
            System.out.print(stackData.getAtIndex(stackIndex) + " ");
        }
        System.out.print('\n'); // I know this is the same as Sytem.out.println
                                // but I think this is easier to understand
    }

    /**
     * checks to see if stack is empty
     * @return true if the stack is empty and false if the stack has
     * anything in it
     */
    public boolean isEmpty()
    {
        int stackIndex;
        for (stackIndex = 0; stackIndex < stackData.getCurrentSize(); stackIndex++)
        {
            if (!(stackData.getCurrentSize() == 0))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * gets value of the top of the stack
     * @return the value of the top stack
     */
    public int peekTop()
    {
        int topIndex = stackData.getCurrentSize() - 1;
        return stackData.getAtIndex(topIndex);
    }

    /**
     * pulls the top index from the stack
     * @return the value of the popped index
     */
    public int pop()
    {
        int topValue = 0;

        if (!isEmpty())
        {
            int topIndex = stackData.getCurrentSize() - 1;
            topValue = stackData.removeAtIndex(topIndex);
        }

        return topValue;
    }

    /**
     * adds a new value to the top of the stack
     * @param newVal value thats to be added
     */
    public void push(int newVal)
    {
        int topIndex = stackData.getCurrentSize() - 1;
        stackData.setAtIndex(topIndex, newVal, stackData.INSERT_AFTER);
    }
}
