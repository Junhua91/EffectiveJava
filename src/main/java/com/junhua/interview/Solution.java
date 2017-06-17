package com.junhua.interview;

import java.util.ArrayList;

public class Solution {
    
    public ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
 
        if(root== null)return allList;
        
        list.add(root.val);
        
        target -=root.val;
        if(target==0 && root.left == null && root.right==null){
            allList.add(new ArrayList<>(list));
        }
        
        FindPath(root.left, target);
        FindPath(root.right,target);
        
        list.remove(list.size()-1);
        
        return allList;
    }
    
    public static void main(String[] args) {
		TreeNode root =new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		
		Solution solution = new Solution();
		solution.FindPath(root, 22);
				
	}
}
