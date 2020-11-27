public enum Ship {
    SHIP_1(1, 4), SHIP_2(2, 3), SHIP_3(3, 1), SHIP_4(4, 1);
    private int size;
    private int count;
    private String desc;

    Ship(int size, int count) {
        this.size = size;
        this.count = count;
        switch (size) {
            case 1:
                this.desc = "одно";
                break;
            case 2:
                this.desc = "двух";
                break;
            case 3:
                this.desc = "трех";
                break;
            case 4:
                this.desc = "четырех";
                break;
        }
        this.desc += "палубного";
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public String getDesc() {
        return desc;
    }
}
