package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        int countTillIncrement = 1, nextCount = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null)
            return traversal;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            list.add(temp.val);
            countTillIncrement--;
            if (countTillIncrement == 0) {
                ArrayList<Integer> tempList = new ArrayList<>(list);
                traversal.add(tempList);
                list.clear();
            }

            if (temp.left != null) {
                q.add(temp.left);
                nextCount++;
            }
            if (temp.right != null) {
                q.add(temp.right);
                nextCount++;
            }

            if (countTillIncrement == 0) {
                countTillIncrement = nextCount;
                nextCount = 0;
            }
        }
        return traversal;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> list= levelOrder(head);
        for (List l : list) {
            for (Object i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
