
class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

}

class BinarySearchTree {

    Node root;

    /*
    * we need to keep reference of the parent node while inserting data and only insert to
    * parent.right or parent.left rather than directly inserting to current
    * */
    public void insert(int data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        boolean flag = true;
        while(flag) {
            Node parent = current;
            if(data < current.data) {
                current = parent.left;
                if(current == null) {
                    parent.left = newNode;
                    flag = false;
                }
            } else {
                current = parent.right;
                if(current == null) {
                    parent.right = newNode;
                    flag = false;
                }
            }
        }
    }

    public boolean search(int data) {
        Node current = root;
        while (current!=null) {
            if (current.data == data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    //Parent is inside left and right
    public void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" --> " + node.data);
        inOrderTraversal(node.right);
    }

    //Parent PREcedes left and right
    public void preOrderTraversal(Node node) {
        if(node == null)
            return;
        System.out.print(" --> " + node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //Parent comes POST left and right nodes
    public void postOrderTraversal(Node node) {
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" --> " + node.data);
    }
}

class BinarySearchTreeImpl {

    public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();
            bst.insert(5);
            bst.inOrderTraversal(bst.root);
            bst.insert(6);
            bst.insert(2);
            bst.insert(9);
            bst.insert(4);
            System.out.println("\nIn order traversal");
            bst.inOrderTraversal(bst.root);
            System.out.println("\nPre order traversal");
            bst.preOrderTraversal(bst.root);
            System.out.println("\nPost order traversal");
            bst.postOrderTraversal(bst.root);
            System.out.println("\nSearching for 9, found : " + bst.search(9));
            System.out.println("\nSearching for 8, found : " + bst.search(8));
    }

}