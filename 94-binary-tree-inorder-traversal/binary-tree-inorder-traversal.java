class Solution {
    void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            traverse(root.left, result);
            result.add(root.val);
            traverse(root.right, result);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
}