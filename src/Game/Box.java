package Game;

/**
 * Represents boxes in dots and boxes
 */
public class Box {

    /**
     * index of first dimension of Box's position
     */
    private final int xVal; // x index ( i ) in the board.

    /**
     * index of second dimension of Box's position
     */
    private final int yVal; // y index ( j ) in the borad.

    /**
     * Represents all of the possible sides in the box.
     */
    public enum Side {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    /**
     * North edge of box, true is claimed, false if unclaimed
     */
    private boolean north;

    /**
     * South edge of box, true is claimed, false if unclaimed
     */
    private boolean south;

    /**
     * East edge of box, true is claimed, false if unclaimed
     */
    private boolean east;

    /**
     * West edge of box, true is claimed, false if unclaimed
     */
    private boolean west;

    /**
     * integer showing ownership, 0:None, 1:Player1, 2:Player2
     */
    private int claimed;

    /**
     * number of claimed sides
     */
    private int claimedSides;

    /**
     * Constructor for Box
     *
     * @param xVal the x position in the board
     * @param yVal the y position in the board.
     */
    public Box(int xVal, int yVal) {
        this.xVal = xVal;
        this.yVal = yVal;
        north = false;
        south = false;
        east = false;
        west = false;
        claimed = 0;
    }

    /**
     * Returns the x index in the board ( i )
     *
     * @return int representing the x index in the board.
     */
    public int getxVal() {
        return xVal;
    }

    /**
     * Returns the y index in the board ( j )
     *
     * @return int representing the y index in the board.
     */
    public int getyVal() {
        return yVal;
    }

    /**
     * returns integer corresponding to the owner of this box
     *
     * @return
     */
    public int getClaimedSides() {
        return this.claimedSides;
    }

    /**
     * Returns the state of the specified side.
     *
     * @param s The side to check.
     * @return true if the side is claimed; otherwise, false.
     */
    public boolean getSide(Side s) {
        switch (s) {
            case EAST:
                return this.east;
            case WEST:
                return this.west;
            case NORTH:
                return this.north;
            case SOUTH:
                return this.south;
            default:
                return false;
        }
    }

    /**
     * Sets an unchecked side to be claimed.
     *
     * @param s The side that is being claimed.
     */
    public void setSide(Side s) {
        this.claimedSides++;
        if (!getSide(s)) {
            if (s == Side.EAST) {
                east = true;
            }
            if (s == Side.WEST) {
                west = true;
            }
            if (s == Side.NORTH) {
                north = true;
            }
            if (s == Side.SOUTH) {
                south = true;
            }
        }

    }

    /**
     * Checks if all four sides of this box have been claimed, if so, claims the box for the claiming player
     * then returns the player that claimed the box.
     *
     * @param player The player that claimed the box.
     * @return 0 if unclaimed, 1 if player1, 2 if player2
     */
    public void checkClaimed(Users player) {
        if (this.claimedSides == 4) {
            //Based on which player's turn it is.
            if (player == Users.PLAYER1) {
                this.claimed = 1;
            } else {
                this.claimed = 2;
            }
        }
    }

    /**
     * Returns the user that has claimed this box
     *
     * @return 0, 1, or 2
     */
    public int getClaimed() {
        return this.claimed;
    }

    /**
     * This gives the claimed side to player 1 or player 2
     *
     * @param x a 1 for Player 1 or 2 for Player 2
     */
    public void setClaimed(int x) {
        this.claimed = x;
    }


    /**
     * Override of toString(), prints display of box and surrounding edges
     *
     * @return a String
     */
    @Override
    public String toString() {
        String outString = "*";
        if (this.north) {
            outString += "-*";
        } else {
            outString += " *";
        }
        outString += "\n";
        if (this.west) {
            outString += "|" + this.claimed;
        } else {
            outString += " " + this.claimed;
        }
        if (this.east) {
            outString += "|";
        } else {
            outString += " ";
        }
        outString += "\n*";
        if (this.south) {
            outString += "-*";
        } else {
            outString += " *";
        }
        return outString;
    }

    /**
     * first test case, expected result:
     * * *
     * 0
     * * *
     * * *
     * |0
     * *-*
     * *-*
     * |0|
     * *-*
     */
    public static void test1() {
        Box b = new Box(0, 0);
        System.out.println(b);
        b.south = true;
        b.west = true;
        System.out.println(b);
        b.north = true;
        b.east = true;
        int n = b.getClaimed();
        System.out.println(b);
    }

    /**
     * Test function for board.
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        test1();
    }
}


