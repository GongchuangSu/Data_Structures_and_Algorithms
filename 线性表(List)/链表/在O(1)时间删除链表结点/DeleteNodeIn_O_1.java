/**
 * @description 在O(1)时间删除链表节点
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 给定链表的头指针和一个结点指针，在O(1)时间删除该结点。 
 * @解题思路 将指定要删除的结点用其下一个结点进行覆盖。注意结点为尾结点的情况，该方法不适用。
 */
package com.gongchuangsu.list;

public class DeleteNodeIn_O_1 {
	
	/**
	 * 功能：删除指定结点
	 */
	public static void deleteRandomNode(Node n){
		if(n.next == null){
			System.out.println("该方法不适用单位时间内删除尾结点");
		}			
		else{
			Node temp = n.next;
			n.data = temp.data;
			n.next = temp.next; 
		}
	}
	
	public static void print(Node n){
		while(n.next != null){
			System.out.print(n.data + " --> ");
			n = n.next;
		}
		System.out.println(n.data);		
	}
	
	public static void main(String args[]){
		Node listNode = new Node(2);
    	listNode.next = new Node(3);
    	listNode.next.next =  new Node(1);
    	listNode.next.next.next =  new Node(2);
    	listNode.next.next.next.next =  new Node(3);
    	// 指定要删除的结点
    	Node dst = listNode.next.next.next.next;
    	System.out.println("删除前：");
    	print(listNode);
    	deleteRandomNode(dst);
    	System.out.println("删除后：");
    	print(listNode);
	}
}

/**
 * 结点结构
 */
class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
}