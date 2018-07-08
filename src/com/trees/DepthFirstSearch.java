package src.com.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class DepthFirstSearch {

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        private TreeNode(final int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    TreeNode root;

    public void createTree(final List<Integer> list) {

        //Converting to queue as List removal is expensive
        final Queue<TreeNode> nodes = list.stream()
                                            .map(TreeNode::new)
                                            .collect(Collectors.toCollection(LinkedList::new));

        Queue<TreeNode> queue = new LinkedList<>();

        root = nodes.poll();
        queue.add(root);

        while(!nodes.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = nodes.poll();
            node.right = nodes.poll();

            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public void dfsRecursiveImpl(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");

        dfsRecursiveImpl(node.left);
        dfsRecursiveImpl(node.right);
    }

    public void dfsIterative(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value  + " ");

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();

        dfs.createTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        dfs.dfsRecursiveImpl(dfs.root);
        System.out.println("\n");
        dfs.dfsIterative(dfs.root);
    }

}
