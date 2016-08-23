/**
 * @description 判断单链表是否存在环
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 输入一个单向链表，判断链表是否有环
 * @解题思路 通过两个指针，分别从链表的头节点出发，一个每次向后移动一步，另一个移动两步，
 *           两个指针移动速度不一样，如果存在环，那么两个指针一定会在环里相遇
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

public class HasCircle {
	
	/**
	 * 功能：判断单链表是否存在环
	 */
	public static boolean hasCircle(Node head){
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast)
				return true;
		}
		return false;
	}	
	
	public static void main(String args[]){
		Node listNode = new Node(1);
		listNode.next = new Node(2);
		listNode.next.next =  new Node(3);
		listNode.next.next.next =  new Node(4);
		listNode.next.next.next.next = listNode.next.next;
		System.out.println("该单链表是否存在环？：" + (hasCircle(listNode) == true ? "是" : "否"));
	}
}
