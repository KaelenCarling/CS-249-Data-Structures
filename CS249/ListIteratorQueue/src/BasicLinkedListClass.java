public class BasicLinkedListClass
{
    // code for node class
    private static class NodeClass
    {
        int nodeData;
        NodeClass nextRef;

        /**
         * Internal class for nodes
         * @param data data stored inside a node
         */
        NodeClass(int data)
        {
            nodeData = data;
            nextRef = null;
        }

        /**
         * copy constructor for node class
         * @param copied node to be copied
         */
        NodeClass(NodeClass copied)
        {
            this.nodeData = copied.nodeData;
            this.nextRef = copied.nextRef;
        }
    }

    public static final int FAILED_ACCESS = -999999;
    public static final int REPLACE = 1001;
    public static final int INSERT_BEFORE = 1002;
    public static final int INSERT_AFTER = 1003;
    public static final int REMOVE = 1004;
    public static final int RETRIEVE = 1005;
    private NodeClass headRef;

    /**
     * constructor class that sets the beginning of the list to null
     */
    protected BasicLinkedListClass()
    {
        headRef = null;
    }

    /**
     * copy constructor for the basic Linked List class
     * @param copied list to be copied
     */
    protected BasicLinkedListClass(BasicLinkedListClass copied)
    {
        this.headRef = new NodeClass(copied.headRef);

        NodeClass nodeIndex = copied.headRef;
        NodeClass noded = headRef;

        while (nodeIndex.nextRef != null)
        {
            noded.nextRef = new NodeClass(nodeIndex.nextRef);
            noded = noded.nextRef;
            nodeIndex = nodeIndex.nextRef;
        }
    }

    /**
     * method that accesses a specific node and either retrieves it or removes
     * @param controlCode code to either retrieve or replace
     * @param index index being accessed
     * @return the value at that index
     */
    private int accessAtIndex(int controlCode, int index)
    {
        if (isEmpty())
        {
            return FAILED_ACCESS;
        }

        if (controlCode == RETRIEVE)
        {
            return getRefAtIndex(headRef, index).nodeData;
        }

        else if (controlCode == REMOVE)
        {
            int returnValue = getRefAtIndex(headRef, index).nodeData;

            NodeClass holdValue = headRef;

            //deletes head if head needs to be deleted
            if (index == 0)
            {
                headRef = holdValue.nextRef;
            }

            //finds node to be deleted
            holdValue = getRefAtIndex(holdValue, index);

            if (holdValue == null ||  holdValue.nextRef == null)
            {
                return FAILED_ACCESS;
            }

            NodeClass test = holdValue.nextRef.nextRef;

            holdValue.nextRef = test;

            return returnValue;
        }

        else
        {
            return FAILED_ACCESS;
        }
    }

    /**
     * clears list of nodes
     */
    protected void clear()
    {
        headRef = null;
    }

    /**
     * gets value at a specific index
     * @param accessIndex index that is having its data accessed
     * @return the value at accessIndex
     */
    protected int getAtIndex(int accessIndex)
    {
        return accessAtIndex(RETRIEVE, accessIndex);
    }

    /**
     * gets the current size of the list
     * @return
     */
    protected int getCurrentSize()
    {
        return getCurrentSizeHelper(headRef);
    }

    /**
     * recursively counts # of nodes in list
     * @param wkgRef node to start counting from
     * @return number of nodes in list
     */
    private int getCurrentSizeHelper(NodeClass wkgRef)
    {
        // condition for when the end of the list is reached or when the list
        // is empty
        if (wkgRef == null)
        {
            return 0;
        }

        return 1 + getCurrentSizeHelper(wkgRef.nextRef);
    }

    /**
     * recurively gets reference at a specific index
     * @param wkgRef node to start looking from
     * @param requestedIndex index of node to retrieve
     * @return requested node
     */
    private NodeClass getRefAtIndex(NodeClass wkgRef, int requestedIndex)
    {
        if (requestedIndex > 0)
        {
            requestedIndex--;
            return getRefAtIndex(wkgRef.nextRef, requestedIndex);
        }
        return wkgRef;
    }

    /**
     * checks to see if list is empty
     * @return returns tru if the list is empty and fals if it isn't
     */
    protected boolean isEmpty()
    {
        if (headRef == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * removes value at specific index
     * @param removeIndex index being removed
     * @return data of removed value
     */
    protected int removeAtIndex(int removeIndex)
    {
        return accessAtIndex(REMOVE, removeIndex);
    }

    /**
     * method to display list and indexes
     * @param showIndex boolean value to determine if indexes are shown
     */
    protected void runDiagnosticDisplay(boolean showIndex)
    {
        System.out.print("List: ");

        int virtualIndex;
        for (virtualIndex = 0; virtualIndex < (getCurrentSize() - 1);
             virtualIndex++)
        {
            System.out.format("|  %d |", accessAtIndex(RETRIEVE, virtualIndex));
        }
        System.out.print('|');

        System.out.print('\n');

        if (showIndex)
        {
            System.out.print("Index: ");

            for (virtualIndex = 0; virtualIndex < (getCurrentSize() - 1);
                 virtualIndex++)
            {
                System.out.format("|  %d |", virtualIndex);
            }
            System.out.print('|');
        }
    }

    /**
     * inserts or replaces node at specific point
     * @param setIndex index that the placement occurs near
     * @param newValue data to be stored in new node
     * @param replaceFlag value that determines if it replaces, places it after,
     *                    or places it before setIndex
     * @return
     */
    protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
    {
        if (isEmpty())
        {
            NodeClass newNode = new NodeClass(newValue);
            headRef = newNode;
            return true;
        }

        if (( getCurrentSize()) < setIndex || setIndex < 0)
        {
            return false;
        }

        NodeClass holdingValue;

        if (replaceFlag == REPLACE)
        {
            holdingValue = getRefAtIndex(headRef, setIndex);
            holdingValue.nodeData = newValue;
            return true;
        }
        else if (replaceFlag == INSERT_BEFORE)
        {
            int indexBefore = setIndex -1;
            holdingValue = getRefAtIndex(headRef, indexBefore);

            NodeClass newNode = new NodeClass(newValue);

            newNode.nextRef = holdingValue.nextRef;

            holdingValue.nextRef = newNode;

            return true;
        }
        else if (replaceFlag == INSERT_AFTER)
        {
            holdingValue = getRefAtIndex(headRef, setIndex);

            NodeClass newNode = new NodeClass(newValue);

            newNode.nextRef = holdingValue.nextRef;

            holdingValue.nextRef = newNode;

            return true;
        }

        else
        {
            return false;
        }

    }
}
