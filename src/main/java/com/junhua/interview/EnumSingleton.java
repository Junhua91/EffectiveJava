package com.junhua.interview;

public enum EnumSingleton {

	Instance;
	
	private TreeNode node;
	private EnumSingleton() {
		 node = new TreeNode(0);
	}
	public TreeNode getInstance(){
		return node;
	}
}
