package com.junhua.interview;

public class Solution2 {
public RandomListNode root = null;
    
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)return null;
        root = new RandomListNode(pHead.label);
		clone2(pHead, root);
        return root;
    }
    
    public void clone2(RandomListNode pHead, RandomListNode root){                               
		if(pHead==null)return;
        root = pHead;
		root.next = pHead.next;
        root.random = pHead.random;
        clone2(pHead.next, root.next);
    }
    
    public static void main(String[] args) {
    	RandomListNode pHead = new RandomListNode(1);
    	pHead.next = new RandomListNode(2);
    	pHead.random = new RandomListNode(4);
    	
    	pHead.next.next = new RandomListNode(3);
	}
}
