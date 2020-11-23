package Task_01;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(20);
        //Node.printTree(root);
        /*Node.appendToTree(root,5);
        Node.appendToTree(root, 21);
        Node.appendToTree(root, 3);
        Node.appendToTree(root, 4);
        Node.appendToTree(root, 2);*/
        int[] arr = {14,11,16,5,4,8,9,15,18,23,22,27,24,150};
        Node.appendToTree(root, arr);
        Node.printTree(root);

    }
}
