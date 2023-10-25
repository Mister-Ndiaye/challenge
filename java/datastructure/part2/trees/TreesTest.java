package part2.trees;

public class TreesTest {

    private Node root;

    public void insert(int value){
        Node newNode = new Node(value);
        Node current = root;
        if (isEmpty())
        {
            root=newNode;
            return;
        }
        while (true){
            if(current!=null)
                return;
            if(current.left.value<value)
            {
                current = current.left;
            }else{
                current = current.right;
            }

        }

    }
    private boolean isEmpty(){
        return root != null;
    }
    private class Node{
        private Node left;
        private Node right;
        private int value;
        private Node(int value){
            this.value=value;
        }
    }
}
