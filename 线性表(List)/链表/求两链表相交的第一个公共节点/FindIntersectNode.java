/**
 * @description 求两链表相交的第一个公共节点
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 求两链表相交的第一个公共节点
 * @解题思路 采用对齐的思想。计算两个链表的长度 L1 , L2，分别用两个指针 p1 , p2 指向两个链表的头，
 *           然后将较长链表的 p1（假设为 p1）向后移动L2 - L1个节点，然后再同时向后移动p1 , p2，
 *           直到 p1 = p2。相遇的点就是相交的第一个节点。
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

public class FindIntersectNode {
	
	/**
	 * 功能：求两链表相交的第一个公共节点
	 */
	public static Node findIntersectNode(Node n1, Node n2){
		int len1 = 0;
		int len2 = 0;
		Node m1 = n1;
		while(m1 != null){
			m1 = m1.next;
			len1++;
		}
		Node m2 = n2;
		while(m2 != null){
			m2 = m2.next;
			len2++;
		}
		if(len1 > len2){
			for(int i = 0; i < len1 - len2; i++)
				n1 = n1.next;
		}
		else{
			for(int j = 0; j < len2 - len1; j++)
				n2 = n2.next;
		}
		while(n1 != null){
			if(n1 == n2)
				return n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;
	}

	public static void main(String args[]){
		Node listNode1 = new Node(1);
		listNode1.next = new Node(2);
		listNode1.next.next =  new Node(3);
		listNode1.next.next.next =  new Node(4);
		listNode1.next.next.next.next = new Node(5);
		
		Node listNode2 = new Node(1);
		listNode2.next = new Node(5);
		listNode2.next.next =  listNode1.next.next;
		listNode2.next.next.next =  listNode1.next.next.next;
		listNode2.next.next.next.next = listNode1.next.next.next.next;
		
		if(findIntersectNode(listNode1, listNode2) == null)
			System.out.println("没找到相交点！");
		else 
			System.out.println("两链表相交的第一个公共节点为：" + findIntersectNode(listNode1, listNode2).data);
	}
}
