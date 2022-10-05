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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return solve(root,val,depth,1);
    }
    private TreeNode solve(TreeNode root, int val, int depth, int level){
        if(root==null)
            return null;
        if(depth==1){
            TreeNode newnode=new TreeNode(val);
            newnode.left=root;
            return newnode;
        }
        if(level==depth-1){
            TreeNode newnode=new TreeNode(val);
            newnode.left=root.left;
            root.left=newnode;
            
            newnode=new TreeNode(val);
            newnode.right=root.right;
            root.right=newnode;
        }
        else{
            solve(root.left,val,depth,level+1);
            solve(root.right,val,depth,level+1);
        }
        return root;
    }
}
