public class Generic_BST_Class<GenericData extends Comparable<GenericData>>
{
    /**
     * node
     */
    private class BST_Node
    {
        private GenericData nodeData;
        BST_Node leftChildRef, rightChildRef;

        public BST_Node(GenericData inData)
        {
            leftChildRef = null;
            rightChildRef = null;
            nodeData = inData;
        }

        public BST_Node(BST_Node copied)
        {
            this.leftChildRef = copied.leftChildRef;
            this.rightChildRef = copied.rightChildRef;
            this.nodeData = copied.nodeData;
        }
    }

    /**
     * BST
     */
    private BST_Node BST_Root;

    public Generic_BST_Class()
    {
        BST_Root = null;
    }

    public void clearTree()
    {
        BST_Root = null;
    }

    public void displayInOrder()
    {
        displayInOrderHelper(BST_Root);
    }

    private void displayInOrderHelper(BST_Node localRoot)
    {
        if (localRoot.leftChildRef != null)
        {
            displayInOrderHelper(localRoot.leftChildRef);
        }

        if (localRoot.rightChildRef != null)
        {
            displayInOrderHelper(localRoot.rightChildRef);
        }

        System.out.println(localRoot.nodeData);
    }

    public void displayPostOrder()
    {
        displayPostOrderHelper(BST_Root);
    }

    private void displayPostOrderHelper(BST_Node localRoot)
    {

        System.out.println(localRoot.nodeData);

        if (localRoot.rightChildRef != null)
        {
            displayInOrderHelper(localRoot.rightChildRef);
        }

        if (localRoot.leftChildRef != null)
        {
            displayInOrderHelper(localRoot.leftChildRef);
        }
    }

    public void displayPreOrder()
    {
        displayPreOrderHelper(BST_Root);
    }

    private void displayPreOrderHelper(BST_Node localRoot)
    {
        if (localRoot.leftChildRef != null)
        {
            displayInOrderHelper(localRoot.leftChildRef);
        }

        if (localRoot.rightChildRef != null)
        {
            displayInOrderHelper(localRoot.rightChildRef);
        }

        System.out.println(localRoot.nodeData);
    }

    public void insert(GenericData inData)
    {
        insertHelper(BST_Root, inData);
    }

    private BST_Node insertHelper(BST_Node localRoot, GenericData inData)
    {
        if (localRoot == null)
        {
            return BST_Root = new BST_Node(inData);
        }

        //right side
        else if (localRoot.nodeData.compareTo(inData) > 0)
        {
            if (localRoot.rightChildRef != null)
            {
                return insertHelper(localRoot.rightChildRef, inData);
            }
            else
            {
                return localRoot.rightChildRef = new BST_Node(inData);
            }
        }

        //left side
        else if (localRoot.nodeData.compareTo(inData) < 0)
        {
            if (localRoot.leftChildRef != null)
            {
                return insertHelper(localRoot.leftChildRef, inData);
            }
            else
            {
                return localRoot.leftChildRef = new BST_Node(inData);
            }
        }
        else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        boolean returnValue = BST_Root == null;
        return returnValue;
    }

    private BST_Node removeFromMax(BST_Node maxParent, BST_Node maxLoc)
    {
        if(maxParent.nodeData.compareTo(maxLoc.nodeData) > 0 &&
                maxLoc.rightChildRef != null)
        {
            removeFromMax(maxParent, maxParent.rightChildRef);
        }

        else
        {
            maxParent.rightChildRef = maxLoc.rightChildRef;

            return maxLoc;
        }

        //default return for if things go wrong
        return null;
    }

    public GenericData removeItem(GenericData inData)
    {
        if(search(inData) == null)
        {
            return null;
        }

        else
        {
            return removeItemHelper(BST_Root, inData).nodeData;
        }
    }

    private BST_Node removeItemHelper(BST_Node localRoot, GenericData outData)
    {
        if (localRoot.nodeData == outData)
        {
            BST_Node holdingValue = removeFromMax
                    (localRoot, localRoot.rightChildRef);

            BST_Node returnValue = localRoot;

            return returnValue;
        }
        //if node data is less then search data
        else if (localRoot.nodeData.compareTo(outData) < 0)
        {
            return removeItemHelper(localRoot.leftChildRef, outData);
        }

        //if node data is more than search data
        else if (localRoot.nodeData.compareTo(outData) > 0)
        {
            return removeItemHelper(localRoot.rightChildRef, outData);
        }

        else
        {
            return null;
        }
    }

    public GenericData search(GenericData searchData)
    {
        return searchHelper(BST_Root, searchData);
    }

    private GenericData searchHelper(BST_Node localRoot, GenericData searchData)
    {
        // in node data is equal
        if(localRoot.nodeData.compareTo(searchData) == 0)
        {
            return localRoot.nodeData;
        }
        //if node data is less then search data
        else if (localRoot.nodeData.compareTo(searchData) < 0)
        {
            return searchHelper(localRoot.leftChildRef, searchData);
        }

        //if node data is more than search data
        else if (localRoot.nodeData.compareTo(searchData) > 0)
        {
            return searchHelper(localRoot.rightChildRef, searchData);
        }

        else
        {
            return null;
        }
    }





}
