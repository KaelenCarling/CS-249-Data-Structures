package p5_package;
public class IteratorClass extends BasicArrayClass
{
    private final char SPACE = ' ';
    private final char LEFT_BRACKET = '[';
    private final char RIGHT_BRACKET = ']';
    private int currentIndex;

    /**
     * constructor that initializes the default class
     */
    public IteratorClass()
    {
        super();
    }

    /**
     * constructor that initializes the class with a parameter
     * @param initCapacity capacity to initialize the iterator with
     */
    public IteratorClass(int initCapacity)
    {
        super(initCapacity);
    }

    /**
     * copy constructor
     * @param copied iterator to be copied
     */
    public IteratorClass(IteratorClass copied)
    {
        super(copied.getCurrentCapacity());
    }

    /**
     * clears the iterator
     */
    public void clear()
    {
        super.clear();

        currentIndex = 0;
    }

    /**
     * gets the value at the current index
     * @return the value at the current index
     */
    public int getAtCurrent()
    {
        return getAtIndex(currentIndex);
    }

    /**
     * checks to see if the current index is at the beginning
     * @return returns true if it is at the beginning
     */
    public boolean isAtBeginning()
    {
        if (currentIndex == 0)
        {
            return true;
        }

        return false;
    }

    /**
     * checks to see if current index is at the end of the array
     * @return returns true if the value is at the end of the array and
     * false if it isn't
     */
    public boolean isAtEnd()
    {
        if (currentIndex == (getCurrentSize()-1))
        {
            return true;
        }

        return false;
    }

    /**
     * checks to see if iterator is empty
     * @return returns true if it is empty and false if it isn't
     */
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    /**
     * moves iterator to next index
     * @return returns true if it moves to next index otherwise it returns false
     */
    public boolean moveNext()
    {
        if(currentIndex < getCurrentSize())
        {
            currentIndex++;
            return true;
        }

        return false;
    }

    /**
     * moves iterator to previous index
     * @return returns true if it moves to previous index otherwise returns true
     */
    public boolean movePrev()
    {
        if(currentIndex > 0)
        {
            currentIndex--;
            return true;
        }

        return false;
    }

    /**
     * removes value at the current index
     * @return value of the removed value
     */
    public int removeAtCurrent()
    {
        if (isEmpty())
        {
            return FAILED_ACCESS;
        }
        else
        {
            return removeAtIndex(currentIndex);
        }
    }

    /**
     * replaces the value at the current index
     * @param newValue value that is being inserted
     * @return returns true if value was placed and false if it wasn't
     */
    public boolean replaceAtCurrent(int newValue)
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            return setAtIndex(currentIndex, newValue, REPLACE);
        }
    }

    /**
     * prints out display of iterator for diagnostic purposes
     */
    public void runDiagnosticDisplay()
    {
        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < getCurrentSize(); arrayIndex++)
        {
            if (arrayIndex == currentIndex)
            {
                System.out.print(LEFT_BRACKET + arrayIndex + RIGHT_BRACKET + SPACE);
            }
            else
            {
                System.out.print(arrayIndex + SPACE);
            }
        }
        System.out.print('\n');
    }

    /**
     * sets value after current index
     * @param newValue value to be placed
     * @return result of placement
     */
    public boolean setAfterCurrent(int newValue)
    {
        return setAtIndex(currentIndex, newValue, INSERT_AFTER);
    }

    /**
     * sets value before the current index
     * @param newValue value to be placed
     * @return result of placement
     */
    public boolean setBeforeCurrent(int newValue)
    {
        return setAtIndex(currentIndex, newValue, INSERT_BEFORE);
    }

    /**
     * resets the current index to the beginning
     * @return the result of the placement
     */
    public boolean setToBeginning()
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            currentIndex = 0;
            return true;
        }
    }

    /**
     * sets the current index to the end of the array
     * @return result of the placement.
     */
    public boolean setToEnd()
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            currentIndex = getCurrentSize()-1;
            return true;
        }
    }
}
