/**
 * @description 单链表的转置
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 输入一个单向链表，输出逆序反转后的链表 
 * @解题思路 利用头插法
 */
package com.gongchuangsu.list;

public class ReverseList {
	
	/**
	 * 功能：反转链表
	 */
	public static Node reverse(Node node){
		if(node == null || node.next == null)
			return node;
		Node result = new Node(node.data);		
		node = node.next;
		while(node != null){
			Node temp = new Node();
			temp.next = result;
			temp.data = node.data;
			result = temp;
					
			node = node.next;
		}
		return result;
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
		System.out.println("反转前：");
		print(listNode);
		System.out.println("反转后：");
		print(reverse(listNode));
	}
}