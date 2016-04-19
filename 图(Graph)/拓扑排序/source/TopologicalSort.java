/**
 * @description ���������㷨��TopologicalSort��
 *          ���룺��ӱ��ʾ������ͼ
 *          �������ͼ�޻�·������������������в�����OK
 *                ��ͼ�л�·���򷵻�ERROR.     
 * @author  GongchuangSu
 * @since   2016.04.19
 * @version v1.0
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    Stack < Integer > stack; // ���ڴ洢���Ϊ0�Ķ�����±�
    Queue < Integer > queue; // ���ڴ洢����������
    int vlen;                // �������
    int[] indegree;          // �������
    int count;               // ͳ������������

    public String topologicalSort(ListDG listDG) {
        stack = new Stack < Integer > ();
        queue = new LinkedList < Integer > ();
        this.vlen = listDG.vlen;
        indegree = new int[vlen];

        // ͳ��ÿ������������
        for (int i = 0; i < vlen; i++) {
            ListDG.EdgeNode edgeNode = new ListDG.EdgeNode();
            edgeNode = listDG.vertexNodeList[i].firstedge;
            while (edgeNode != null) {
                indegree[edgeNode.adjvex]++;
                edgeNode = edgeNode.next;
            }
        }

        // �����Ϊ0�Ķ�����ջ
        for (int i = 0; i < vlen; i++) {
            if (indegree[i] == 0)
                stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop(); // ��ջ
            queue.offer(top);
            count++;               // ͳ������������
            ListDG.EdgeNode edgeNode = new ListDG.EdgeNode();
            edgeNode = listDG.vertexNodeList[top].firstedge;
            while (edgeNode != null) {
                indegree[edgeNode.adjvex]--;        // ��˶������ӵĸ�������ȼ�1
                if (indegree[edgeNode.adjvex] == 0) // �ж����Ӷ��������Ƿ�Ϊ0����Ϊ0������ջ
                    stack.push(edgeNode.adjvex);
                edgeNode = edgeNode.next;
            }
        }

        // �ж��Ƿ���ڻ�
        if (count != vlen) {
            System.out.print("Graph has a cycle.\n");
            return "Error";
        } else {
            System.out.print(queue);
            return "OK";
        }
    }
}