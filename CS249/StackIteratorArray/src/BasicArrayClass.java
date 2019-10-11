package p5_package;
public class BasicArrayClass
{
    /**
     * Holds the Capacity of the array
     */
    private int arrayCapacity; //amount of elements it can hold

    /**
     * Holds the size of the array
     */
    private int arraySize; // amount of elements that it does hold

    /**
     * Constant for if no capacity was set
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Int value for a failure to access
     */
    public static final int FAILED_ACCESS = -999999;

    /**
     * Int value for insert after
     */
    public static final int INSERT_AFTER = 1003;

    /**
     * int value for insert before
     */
    public static final int INSERT_BEFORE =  1002;

    /**
     * Array that holds the values for the BasicArrayClass
     */
    private int[] localArray;

    /**
     * int value for remove flag
     */
    public static final int REMOVE = 1004;

    /**
     * int value for replace flag
     */
    public static final int REPLACE = 1001;

    /**
     * int value flag for retrieve flag
     */
    public static final int RETRIEVE = 1005;


    /**
     * default constructor class. initializes array with a capacity of 10
     */
    protected BasicArrayClass()
    {
        localArray = new int[DEFAULT_CAPACITY];
        arraySize = 0;
        arrayCapacity = DEFAULT_CAPACITY;

        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < arrayCapacity; arrayIndex++)
        {
            localArray[arrayIndex] = 0;
        }
    }


    /**
     * copy constructor
     * @param copied constructor to be copied
     */
    protected BasicArrayClass(BasicArrayClass copied)
    {
        arraySize = 0;
        arrayCapacity = copied.arrayCapacity;
        localArray = new int[copied.arrayCapacity];

        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < localArray.length; arrayIndex++)
        {
            this.localArray[arrayIndex] = 0;
        }

    }

    /**
     * constructor that initializes array with capacity given
     * @param capacity capacity of array
     */
    protected BasicArrayClass(int capacity)
    {
        arraySize = 0;
        arrayCapacity = capacity;
        localArray = new int[arrayCapacity];

        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < arrayCapacity; arrayIndex++)
        {
            localArray[arrayIndex] = 0;
        }
    }

    /**
     * accesses at a specific index and either retrieves or removes
     * @param controlCode code that tells it either to remove or retrieve
     * @param index index that is being accessed at
     * @return returns the value that is in that index
     */

    private int accessAtIndex(int controlCode, int index)
    {
        checkForResize();
        int returnValue;
        if (controlCode == RETRIEVE)
        {
            returnValue = localArray[index];
        }

        // second else if to show that it does the same thing irregardless
        // of control code
        else if (controlCode == REMOVE)
        {
            returnValue = localArray[index];
            int[] temp = new int[arrayCapacity];

            int newArrayIndex = 0, oldArrayIndex;

            for (oldArrayIndex = 0; oldArrayIndex < arrayCapacity; oldArrayIndex++)
            {
                if (oldArrayIndex != index)
                {
                    temp[newArrayIndex++] = localArray[oldArrayIndex];
                }
            }
            arraySize--;
            localArray = temp;
        }

        else
        {
            returnValue = FAILED_ACCESS;
        }

        return returnValue;
    }

    /**
     * checks to see if the arraysize is close to arracapicity and then resizes
     * if it is
     */
    protected void checkForResize()
    {
        if (arraySize >= (arrayCapacity-1))
        {
            int[] temp = new int[arrayCapacity*2];

            int arrayIndex;
            for (arrayIndex = 0; arrayIndex < arrayCapacity; arrayIndex++)
            {
                temp[arrayIndex] = localArray[arrayIndex];
            }

            localArray = temp;
        }
    }

    /**
     * sets arraySize to 0
     */
    protected void clear()
    {
        arraySize = 0;
    }

    /**
     * retrieves value at given index
     * @param accessIndex index that is being accessed
     * @return value at the accessed index
     */
    protected int getAtIndex(int accessIndex)
    {
        return accessAtIndex( RETRIEVE, accessIndex);
    }

    /**
     * gets the capacity of the array
     * @return the capacity of the array
     */
    protected int getCurrentCapacity()
    {
        return arrayCapacity;
    }

    /**
     * gets the current size of the array
     * @return
     */
    protected int 	getCurrentSize()
    {
        return arraySize;
    }

    /**
     * checks to see if the array is empty
     * @return returns true if the array is empty and false if it contains data
     */
    protected boolean isEmpty()
    {
        boolean returnValue = false;

        if (arraySize <= 0)
        {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * removes the value at a specific index
     * @param removeIndex index that is being removed
     * @return the value of the removed index
     */
    protected int removeAtIndex(int removeIndex)
    {
        return accessAtIndex(REMOVE, removeIndex);
    }

    /**
     * sets a value at a specific index either before after or replacing
     * @param setIndex index that the value is placed around
     * @param newValue value for new index
     * @param replaceFlag flag to decide if should be replaced, insert before,
     *                    insert after
     * @return returns true if it was succesfully placed, false if it didn't
     */
    protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
    {
        checkForResize();
        if (arraySize == 0)
        {
            localArray[0] = newValue;
            arraySize++;
            return true;
        }

        if (replaceFlag == REPLACE)
        {
            localArray[setIndex] = newValue;
            return true;
        }

        else if (replaceFlag == INSERT_BEFORE)
        {
            int arrayIndex;
            for (arrayIndex = arraySize; arrayIndex > setIndex + 1; arrayIndex--)
            {
                localArray[arrayIndex + 1] = localArray[arrayIndex];
            }

            // add new element at first position
            if (setIndex > 0)
            {
                localArray[setIndex - 1] = newValue;
            }

            arraySize++;
            return true;
        }

        else if (replaceFlag == INSERT_AFTER)
        {
            int arrayIndex;
            for (arrayIndex = arraySize; arrayIndex > setIndex - 1; arrayIndex--)
            {
                localArray[arrayIndex + 1] = localArray[arrayIndex];
            }
            localArray[setIndex] = newValue;

            arraySize++;
            return true;
        }
        return false;
    }
}
