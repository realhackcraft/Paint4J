public class Pixel {
    private final int x;
    private final int y;
    private boolean hasCursor;
    private boolean isFilled;

    public Pixel(int x, int y, boolean hasCursor,) {
        this.x = x;
        this.y = y;
        this.hasCursor = hasCursor;
        isFilled = false;
    }

    public Pixel(int x, int y) {
        this(x, y, false);
    }

    // No pixel character yet
    public String printPixel() {
        if (hasCursor) {
            if (isFilled) {
                // filled pixel with cursor
                return "";
            } else {
                // unfilled pixel with cursor
                return "";
            }
        } else {
            if (isFilled) {
                // filled pixel without cursor
                return "";
            } else {
                // unfilled pixel without cursor
                return "";
            }
        }
    }

    // Getters and Setters;
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasCursor() {
        return hasCursor;
    }

    public void removeCursor() {
        hasCursor = false;
    }

    public void giveCursor() {
        hasCursor = true;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void fill() {
        isFilled = true;
    }

    public void empty() {
        isFilled = false;
    }
}
