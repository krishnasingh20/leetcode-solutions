/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(dp.containsKey(root)) {
            return dp.get(root);
        }

        int ans = root.val;
        if(root.left != null) {
            ans += dfs(root.left.left) + dfs(root.left.right);
        }
        if(root.right != null) {
            ans += dfs(root.right.left) + dfs(root.right.right);
        }

        int skip = dfs(root.left) + dfs(root.right);

        dp.put(root, Math.max(ans, skip));

        return Math.max(ans, skip);
    }
}