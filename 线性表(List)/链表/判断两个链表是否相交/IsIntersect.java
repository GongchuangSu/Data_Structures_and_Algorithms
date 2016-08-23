/**
 * @description 判断两个链表是否相交
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 给出两个单向链表的头指针，判断这两个链表是否相交。这里为了简化问题，我们假设两个链表均不带环
 * @解题思路 如果两个没有环的链表相交于某一节点，那么在这个节点之后的所有节点都是两个链表共有的
 *           如果它们相交，则最后一个节点一定是共有的。那么，我们只要判断两个链表的尾指针是否相等。
 *           相等，则链表相交；否则，链表不相交。
 *           时间复杂度：O(length(n1)+length(n2))
 *           空间复杂度：O(1)
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

public class IsIntersect {

	/**
	 * 功能：判断两个链表是否相交
	 */
	public static boolean isIntersect(Node n1, Node n2){
		while(n1.next != null)
			n1 = n1.next;
		while(n2.next != null)
			n2 = n2.next;
		if(n1.data == n2.data)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]){
		Node listNode1 = new Node(1);
		listNode1.next = new Node(2);
		listNode1.next.next =  new Node(3);
		listNode1.next.next.next =  new Node(4);
		listNode1.next.next.next.next = new Node(5);
		
		Node listNode2 = new Node(1);
		listNode2.next = new Node(5);
		listNode2.next.next =  new Node(3);
		listNode2.next.next.next =  new Node(4);
		listNode2.next.next.next.next = new Node(1);
		
		System.out.println("两个链表是否相交：" + (isIntersect(listNode1, listNode2) == true ? "相交" : "不相交"));
	}	
}
