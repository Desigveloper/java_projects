package boats;

public class Boat {
    private int length;

    public void setLength(int len) {
        this.length = len;
    }

    /**
     * Retrieves the length of the boat.
     *
     * @return         the length of the boat
     */
    public int getLength() {
        return this.length;
    }

    public void move() {
        System.out.print("drift ");
    }
}
