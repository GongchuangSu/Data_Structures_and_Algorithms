/**
 * @description 找到环的入口点
 * @author GongchuangSu
 * @since 2016.08.23
 * @explain 输入一个单向链表，判断链表是否有环。如果链表存在环，如何找到环的入口点？
 * @解题思路 由上题可知，按照 p2 每次两步，p1 每次一步的方式走，发现 p2 和 p1 重合，确定了单向链表有环路了。
 *           接下来，让p2回到链表的头部，重新走，每次步长不是走2了，而是走1，那么当 p1 和 p2 再次相遇的时候，
 *           就是环路的入口了
 * @详细说明 假定起点到环入口点的距离为 a，p1 和 p2 的相交点M与环入口点的距离为b，环路的周长为L，当 p1 和 p2 
 *           第一次相遇的时候，假定 p1 走了 n 步。那么有：
 *                p1走的路径： a+b ＝ n；
 *                p2走的路径： a+b+k*L = 2*n； 
 *                p2 比 p1 多走了k圈环路，总路程是p1的2倍
 *           根据上述公式可以得到 k*L=a+b=n显然，如果从相遇点M开始，p1 再走 n 步的话，还可以再回到相遇点，
 *           同时p2从头开始走的话，经过n步，也会达到相遇点M。
 *           显然在这个步骤当中 p1 和 p2 只有前 a 步走的路径不同，所以当 p1 和 p2 再次重合的时候，必然是在链
 *           表的环路入口点上。
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

public class FindLoopPort {
	
	/**
	 * 功能：寻找环的入口点
	 */
	public static Node findLoopPort(Node head){
		Node slow = head;
		Node fast = head;
		int n = 0;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			n++;
			if(slow == fast){
				fast = head;
				while(n != 0){
					fast = fast.next;
					slow = slow.next;
					if(fast == slow)
						return fast;
					n--;
				}
			}
		}
		return fast;
	}
	
	public static void main(String args[]){
		Node listNode = new Node(1);
		listNode.next = new Node(2);
		listNode.next.next =  new Node(3);
		listNode.next.next.next =  new Node(4);
		listNode.next.next.next.next = listNode.next;
		System.out.println("环的入口点为：" + findLoopPort(listNode).data);
	}
}
