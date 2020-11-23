package Task_01;

public class Node {
    protected int value;
    protected Node less;
    protected Node more;

    public Node() {
        this.value = 0;
        this.less = null;
        this.more = null;
    }

    public Node(int value) {
        this.value = value;
        this.less = null;
        this.more = null;
    }

    public Node getLess() {
        return this.less;
    }

    public Node getMore() {
        return this.more;
    }

    protected void append (int value) {
        boolean needAppend = false;
        StringBuilder stringBuilder = new StringBuilder("");

        if (value < this.value) {
            stringBuilder.append(value).append(" больше, чем ").append(this.value).append("? -> нет -> уходим влево");
            System.out.println(stringBuilder.toString());
            if (this.less != null) this.less.append(value);
            else needAppend = true;
        }
        else {
            stringBuilder.append(value).append(" больше, чем ").append(this.value).append("? -> да -> уходим вправо");
            System.out.println(stringBuilder.toString());
            if (this.more != null) this.more.append(value);
            else needAppend = true;
        }
        if (needAppend) {
            Node tmp = new Node(value);
            if (value > this.value)
                this.more = tmp;
            else
                this.less = tmp;
        }
    }

    public static void appendToTree(Node root, int value)
    {
        root.append(value);
    }


    public static void appendToTree(Node root, int[] values)
    {
        for (int i : values) {
            root.append(i);
        }
    }

    public static void printTree(Node tree)
    {
        tree.printTreeRec(tree);
    }

    private int printTreeRec(Node tree)
    {
        if (tree.less != null) {
            printTreeRec(tree.less);
        }
        System.out.println(tree.value);
        if (tree.more != null) {
            printTreeRec(tree.more);
        }
        return tree.value;
    }
}
