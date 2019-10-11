public class StateDataClass implements Comparable<StateDataClass>
{
    private String state;
    private int population;

    public StateDataClass()
    {
        state = null;
        population = 0;
    }

    public StateDataClass(String stateName, int inPopulation)
    {
        state = stateName;
        population = inPopulation;
    }

    public StateDataClass(StateDataClass copiedSC)
    {
        this.state = copiedSC.state;
        this.population = copiedSC.population;
    }

    public int compareTo(StateDataClass other)
    {
        int stringIndex;
        int stringOneValue = 0, stringTwoValue = 0;
        for (stringIndex = 0; stringIndex < state.length() && stringIndex <
                other.state.length(); stringIndex++)
        {
            stringOneValue += state.charAt(stringIndex);
            stringTwoValue += other.state.charAt(stringIndex);
        }

        return stringOneValue - stringTwoValue;
    }

    public char toLowerCase(char testChar)
    {
        if (testChar >= 'A' && testChar <= 'Z' )
        {
            testChar =  (char) (testChar - 'A' + 'a');
        }
        return testChar;
    }

    public String toString()
    {
        return "State Name: "+ state +", Population: " + population;
    }
}
