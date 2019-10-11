/**
 * @author Kaelen Carling
 */

public class LogN_SortDriverClass
{

    public static int compareStrings(String strOne, String strTwo)
    {
        int strOneValue = 0;
        int strTwoValue = 0;
        int returnValue;

        for (int i = 0; i < strOne.length() && i < strTwo.length(); i++)
        {
            //System.out.println(strOne.charAt(i));
            strOneValue += toLowerCase(strOne.charAt(i));
            strTwoValue += toLowerCase(strTwo.charAt(i));
        }

        returnValue = strOneValue - strTwoValue;

        if (strOne.length() != strTwo.length() && returnValue == 0)
        {
            return strOne.length() - strTwo.length();
        }

        //System.out.println("Return Value is: " + returnValue);
        return returnValue;
    }

    //this is for going up
    private static void runMerge(String[] localArray, int lowIndex,
                                 int middleIndex, int highIndex)
    {
        String[] tempArray = new String[lowIndex + highIndex];
        for (int i = lowIndex; i <= highIndex; i++)
        {
            System.out.println(tempArray.length + " | "+ localArray.length);
            System.out.println(i + " " + tempArray[i] + "|" + localArray[i] + " " + i);
            tempArray[i] = localArray[i];
        }

        int i =lowIndex;
        int j = middleIndex +1;
        int k = lowIndex;

        while ( i <= middleIndex && j <= highIndex)
        {
            if (compareStrings(tempArray[i], tempArray[j]) <= 0)
            {
                localArray[k] = tempArray[i];
                i++;
            }
            else
            {
                localArray[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i<=middleIndex)
        {
            localArray[k] = tempArray[i];
            i++;
            k++;
        }
        //= new String[lowIndex+highIndex];

        /*
        String[] tempMergArr = new String[highIndex];
        for (int i = lowIndex; i <= highIndex; i++) {
            tempMergArr[i] = localArray[i];
        }
        int i = lowIndex;
        int j = middleIndex + 1;
        int k = lowIndex;
        while (i <= middleIndex && j <= highIndex) {
            if (compareStrings(tempMergArr[i], tempMergArr[j]) <=0) {
                localArray[k] = tempMergArr[i];
                i++;
            } else {
                localArray[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middleIndex) {
            localArray[k] = tempMergArr[i];
            k++;
            i++;
        }
        */

        /*
        System.out.println(middleIndex);
        System.out.println("Entered merge sort");
        int lowArrayIndex, highArrayIndex;
        int lowArraySize = middleIndex - lowIndex +1;
        int highArraySize = highIndex - middleIndex;
        String[] lowArray = new String[lowArraySize];
        String[] highArray = new String[highArraySize];

        // copies data to temp arrays
        for (lowArrayIndex = 0; lowArrayIndex < lowArraySize; lowArrayIndex++)
        {
            lowArray[lowArrayIndex] = localArray[lowArrayIndex];
            //System.out.println(lowArrayIndex + ": " +localArray[lowArrayIndex]);
        }
        for (highArrayIndex = 0; highArrayIndex < highArraySize; highArrayIndex++)
        {
            highArray[highArrayIndex] = localArray[highArrayIndex];
            System.out.println(highArrayIndex + ": " + localArray[highArrayIndex]);
        }

        int localArrayIndex = 1;
        lowArrayIndex = 0;
        highArrayIndex = 0;
        int compareStringsValue;

        //initial comparison and merge
        System.out.println("lowArrayIndex: " + lowArrayIndex);
        System.out.println("high array index : " + highArrayIndex);
        while (lowArrayIndex < lowArraySize && highArrayIndex < highArraySize)
        {
            compareStringsValue = compareStrings(lowArray[lowArrayIndex], highArray[highArrayIndex]);
            System.out.println("string compare: " + compareStringsValue);
            if (compareStringsValue <= 0)
            {
                //System.out.println(lowArray[lowArrayIndex] + " : " + highArray[highArrayIndex]);
                //System.out.println(compareStrings(lowArray[lowArrayIndex], highArray[highArrayIndex]));
                //System.out.println(localArray[localArrayIndex]);
                localArray[localArrayIndex] = lowArray[lowArrayIndex];
                //System.out.println(localArray[localArrayIndex]);
                lowArrayIndex++;
            }
            else
            {
                localArray[localArrayIndex] = highArray[highArrayIndex];
                highArrayIndex++;
            }
            localArrayIndex++;
        }

        // while loops for the rest of the sorting
        while (lowArrayIndex < lowArraySize)
        {
            localArray[localArrayIndex] = lowArray[lowArrayIndex];
            localArrayIndex++;
            lowArrayIndex++;
        }

        while (highArrayIndex < highArraySize)
        {
            //System.out.println(localArray.length);
            //System.out.println(localArrayIndex);
            localArray[localArrayIndex] = highArray[highArrayIndex];
            localArrayIndex++;
            lowArrayIndex++;
        }
        */

    }

    public static void runMergeSort(String[] localArray, int size)
    {
        runMergeSortHelper(localArray, 0, size-1);
    }

    private static void runMergeSortHelper(String[] localArray, int lowIndex,
                                           int highIndex)
    {
        //int midPoint = 1+((lowIndex + highIndex) / 2);
        //System.out.println("Entered quick sort");

        if (lowIndex < highIndex)
        {
            //if ((lowIndex + highIndex) < 2)
            //{
            //return;
            //}
            int midPoint = lowIndex + (lowIndex + highIndex) / 2;
            System.out.println(midPoint);
            runMergeSortHelper(localArray, lowIndex, midPoint);
            runMergeSortHelper(localArray, midPoint + 1, highIndex);
            System.out.println("before merge " + midPoint);
            runMerge(localArray, lowIndex, midPoint, highIndex);
        }

        //this is for going down
        //4 loops 1st is temp array that copys some values in there (half)
        // second loop is for copying values back into localArray sorted


        /*
        int size = (lowIndex + highIndex)/2;
        String[] tempLoop = new String[size];
        int lwi = 0;
        int lowCap = size/2;
        int hwi = lowCap+1;
        int hiCap = size - 1;
        */


        //loop to assign duplicate variables
        /*
        int count = 0;
        for (String loopAssign : localArray)
        {
            tempLoop[count] = loopAssign;
            count++;
        }
        */
/*
        for (int i = 0; i < size; i++)
        {
            tempLoop[i] = localArray[i];
        }
        */

        // comparison loop

        /*
        while (lwi <= lowCap && hwi <= hiCap){
            if (tempLoop[lwi] < tempLoop[hwi])
            //assign lwi -> localArray(low)Index
                //increment lwi and inc
        }
        */

        //clean up loop left

        //clean up loop right

    }

    private static int runPartition(String[] localArray, int lowIndex,
                                    int highIndex)
    {


        //int workingIndex = lowIndex+1;
        int pivotIndex = lowIndex; // use first element as pivot

        int smallerIndex = lowIndex -1;

        int j = lowIndex;
        while (j <= highIndex)
        {
            if (compareStrings(localArray[j], localArray[pivotIndex]) <= 0)
            {
                smallerIndex++;
                swapValues(localArray, smallerIndex, lowIndex);
            }
        }

        int testPivotIndex = pivotIndex + 1;
        swapValues(localArray, testPivotIndex, highIndex);

        // increment working index comparing to pivot. if its greater swap and move the pivot index by 1
        // after the loop swap low index with pivot index

        return testPivotIndex;
    }

    public static void runQuickSort(String[] localArray, int size)
    {
        size--;
        runQuickSortHelper(localArray, 0, size-1 );
    }

    private static void runQuickSortHelper(String[] localArray, int lowIndex,
                                           int highIndex)
    {
        if (lowIndex < highIndex)
        {
            int partitionIndex = runPartition(localArray, lowIndex, highIndex);

            runQuickSortHelper(localArray, lowIndex, partitionIndex -1);
            runQuickSortHelper(localArray, partitionIndex+1, highIndex);
        }
    }

    private static void swapValues(String[] localArray, int indexOne,
                                   int indexOther)
    {
        String holdingValue = localArray[indexOne];
        localArray[indexOne] = localArray[indexOther];
        localArray[indexOther] = holdingValue;
    }

    private static char toLowerCase(char testChar)
    {
        if (testChar >= 'A' && testChar <= 'Z')
        {
            testChar = (char) (testChar - 'A' + 'a');
        }

        return testChar;
    }
}
