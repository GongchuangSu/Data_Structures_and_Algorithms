/**
 * 借助队列（Queue）实现二叉树的层序遍历
 */
void LevelOrderTraversal(Node root) {
    if (root == null) {
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        Node node = queue.remove();
        System.out.print(node.data + " ");
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}