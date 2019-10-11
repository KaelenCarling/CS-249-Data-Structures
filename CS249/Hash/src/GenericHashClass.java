public class GenericHashClass <GenericData extends Comparable<GenericData>>
{
	private int DEFAULT_TABLE_SIZE = 10;
	int ITEM_NOT_FOUND = -1;
	public static final int LINEAR_PROBING = 101;
	public static final int QUADRATIC_PROBING = 102;
	private int tableSize;
	int probeFlag;
	private Object[] tableArray;

	/**
	 * default constructor
	 */
	public GenericHashClass()
	{
		tableSize = DEFAULT_TABLE_SIZE;
		probeFlag = LINEAR_PROBING;
		tableArray = new Object[tableSize];
	}

	/**
	 * constructor that allows you to sel the probe flag
	 * @param inProbeFlag flag for either quadratic or linear probing
	 */
	public GenericHashClass(int inProbeFlag)
	{
		tableSize = DEFAULT_TABLE_SIZE;
		probeFlag = inProbeFlag;
		tableArray = new Object[tableSize];
	}

	/**
	 * constructor that allows you to sey table size as well as probe flag
	 * @param inTableSize size of hash table you wish to create
	 * @param inProbeFlag flag for either quadratic or linear probing
	 */
	public GenericHashClass(int inTableSize, int inProbeFlag)
	{
		tableSize = inTableSize;
		probeFlag = inProbeFlag;
		tableArray = new Object[tableSize];
	}

	/**
	 * adds item to the hash table
	 * @param newItem item that you wish to be added
	 * @return the boolean result of adding the data to the hash table
	 */
	public boolean addItem(GenericData newItem)
	{
		int newItemHash = generateHash(newItem);
		int itemIndex = newItemHash;
		int indexCounter = 0;

		GenericData arrayData;

		System.out.print( "Object: " + newItem.toString() + " Object Hash: " + generateHash(newItem));

		while (itemIndex < tableSize)
		{
			arrayData = (GenericData) tableArray[itemIndex];
			if(arrayData == null)
			{
				tableArray[itemIndex] = newItem;
				System.out
						.print( ", index: " + itemIndex+ " probed index: " +
								newItemHash + "\n" );
				return true;
			}

			if (newItem.compareTo(arrayData) == 0)
			{
				tableArray[itemIndex] = newItem;
				System.out
						.print( ", index: " + itemIndex+ " probed index: " +
								newItemHash + "\n" );
				return true;
			}

			indexCounter++;

			if (probeFlag == LINEAR_PROBING)
			{
				itemIndex++;
			}

			else if (probeFlag == QUADRATIC_PROBING)
			{
				itemIndex = newItemHash+toPower(indexCounter, 2);

				/* not necessary due to the item index modulation added
				if (itemIndex > (tableSize - 1))
				{
					itemIndex = itemIndex - tableSize;
				}
				*/
			}
			itemIndex = itemIndex % tableSize;
		}
		return false;
	}

	/**
	 * clears hashtable of data
	 */
	public void clearHashTable()
	{
		int hashIndex;
		for (hashIndex = 0; hashIndex < tableSize; hashIndex++)
		{
			tableArray[hashIndex] = null;
		}
	}

	/**
	 * finds item's index location
	 * @param searchItem item that is being looked for
	 * @return the indices which it is located. if it does exist
	 */
	public GenericData findItem(GenericData searchItem)
	{
		int index = findItemIndex(searchItem);

		if (index != ITEM_NOT_FOUND)
		{
			return (GenericData)tableArray[index];
		}

		else
		{
			return null;
		}
	}

	/**
	 * find item index helper
	 * @param searchItem item that is being looked for
	 * @return the index that the item is looked at
	 */
	private int findItemIndex(GenericData searchItem)
	{
		int indexCounter = 0;
		int searchItemHash = generateHash(searchItem);
		int itemIndex = searchItemHash;

		GenericData arrayData;

		while (itemIndex < tableSize)
		{
			arrayData = (GenericData) tableArray[itemIndex];
			if (arrayData != null && searchItem.compareTo(arrayData) == 0)
			{
				return itemIndex;
			}

			indexCounter++;
			if (probeFlag == LINEAR_PROBING)
			{
				itemIndex++;
			}
			else
			{
				itemIndex = searchItemHash+toPower(indexCounter, 2);
				/* not necessary due to the item index modulation added
				if (itemIndex > (tableSize - 1))
				{
					itemIndex = itemIndex - tableSize;
				}
				*/

			}
			itemIndex %= tableSize;
		}

		return ITEM_NOT_FOUND;
	}

	public int generateHash(GenericData item)
	{
		int hash = item.hashCode()% tableSize;

		while (hash > tableSize)
		{
			hash = item.hashCode()% tableSize;
		}
		return hash;
	}

	public GenericData removeItem(GenericData toBeRemoved)
	{
		int removeIndex = findItemIndex(toBeRemoved);
		GenericData toBeRemovedValue;

		if (removeIndex != ITEM_NOT_FOUND)
		{
			toBeRemovedValue = (GenericData) tableArray[removeIndex];
			tableArray[removeIndex] = null;
			return toBeRemovedValue;
		}
		else
		{
			return null;
		}
	}

	public String showHashTableStatus()
	{
		int hashTableIndex;
		int emptyBinNum = 0;
		int maxBinCount = 0;
		int minBinCount = tableSize;
		int minCounter = 0, maxCounter = 0;
		String tableString = "";
		String hashString;

		for (hashTableIndex = 0; hashTableIndex < tableSize; hashTableIndex++)
		{
			if (tableArray[hashTableIndex] == null)
			{
				emptyBinNum++;
				maxCounter = 0;
				minCounter = 0;
				tableString += "N";
			}
			else
			{
				tableString += "D";

				maxCounter++;
				minCounter++;
				if(maxCounter >= maxBinCount)
				{
					maxBinCount = maxCounter;
				}
				if(minCounter < minBinCount)
				{

					minBinCount = minCounter;
				}
			}
		}

		hashString = "Hash Table Status: " + tableString + '\n' + '\n'
				+ "Minimum contiguous bins: " + minBinCount+ "\n"
				+ "Maximum contiguous bins:" + maxBinCount+"\n"
				+ "	Number of empty bins:" + emptyBinNum;

		return hashString;
	}

	private int toPower(int base, int exponent)
	{
		if (exponent > 0)
		{
			return base * toPower(base, exponent - 1);
		}

		return 1;
	}
}
