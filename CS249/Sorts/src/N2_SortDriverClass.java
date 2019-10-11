public class N2_SortDriverClass
{
    public N2_SortDriverClass()
    {

    }

    public static char[] runBubbleSort(char[] charArr, int size)
    {
        boolean hasSwapped = true;

        int tempIndex, tempDecrement;
        while (hasSwapped)
        {
            hasSwapped = false;
            for (tempIndex = 1; tempIndex < size; tempIndex++)
            {
                tempDecrement = tempIndex - 1;
                if (charArr[tempDecrement] > charArr[tempIndex])
                {
                    swapValues(charArr, tempDecrement, tempIndex);
                    hasSwapped = true;
                }
            }
        }
        return charArr;
    }

    public static char[] runInsertionSort(char[] charArr, int size)
    {
        int outerTemp, j;

        for (outerTemp = 1; outerTemp < size; outerTemp++)
        {
            j = outerTemp - 1;
            while (j >= 0 && charArr[j] > charArr[outerTemp])
            {
                swapValues(charArr, outerTemp, j);

                outerTemp = j;
                j--;

            }
        }


        return charArr;
    }

    public static char[] runSelectionSort(char[] charArr, int size)
    {
        int minValue, outerLoop, comparisonLoop;
        for (outerLoop = 0; outerLoop < size; outerLoop++)
        {
            // this assuming the first element in charArr is the minimum
            minValue = outerLoop;

            // this compares all values after the minValue passed in and finds
            // the newest minimum value
            for (comparisonLoop = outerLoop + 1; comparisonLoop < size; comparisonLoop++)
            {
                if (charArr[comparisonLoop] < charArr[minValue])
                {
                    minValue = comparisonLoop;
                }
            }

            // this places/swaps the minimum value with whatever was at
            // that indices
            if (minValue != outerLoop)
            {
                swapValues(charArr, minValue, outerLoop);
            }
        }
        return charArr;
    }

    public static char[] runShellSort(char[] charArr, int size)
    {
        int gap = size / 2;

        int outer, inner;
        char temp;

        while (gap > 0)
        {
            outer = 0;
            for (inner = gap; inner < size; inner++)
            {
                temp = charArr[inner];

                for (outer = inner; outer >= gap && charArr[outer-gap] > temp; outer = outer - gap)
                {
                    charArr[outer] = charArr[outer-gap];
                }
                charArr[outer] = temp;
            }
            gap = gap / 2;
        }

        return charArr;
    }

    private static void swapValues(char[] charArray, int indexOne,
                                   int indexOther)
    {
        char holdingValue = charArray[indexOne];

        charArray[indexOne] = charArray[indexOther];

        charArray[indexOther] = holdingValue;

    }
}
