/**
 * @description 求链表倒数第k个节点
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 输入一个单向链表，输出该链表中倒数第k个节点，链表的倒数第0个节点为链表的尾指针 
 * @解题思路 设置两个指针 p1、p2，首先 p1 和 p2 都指向 head，然后 p2 向前走 k 步，这样 p1 和 p2 之间就间隔 k 个节点，
 *           最后 p1 和 p2 同时向前移动，直至 p2 走到链表末尾。
 */
package com.gongchuangsu.list;

/* 结点结构
class Node{
	int data;
	Node next;
	
	public Node(){}
	
	public Node(int data){
		this.data = data;
	}
}
*/

public class TheKthNode {
	
	/**
	 * 功能：求倒数第K个结点
	 */
	public static Node theKthNode(Node head, int k){
		if(k < 0)
			return null;
		Node fast = head;
		Node slow = head;
		for(int i = 0; i < k; i++){
			if(fast == null)
				return null;			
			fast = fast.next;
		}
			
		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
	    }
		return slow;
	}
	
	/**
	 * 功能：打印链表
	 */
	public static void print(Node n){
		while(n.next != null){
			System.out.print(n.data + " --> ");
			n = n.next;
		}
		System.out.println(n.data);		
	}
	
	public static void main(String args[]){
		Node listNode = new Node(1);
		listNode.next = new Node(2);
		listNode.next.next =  new Node(3);
		listNode.next.next.next =  new Node(4);
		listNode.next.next.next.next =  new Node(5);
		print(listNode);
		if(theKthNode(listNode, 3) == null)
			System.out.println("输入参数错误！");
		else 
			System.out.println("第K个结点为：" + theKthNode(listNode, 3).data);
	}
}
