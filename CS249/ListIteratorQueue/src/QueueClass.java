
public class QueueClass
{
    private BasicLinkedListClass queueData;

    /**
     * constructor which initializes a new linked list class
     */
    public QueueClass()
    {
        queueData = new BasicLinkedListClass();
    }

    /**
     * copy constructor which initializes a copy of the queueclass
     * @param copied queue class thats being copied
     */
    public QueueClass(QueueClass copied)
    {
        copied.queueData = new BasicLinkedListClass();
    }

    /**
     * clears queue class of data
     */
    public void clear()
    {
        queueData.clear();
    }

    /**
     * displays queue class
     */
    public void displayQueue()
    {
        System.out.print("Queue Tail -> ");
        int virtualIndex;
        for (virtualIndex = 0; virtualIndex < queueData.getCurrentSize();
             virtualIndex++)
        {
            System.out.print(queueData.getAtIndex(virtualIndex) + ", ");
        }
        System.out.print("<- Queue Front");
    }

    /**
     * adds new value to queue
     * @param newValue value to be added
     */
    public void enqueue(int newValue)
    {
        // uses zero because its the bottom index
        queueData.setAtIndex(0, newValue, queueData.INSERT_BEFORE);
    }

    /**
     * pulls value from queue
     * @return pulled value
     */
    public int dequeue()
    {
        int topIndex = queueData.getCurrentSize()-1;
       return queueData.removeAtIndex(topIndex);
    }

    /**
     * checks to see if queue is empty
     * @return returns true if it is empty and false if it isn't
     */
    public boolean isEmpty()
    {
        return queueData.isEmpty();
    }

    /**
     * looks at the value at the front of the queue
     * @return
     */
    public int peekFront()
    {
        return queueData.getAtIndex(queueData.getCurrentSize()-1);
    }
}
