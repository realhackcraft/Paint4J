public class Pixel {
    private boolean hasCursor;
    private boolean isFilled;

    public Pixel(boolean hasCursor) {
        this.hasCursor = hasCursor;
        isFilled = false;
    }

    public Pixel() {
        this(false);
    }

    // No pixel character yet
    public String returnPixel() {
        if (hasCursor) {
            if (isFilled) {
                // filled pixel with cursor
                return "▣";
            } else {
                // unfilled pixel with cursor
                return "□";
            }
        } else {
            if (isFilled) {
                // filled pixel without cursor
                return "█";
            } else {
                // unfilled pixel without cursor
                return " ";
            }
        }
    }

    // Getters and Setters;
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
