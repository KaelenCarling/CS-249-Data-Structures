public class ArrayHeapClass
{
	public final int DEFAULT_ARRAY_CAPACITY = 10;
	private StudentClass[] heapArray;
	private int arraySize;
	private int arrayCapacity;
	private boolean displayFlag;

	public ArrayHeapClass()
	{
		arrayCapacity = DEFAULT_ARRAY_CAPACITY;
		displayFlag = false;
		arraySize = 0;
		heapArray = new StudentClass[arrayCapacity];

	}

	public ArrayHeapClass(ArrayHeapClass copied)
	{
		this.arraySize = copied.arraySize;
		this.arrayCapacity = copied.arrayCapacity;
		this.displayFlag = copied.displayFlag;

		this.heapArray = new StudentClass[this.arrayCapacity];

		int heapIndex;
		for (heapIndex = 0; heapIndex < copied.arraySize; heapIndex++)
		{
			this.heapArray[heapIndex] = new StudentClass(copied.heapArray[heapIndex]);
		}
	}

	public void addItem(StudentClass newItem)
	{
		checkForResize();
		heapArray[arraySize] = newItem;
		if (displayFlag)
		{
			System.out.println("Adding new student: " + newItem.toString());
		}
		bubbleUpArrayHeap(arraySize);
		arraySize++;

	}

	private void bubbleUpArrayHeap(int currentIndex)
	{
		StudentClass holdingStudent;
		int parentNodeIndex = (currentIndex - 1) / 2;

		if (currentIndex != 0)
		{
			if (heapArray[currentIndex].compareTo(
					heapArray[parentNodeIndex]) > 0)
			{
				if (displayFlag)
				{
					System.out.println("    - Bubble up:");
					System.out.println("        - Swapping parent: " +
							heapArray[parentNodeIndex] + " with child: " +
							heapArray[currentIndex]);
				}
				holdingStudent = heapArray[currentIndex];
				heapArray[currentIndex] = heapArray[parentNodeIndex];
				heapArray[parentNodeIndex] = holdingStudent;
				bubbleUpArrayHeap(parentNodeIndex);
			}
		}

	}

	private void checkForResize()
	{
		if (arraySize == arrayCapacity)
		{
			arrayCapacity = arrayCapacity * 2;

			StudentClass[] newArray = new StudentClass[arrayCapacity];

			int heapIndex;
			for (heapIndex = 0; heapIndex < arraySize; heapIndex++)
			{
				newArray[heapIndex] = heapArray[heapIndex];
			}

			heapArray = newArray;
		}
	}

	public boolean isEmpty()
	{
		boolean sizeCheck = arraySize == 0;
		return sizeCheck;
	}

	public StudentClass removeItem()
	{
		StudentClass returnNode = heapArray[0];

		heapArray[0] = heapArray[arraySize - 1];
		arraySize--;

		trickleDownArrayHeap(0);

		return returnNode;
	}

	public void setDisplayFlag(boolean setState)
	{
		displayFlag = setState;
	}

	public void showArray()
	{
		int printIndex;
		for (printIndex = 0; printIndex < arraySize; printIndex++)
		{
			System.out.println(heapArray[printIndex].toString());
		}
	}

	private void trickleDownArrayHeap(int currentIndex)
	{
		StudentClass holdingStudent;
		int leftChildNodeIndex = (currentIndex * 2) + 1;
		int rightChildNodeIndex = (currentIndex * 2) + 2;

		if (leftChildNodeIndex < arraySize && rightChildNodeIndex < arraySize)
		{
			if (heapArray[currentIndex].compareTo(
					heapArray[leftChildNodeIndex]) < 0)
			{
				/*
				if (displayFlag)
				{
					System.out.println("    - Trickle down:");
					System.out.println("        - Swapping right child: " +
							heapArray[rightChildNodeIndex] + " with parent: " +
							heapArray[currentIndex]);
				}
				 */
				//swaps the two students
				holdingStudent = heapArray[currentIndex];
				heapArray[currentIndex] = heapArray[leftChildNodeIndex];
				heapArray[leftChildNodeIndex] = holdingStudent;

				trickleDownArrayHeap(leftChildNodeIndex);
			}
			else if (heapArray[currentIndex].compareTo(heapArray
					[rightChildNodeIndex]) < 0)
			{
				/*
				if (displayFlag)
				{
					System.out.println("    - Trickle down:");
					System.out.println("        - Swapping left child: " +
							heapArray[rightChildNodeIndex] + " with parent: " +
							heapArray[currentIndex]);
				}

				 */
				//swaps the two students
				holdingStudent = heapArray[currentIndex];
				heapArray[currentIndex] = heapArray[rightChildNodeIndex];
				heapArray[rightChildNodeIndex] = holdingStudent;

				trickleDownArrayHeap(rightChildNodeIndex);
			}
		}
	}
}
