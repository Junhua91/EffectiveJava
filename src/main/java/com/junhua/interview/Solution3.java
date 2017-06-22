package com.junhua.interview;

public class Solution3 {

	
	public TreeNode head;
	public TreeNode realHead;
	public TreeNode Convert(TreeNode root) {
		if (root == null)return null;

		Convert(root.left);
		if(head==null){
			head = root;
			realHead = head;
		}else{
			head.right = root;
			root.left = head;
			head=root;
		}
		
		Convert(root.right);

		return realHead;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);

		Solution3 solution = new Solution3();
//		solution.Convert(root);
		solution.mid(root);
	}
	
	public  void mid(TreeNode root){
		if(root==null)return;
		mid(root.left);
		System.out.println(root.val);
		mid(root.right);
	}
}
