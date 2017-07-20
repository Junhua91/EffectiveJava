package com.junhua.binarytree;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayList;

import com.junhua.interview.TreeNode;

public class BinaryTreeTest {
	
	public static List<Integer> list = new ArrayList<>();
	public static TreeNode head;
	public static TreeNode realHead;

	public static void main(String[] args) {

		test1();
		
		test2();
	
		test3();
		
		test4();
		
		testBalanceTree();
		
		testMirror();
	}

	public static TreeNode createBinaryTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);

		return root;
	}

	public static int getNumNode(TreeNode root) {
		if (root == null)
			return 0;
		return getNumNode(root.left) + getNumNode(root.right) + 1;
	}
	
	public static int getDepth(TreeNode root){
		if(root==null)return 0;
		
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		
		return (leftDepth>rightDepth)?leftDepth+1:rightDepth+1;
	}
	
	public static boolean isBalanceTree(TreeNode root){
		if(root==null)return true;
		
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		
		int dif = Math.abs(left-right);
		
		if(dif>1)return false;

		return isBalanceTree(root.left) && isBalanceTree(root.right);
	}
	
	public static boolean isBalanceTree2(TreeNode root, int depth){
		if(root==null){
			depth = 0;
			return true;
		}
		
		int leftDepth=0, rightDepth = 0;
		
		boolean isBalanceLeft = isBalanceTree2(root.left, leftDepth);
		boolean isBalanceRight = isBalanceTree2(root.right, rightDepth);
		
		if(isBalanceLeft && isBalanceRight){
			int dif = Math.abs(rightDepth-leftDepth);
			if(dif<1){
				depth = (rightDepth>leftDepth)?rightDepth+1:leftDepth+1;
				return true;
			}
		}
		return false;
	}
	
	public static void testBalanceTree(){
		TreeNode root = createBinaryTree();
		int depth=0;
		System.out.println(isBalanceTree2(root, depth));
		System.out.println(depth);
	}

	public static List getPreOrder(TreeNode root){
		if(root==null)return list;
		
		System.out.print(root.val+" ");
		list.add(root.val);
		
		getPreOrder(root.left);
		getPreOrder(root.right);
		return list;
	}
	
	public static void getPostOrder(TreeNode root){
		if(root==null)return;
		
		getPostOrder(root.left);
		getPostOrder(root.right);
		System.out.print(root.val+" ");
	}
	
	public static void getCoucheOrder(TreeNode root){
		list.clear();
		if(root==null)return;
		Queue<TreeNode> queue = new ArrayBlockingQueue<>(12);
		queue.add(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left!=null)queue.add(node.left);
			if(node.right!=null)queue.add(node.right);
		}
	}
	

	public static void getInOrder(TreeNode root){
		if(root==null)return;
		
		getInOrder(root.left);
		System.out.print(root.val+" ");
		getInOrder(root.right);
	}

	/**
	 * inOrder, right->next node
	 * @param root
	 */
	public static void convertSub(TreeNode root){
		if(root==null)return;
		
		convertSub(root.left);
		
		if(head==null){
			head = root; 
			realHead = head;
		}else{
			head.right = root;
			root.left = head;
			head= root;
		}
		convertSub(root.right);
	}

	public static TreeNode convert(TreeNode root){
		convertSub(root);
		return realHead;
	}
	
	
	public static int countNode(TreeNode root, int k){
		if(root==null || k<1)return 0;
		if(k==1)return 1;
		int n = countNode(root.left, k-1);
		int m = countNode(root.right, k-1);
		return n+m;
	}
	
	/*
	 * 叶子节点既没有左节点，也没有右节点
	 */
	public static int countClidrenNode(TreeNode root){
		if(root==null)return 0;
		
		if(root.left==null && root.right==null)return 1;
		
		int n = countClidrenNode(root.left);
		int m = countClidrenNode(root.right);
		return m+n;
	}
	
	public static boolean compStructure(TreeNode root1, TreeNode root2){
		if(root1==null && root2 == null)return true;
		if((root1==null && root2!=null) || (root1!=null && root2==null))return false;
		return  compStructure(root1.right, root2.right) && compStructure(root1.left, root2.left);
	}
	
	
	public static TreeNode mirror(TreeNode root){
		if(root==null)return null;
		
		TreeNode leftNode = mirror(root.left);
		TreeNode rightNode = mirror(root.right);
		
		root.left = rightNode;
		root.right = leftNode;
		
		return root;				
	}
	
	
	public static void testMirror(){
		TreeNode root = createBinaryTree();
		mirror(root);
	}
	/*****************************************************
	 * test part*/
	public static void test1(){
		TreeNode root = createBinaryTree();
		System.out.println(getNumNode(root));
		System.out.println(getDepth(root));
		
		getPreOrder(root);
		System.out.println();
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		System.out.println();
		getInOrder(root);
		System.out.println();
		getPostOrder(root);
	}
	
	public static void test2(){
		System.out.println();
		TreeNode root = createBinaryTree();
		getCoucheOrder(root);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	/**
	 * convert to binary linklist
	 */
	public static void test3(){
		System.out.println();
		TreeNode root = createBinaryTree();
		convert(root);
	}
	
	/**
	 * count node
	 */
	public static void test4(){
		System.out.println();
		TreeNode root = createBinaryTree();
		System.out.println(countNode(root, 3));
		System.out.println(countClidrenNode(root));
	}
}
