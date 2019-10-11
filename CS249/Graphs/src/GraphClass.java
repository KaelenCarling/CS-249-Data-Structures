//package p11_package;

/**
 * Simple class for managing vertices and edges in a graph
 * 
 * @author MichaelL
 *
 */
public class GraphClass
   {
    /**
     * default vertex capacity
     * <p>
     * Note: Limited to number of upper case letters in alphabet
     */
    private final int VERTEX_CAPACITY = 26;
    
    /**
     * constant indication of vertex not in list
     */
    private final int NOT_IN_LIST = -1;
    
    /**
     * constant space character
     * 
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * size of vertex array
     */
    private int vertexListSize;
    
    /**
     * array of vertices
     */
    private VertexNode[] vertexList;
    
    /**
     * Default constructor
     */
    public GraphClass()
       {
        vertexListSize = 0;

        vertexList = new VertexNode[VERTEX_CAPACITY];
       }
    
    /**
     * Gets complete vertex node and data using the adjacent node data
     * 
     * @param adjNode AdjacentNode data provided
     * 
     * @return VertexNode data found in array
     */
    private VertexNode adjToVertex( AdjacentNode adjNode )
       {
           int nodeVertex = vertexInList(adjNode.getVertex());
           if (nodeVertex == NOT_IN_LIST)
           {
               return null;
           }
           else
           {
               return vertexList[nodeVertex];
           }
       }
    
    /**
     * Breadth-First Search (BFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showQueue boolean flag to control display
     * of queue during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String BFS( char startVertex, boolean showQueue )
       {
           int vertexIndex = vertexInList(startVertex);
           VertexNode holdingNode;
           String output = "";
           VertexQueue vQueue = new VertexQueue();
           AdjacentNode adjacentHoldingValue;
           VertexNode vertexHoldingValue;

           if (vertexIndex != NOT_IN_LIST)
           {
               holdingNode = vertexList[vertexIndex];
               holdingNode.setVisited();
               vQueue.enqueue(holdingNode);
               output = holdingNode.getVertex() + "" + SPACE;

               if (showQueue)
               {
                   System.out.println("Queue:" + vQueue.toString());
               }

               while (!vQueue.isEmpty())
               {
                   holdingNode = vQueue.dequeue();
                   adjacentHoldingValue = holdingNode.getFirstAdjacency();

                   while (adjacentHoldingValue != null)
                   {
                       vertexHoldingValue = adjToVertex(adjacentHoldingValue);

                       if (vertexHoldingValue != null && !vertexHoldingValue.hasBeenVisited())
                       {
                           vertexHoldingValue.setVisited();
                           vQueue.enqueue(vertexHoldingValue);

                           if(showQueue)
                           {
                               System.out.println("vQueue: " +
                                       vertexHoldingValue.getVertex() + SPACE);
                           }
						   adjacentHoldingValue =
							   holdingNode.getNextAdjacency();
                       }
					   //adjacentHoldingValue = holdingNode.getNextAdjacency();
                   }
               }
           }

           return output;
       }
    
    /**
     * Clears all vertex visited flags; for use after completion of BFS, DFS
     */
    public void clearVisitedFlags()
       {
           int nodeIndex;
           for (nodeIndex = 0; nodeIndex < vertexListSize; nodeIndex++)
           {
               vertexList[nodeIndex].unSetVisited();
           }
       }
    
    /**
     * Depth-First Search (DFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showStack boolean flag to control display
     * of stack during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String DFS( char startVertex, boolean showStack )
       {
        // Implement method: +6 pts
           // use stack for DFS

        return "";
       }
    
    /**
     * Generates a list of the vertices with their adjacent vertices
     */
    public void generateAdjacencyLists()
       {

       }
    
    /**
     * Generates an adjacency matrix table 
     * that displays weights between vertices
     */
    public void generateAdjacencyMatrix()
       {
           //System.out.print('\n');
           printChars(6, SPACE);
           int printIndex;
           for (printIndex = 0; printIndex < vertexListSize; printIndex++)
           {
               System.out.print(vertexList[printIndex].getVertex() + SPACE);
           }
       }
    
    /**
     * Inserts vertex, adjacent vertex, and weight into array alphabetically
     * <p>
     * Note: Uses insertion sort strategy
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of insertion;
     * false if vertex array is full, true otherwise
     */
    private boolean insertVertex( char vertex, char adjVertex, int weight )
       {
        VertexNode newVertex = new VertexNode(vertex, adjVertex, weight);

        if (VERTEX_CAPACITY == vertexListSize-1)
        {
            return false;
        }
        
        else
        {
            vertexList[vertexListSize] = newVertex;
            vertexListSize++;
            return true;
        }
       }
    
    /**
     * Recursive method that prints
     * a specified number of specified characters
     * 
     * @param numChars integer number of characters to print
     * 
     * @param outChar character value to be printed
     */
    void printChars( int numChars, char outChar )
       {
        if (0 < numChars)
        {
            System.out.print(outChar);

            numChars--;

            printChars(numChars, outChar);
        }
       }
    
    /**
     * Sets vertex with adjacency
     * <p>
     * Note: Adds new vertex as needed;
     * otherwise adds adjacent vertex and weight to existing vertex
     * <p>
     * Note: Adds vertices in both directions (e.g., A with B as adjacency,
     * and B with A as adjacency)
     * <p>
     * Uses insertVertex to minimize excessive coding
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of action,
     * false if vertex array is full, true otherwise
     */
    public boolean setVertex( char vertex, char adjVertex, int weight )
       {
           int vertexIndex = vertexInList(vertex);

           if (vertexListSize != VERTEX_CAPACITY)
           {
               if (vertexIndex == NOT_IN_LIST)
               {
                   insertVertex(vertex, adjVertex, weight);
                   return true;
               }

               else
               {
                   vertexList[vertexIndex].addAdjacentVertex(adjVertex, weight);
                   return true;
               }
           }
           return false;
       }          

    /**
     * Tests for vertex in list
     * 
     * @param testVertex character vertex to search for
     * 
     * @return integer index if vertex found,
     * constant NOT_IN_LIST otherwise
     */
    private int vertexInList( char testVertex )
       {
           int nodeIndex;
           for (nodeIndex = 0; nodeIndex < vertexListSize; nodeIndex++)
           {
               if (vertexList[nodeIndex].getVertex() == testVertex)
               {
                   return nodeIndex;
               }
           }
           return NOT_IN_LIST;
       }
   }


