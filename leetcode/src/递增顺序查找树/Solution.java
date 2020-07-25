package 递增顺序查找树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020/7/20 下午5:04
 *
 *  中序遍历：左根右
 *
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        for (Integer val : list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return ans.right;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
