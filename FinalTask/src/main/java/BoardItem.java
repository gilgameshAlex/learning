public enum BoardItem {
    SHIP_PART(1, "\uD83D\uDEE5"), MISSING_SHOT(2, "*"), INJURED_PART(3, "\uD83D\uDFE5"), HALO_PART(4, "\uD83D\uDFE6"), EMPTY(0, "⬜");
    private int x;
    private int y;
    private int desc;
    private String image;

    BoardItem(int desc, String image) {
        this.desc = desc;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPosition() {
        return new int[]{this.x, this.y};
    }


    @Override
    public String toString() {
        return this.image;
    }
}
