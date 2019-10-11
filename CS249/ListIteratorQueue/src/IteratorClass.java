
public class IteratorClass extends BasicLinkedListClass
{
    private final char SPACE = ' ';
    private final char LEFT_BRACKET = '[';
    private final char RIGHT_BRACKET = ']';
    private int currentIndex;

    /**
     * constructor for iterator class
     */
    public IteratorClass()
    {
        super();
    }

    /**
     * copy constructor of iterator class
     * @param copied Iterator to be copied
     */
    public IteratorClass(IteratorClass copied)
    {
        super(copied);
    }

    /**
     * clears iterator of values
     */
    public void clear()
    {
        super.clear();
    }

    /**
     * gets index of current value
     * @return
     */
    public int getAtCurrent()
    {
        return super.getAtIndex(currentIndex);
    }

    /**
     * checks to see if current index is at the beginning
     * @return true if it is at the beginning and false if it isn't
     */
    public boolean isAtBeginning()
    {
        if (currentIndex == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * checks to see if current index is at the end
     * @return true if it is at the end and false if it isn't
     */
    public boolean isAtEnd()
    {
        if (currentIndex == getCurrentSize()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * checks to see if iterator is empty
     * @return true if the iterator is empty and false if it isn't
     */
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    /**
     * moves currentindex to the next index if it exists
     * @return boolean value of attempting to move
     */
    public boolean moveNext()
    {
        if (currentIndex < super.getCurrentSize() && !isEmpty())
        {
            currentIndex++;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * moves iterator to the previous index if it can
     * @return boolean value of attempting to move
     */
    public boolean movePrev()
    {
        if (currentIndex > 0 && !isEmpty())
        {
            currentIndex--;
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * removes index at the current index
     * @return the value of the moved index
     */
    public int removeAtCurrent()
    {
        return super.removeAtIndex(currentIndex);
    }

    /**
     * replaces value at the current index
     * @param newValue value to replace old value
     * @return boolean value of attempting to replace it
     */
    public boolean replaceAtCurrent(int newValue)
    {
        return super.setAtIndex(currentIndex, newValue, REPLACE);
    }

    /**
     * diagnostic display to help visual the iterator
     */
    public void runDiagnosticDisplay()
    {
        int virtualIndex;
        for (virtualIndex = 0; virtualIndex < super.getCurrentSize();
             virtualIndex++)
        {
            if (virtualIndex == currentIndex)
            {
                System.out.print(LEFT_BRACKET + getAtIndex(virtualIndex) +
                        RIGHT_BRACKET + SPACE);
            }
            System.out.print(getAtIndex(virtualIndex) + SPACE);
        }
    }

    /**
     * sets new value after current value
     * @param newValue new value to be placed
     * @return result of attempted placement
     */
    public boolean setAfterCurrent(int newValue)
    {
        return setAtIndex(currentIndex, newValue, INSERT_AFTER);
    }

    /**
     * sets new value before the current value
     * @param newValue new value to be placed
     * @return result of attempted placement
     */
    public boolean setBeforeCurrent(int newValue)
    {
        return setAtIndex(currentIndex, newValue, INSERT_BEFORE);
    }

    /**
     * sets current index to the beginning of list
     * @return result of attempted placement
     */
    public boolean setToBeginning()
    {
        if (!isEmpty())
        {
            currentIndex = 0;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * sets current index to the end of list
     * @return result of attempted placement
     */
    public boolean setToEnd()
    {
        if (!isEmpty())
        {
            currentIndex = getCurrentSize() - 1;
            return true;
        }
        else
        {
            return false;
        }
    }
}
