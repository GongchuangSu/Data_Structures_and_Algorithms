/**
 * @description 求链表的中间节点
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 求链表的中间节点，如果链表的长度为偶数，返回中间两个节点的任意一个，若为奇数，则返回中间节点。
 * @解题思路 用两个指针从链表头节点开始，一个指针每次向后移动两步，一个每次移动一步，直到快指针移到到尾节
 *           点，那么慢指针即是所求。
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

public class TheMiddleNode {
	
	/**
	 * 功能：求链表的中间结点
	 */
	public static Node theMiddleNode(Node head){
		Node fast  = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
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
		System.out.println("中间结点为：" + theMiddleNode(listNode).data);
	}
}
