public class BattleShipGameClass
{
    public static final char AIRCRAFT_CARRIER = 'A';
    private final int AIRCRAFT_CARRIER_LENGTH = 5;
    private int arrayHeight;
    private int arrayWidth;
    public static final char BATTLESHIP = 'B';
    private final int BATTLESHIP_LENGTH = 4;
    public static final int COMPUTER = 103;
    private ShipClass[][] computerArray;
    public static final char CRUISER = 'C';
    private final int CRUISER_LENGTH = 3;
    public static final char DESTROYER = 'D';
    private final int DESTROYER_LENGTH = 2;
    public static final char FRIGATE = 'F';
    private final int FRIGATE_LENGTH = 1;
    public static final char HORIZONTAL = 'H';
    public static final int HUMAN = 102;
    private ShipClass[][] humanArray;
    private final char SPACE = ' ';
    public static final char VERTICAL = 'V';

    public BattleShipGameClass(int height, int width)
    {
        arrayHeight = height;
        arrayWidth = width;
        humanArray = new ShipClass[arrayHeight][arrayWidth];
        computerArray = new ShipClass[arrayHeight][arrayWidth];

        for (int xRow = 0; xRow < arrayHeight; xRow++)
        {
            for (int yColumn = 0; yColumn < arrayWidth; yColumn++)
            {
                humanArray[xRow][yColumn] = new ShipClass();
                computerArray[xRow][yColumn] = new ShipClass();
            }
        }
    }

    public BattleShipGameClass(BattleShipGameClass copied)
    {
        for (int xRow = 0; xRow < copied.arrayHeight; xRow++)
        {
            for (int yColumn = 0; yColumn < copied.arrayWidth; yColumn++)
            {
                this.humanArray[xRow][yColumn] =
                        new ShipClass(copied.humanArray[xRow][yColumn]);
                this.computerArray[xRow][yColumn] =
                        new ShipClass(copied.computerArray[xRow][yColumn]);
            }
        }
    }

    private boolean checkShipLetter(char testLetter)
    {

        testLetter = toUpper(testLetter);
        boolean ACTest = testLetter == AIRCRAFT_CARRIER;
        boolean BSTest = testLetter == BATTLESHIP;
        boolean CTest = testLetter == CRUISER;
        boolean Dtest = testLetter == DESTROYER;
        boolean FRGTest = testLetter == FRIGATE;

        return ACTest || BSTest || CTest || Dtest || FRGTest;
    }

    public boolean computerFiresMissile()
    {
        boolean missFlag = false;
        int maxXPos = arrayHeight -1;
        int maxYPos = arrayHeight -1;
        int xPos = getRandBetween(0, maxXPos);
        int yPos = getRandBetween(0, maxYPos);

        do
        {
            if (isMissInArray(COMPUTER, xPos, yPos))
            {
                missFlag = true;
                xPos = getRandBetween(0, maxXPos);
                yPos = getRandBetween(0, maxYPos);
            }
        } while (missFlag);

        return fireMissile(COMPUTER, xPos, yPos);
    }

    public void displayFields(int displayState)
    {
        printCentered("HUMAN", arrayWidth);
        System.out.print("\t");
        printCentered("COMPUTER", arrayWidth);
        System.out.print("\n");

        for (int yCor = 0; yCor < arrayWidth; yCor++)
        {
            for (int humanXCor = 0; humanXCor < arrayHeight; humanXCor++)
            {
                System.out.print(humanArray[yCor][humanXCor].getLocationLetter(displayState));
                //System.out.print("+");
            }

            System.out.print("\t");

            for (int compXCor = 0; compXCor < arrayHeight; compXCor++)
            {
                System.out.print(computerArray[yCor][compXCor].getLocationLetter(displayState));
            }
            System.out.print("\n");
        }
    }

    public boolean fireMissile(int player, int xPos, int yPos)
    {
        boolean returnValue;

        if (player == HUMAN)
        {
            if (computerArray[yPos][xPos].getLocationLetter
                    (ShipClass.HIDDEN_STATE) != ShipClass.BACKGROUND_LETTER &&
                    computerArray[yPos][xPos].getLocationLetter
                            (ShipClass.HIDDEN_STATE) != ShipClass.MISSED_LETTER)
            {
                computerArray[yPos][xPos].updateLocationState(ShipClass.EXPOSED_STATE);
                //computerArray[yPos][xPos].getLocationLetter(ShipClass.EXPOSED_STATE);
                returnValue = true;
            }
            else
            {
                computerArray[yPos][xPos].updateLocationState(ShipClass.EXPOSED_STATE, ShipClass.MISSED_LETTER);
                returnValue = false;
            }
        }
        else
        {
            if (humanArray[yPos][xPos].getLocationLetter
                    (ShipClass.HIDDEN_STATE) != ShipClass.BACKGROUND_LETTER &&
                    humanArray[yPos][xPos].getLocationLetter
                            (ShipClass.HIDDEN_STATE) != ShipClass.MISSED_LETTER)
            {
                humanArray[yPos][xPos].updateLocationState(ShipClass.EXPOSED_STATE);
                returnValue = true;
            }
            else
            {
                humanArray[yPos][xPos].updateLocationState(ShipClass.EXPOSED_STATE, ShipClass.MISSED_LETTER);
                returnValue = false;
            }
        }


        return returnValue;
    }

    private int getRandBetween(int low, int high)
    {
        return (int) (Math.random() * ((high - low) + 1));
        //can use this for characters too. just cast to int and make it between and A and E. then if statement so if it is E have it ++
    }

    public int getScore(int player)
    {
        int returnScore = 0;

        for (int yValue = 0; yValue < arrayHeight; yValue++)
        {
            for (int xValue = 0; xValue < arrayWidth; xValue++)
            {
                if (player == HUMAN)
                {
                    //problematic section
                    if (computerArray[yValue][xValue].getLocationLetter
                            (ShipClass.EXPOSED_STATE)
                            != ShipClass.BACKGROUND_LETTER
                            && computerArray[yValue][xValue].getLocationLetter
                            (ShipClass.EXPOSED_STATE)
                            != ShipClass.MISSED_LETTER)
                    {
                        returnScore += 1;
                    }
                }

                else
                {
                    if (humanArray[yValue][xValue].getLocationLetter(ShipClass.EXPOSED_STATE)
                            != ShipClass.BACKGROUND_LETTER && humanArray[yValue][xValue].getLocationLetter(ShipClass.EXPOSED_STATE)
                            != ShipClass.MISSED_LETTER)
                    {
                        returnScore += 1;
                    }
                }
            }
        }
        return returnScore;
    }

    private int getShipLength(char typeOfShip)
    {
        int returnValue = 0;
        typeOfShip = toUpper(typeOfShip);

        switch (typeOfShip)
        {
            case AIRCRAFT_CARRIER:
                returnValue = AIRCRAFT_CARRIER_LENGTH;
                break;

            case BATTLESHIP:
                returnValue = BATTLESHIP_LENGTH;
                break;

            case CRUISER:
                returnValue = CRUISER_LENGTH;
                break;

            case DESTROYER:
                returnValue = DESTROYER_LENGTH;
                break;

            case FRIGATE:
                returnValue = FRIGATE_LENGTH;
                break;
        }
        return returnValue;
    }

    public String getShipName(char typeOfShip)
    {
        String returnString = "";
        switch (typeOfShip)
        {
            case AIRCRAFT_CARRIER:
                returnString = "Aircraft Carrier";
                break;

            case BATTLESHIP:
                returnString = "Battleship";
                break;

            case CRUISER:
                returnString = "Cruiser";
                break;

            case DESTROYER:
                returnString = "Destroyer";
                break;

            case FRIGATE:
                returnString = "Frigate";
                break;
        }
        return returnString;
    }

    private boolean isMissInArray(int player, int xPos, int yPos)
    {
        if (player == HUMAN && humanArray[yPos][xPos].getLocationLetter
                (ShipClass.HIDDEN_STATE) == ShipClass.MISSED_LETTER)
        {
            return true;
        }
        else if (player == COMPUTER &&
                computerArray[yPos][xPos].getLocationLetter
                        (ShipClass.HIDDEN_STATE) == ShipClass.MISSED_LETTER)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean placeShip(char shipType, int player, int xPos,
                             int yPos, char orientation)
    {
        shipType = toUpper(shipType);
        orientation = toUpper(orientation);

        if (!checkShipLetter(shipType))
        {
            return false;
        }

        try
        {
            if (orientation == VERTICAL)
            {
                for (int yPosShift = 0; yPosShift < getShipLength(shipType);
                     yPosShift++)
                {
                    if (player == HUMAN)
                    {
                        humanArray[yPos][xPos].updateLocationState
                                (ShipClass.HIDDEN_STATE, shipType);
                    }

                    else if (player == COMPUTER)
                    {
                        computerArray[yPos][xPos].updateLocationState
                                (ShipClass.HIDDEN_STATE, shipType);
                    }
                    yPos = yPos + 1;
                }
                return true;
            }
            else if (orientation == HORIZONTAL)
            {
                for (int xPosShift = 0; xPosShift < getShipLength(shipType);
                     xPosShift++)
                {
                    if (player == HUMAN)
                    {
                        humanArray[yPos][xPos].updateLocationState
                                (ShipClass.HIDDEN_STATE, shipType);
                    }

                    else if (player == COMPUTER)
                    {
                        computerArray[yPos][xPos].updateLocationState
                                (ShipClass.HIDDEN_STATE, shipType);
                    }
                    xPos = xPos + 1;
                }
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    private void printCentered(String toPrint, int blockSize)
    {
        // can use string.length for this method
        int spaceAmount = (blockSize - toPrint.length()) / 2;

        printChars(spaceAmount, SPACE);

        System.out.print(toPrint);

        printChars(spaceAmount, SPACE);
    }


    private void printChars(int numChars, char outChar)
    {
        System.out.print(outChar);
        numChars--;
        if (numChars <= 0){
            return;
        }
        printChars(numChars, outChar);
    }

    public void setComputerShips(int numShips)
    {
        char shipType, orientation;
        int xPos, yPos;
        // doesn't match the types that user put in. randomly picks ships
        do
        {
            xPos = getRandBetween(0, arrayWidth);
            yPos = getRandBetween(0, arrayHeight);
            //shipType = (char) getRandBetween(('A'-'0'), ('E' - '0'));
            shipType = (char)(getRandBetween(0, 4)+ 'A');

            if (shipType == 'E')
            {
                shipType = (char) (shipType + 1);
            }

            orientation = (char) (getRandBetween(0,1) + 'H');
            if (orientation != HORIZONTAL)
            {
                orientation = VERTICAL;
            }
            //shipType = (char) (shipTypeNum);
            if (placeShip(shipType, COMPUTER, xPos, yPos, orientation))
            {
                numShips--;
            }
            System.out.println("placing " + shipType + " at " + xPos + ',' + yPos + " with a position of " + orientation);
            System.out.println(numShips);
        }
        while (numShips > 0 );
    }

    private char toUpper(char upperChar)
    {
        if (upperChar >= 'a' && upperChar <= 'z')
        {
            upperChar = (char) (upperChar - 'a' + 'A');
        }

        return upperChar;
    }

}

