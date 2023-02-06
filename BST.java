public class BST {
  Node root;

  public BST() {
    this.root = null;
  }

  public void insert(int value) {
    this.root = insert(this.root, value);
  }

  private Node insert(Node node, int value) {
    if (node == null) return new Node(value);
    if (value < node.value) node.left = insert(node.left, value);
    else if (value > node.value) node.right = insert(node.right, value);
    return node;
  }

  public boolean search(int value) {
    return search(this.root, value);
  }

  private boolean search(Node node, int value) {
    if (node == null) return false;
    if (value == node.value) return true;
    else if (value < node.value) return search(node.left, value);
    else return search(node.right, value);
  }

  public void remove(int value) {
    this.root = remove(this.root, value);
  }

  private Node remove(Node node, int value) {
    if (node == null) return null;
    if (value < node.value) node.left = remove(node.left, value);
    else if (value > node.value) node.right = remove(node.right, value);
    else {
      if (node.left == null) return node.right;
      else if (node.right == null) return node.left;
      else {
        node.value = findMinValue(node.right);
        node.right = remove(node.right, value);
      }
    }
    return node;
  }

  private int findMinValue(Node node) {
    while (node.left != null) node = node.left;
    return node.value;
  }
}
