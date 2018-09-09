package Arrays;

import Tree.BinarySearchTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
// http://www.geeksforgeeks.org/k-th-smallest-absolute-difference-two-elements-array/
public class KthSmallestDistance {

    public int smallestDistancePair(int[] nums, int k) {
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i+1; j < nums.length; j++)
                tree.insert(Math.abs(nums[j] - nums[i]));

        if (tree.head == null)
            return 0;

        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> dist = new ArrayList<>();

        if (tree.head.right != null)
            stack.push(tree.head.right);
        stack.push(tree.head);
        if (tree.head.left != null)
            stack.push(tree.head.left);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n.left != null) {
                if (n.right != null)
                    stack.push(n.right);
                stack.push(n);
                stack.push(n.left);
            } else {
                dist.add(n.data);
                if (n.right != null)
                    stack.push(n.right);
            }
        }

        return dist.get(k-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;


//        System.out.println(dist.get(k-1));
    }
}
