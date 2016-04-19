/**
 * @description 拓扑排序算法（TopologicalSort）
 *          输入：领接表表示的有向图
 *          输出：若图无回路，则输出拓扑排序序列并返回OK
 *                若图有回路，则返回ERROR.     
 * @author  GongchuangSu
 * @since   2016.04.19
 * @version v1.0
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    Stack < Integer > stack; // 用于存储入度为0的顶点的下标
    Queue < Integer > queue; // 用于存储拓扑排序结果
    int vlen;                // 顶点个数
    int[] indegree;          // 入度数组
    int count;               // 统计输出顶点个数

    public String topologicalSort(ListDG listDG) {
        stack = new Stack < Integer > ();
        queue = new LinkedList < Integer > ();
        this.vlen = listDG.vlen;
        indegree = new int[vlen];

        // 统计每个顶点的入度数
        for (int i = 0; i < vlen; i++) {
            ListDG.EdgeNode edgeNode = new ListDG.EdgeNode();
            edgeNode = listDG.vertexNodeList[i].firstedge;
            while (edgeNode != null) {
                indegree[edgeNode.adjvex]++;
                edgeNode = edgeNode.next;
            }
        }

        // 将入度为0的顶点入栈
        for (int i = 0; i < vlen; i++) {
            if (indegree[i] == 0)
                stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop(); // 出栈
            queue.offer(top);
            count++;               // 统计输出顶点个数
            ListDG.EdgeNode edgeNode = new ListDG.EdgeNode();
            edgeNode = listDG.vertexNodeList[top].firstedge;
            while (edgeNode != null) {
                indegree[edgeNode.adjvex]--;        // 与此顶点连接的各顶点入度减1
                if (indegree[edgeNode.adjvex] == 0) // 判断连接顶点的入度是否为0，若为0，则入栈
                    stack.push(edgeNode.adjvex);
                edgeNode = edgeNode.next;
            }
        }

        // 判断是否存在环
        if (count != vlen) {
            System.out.print("Graph has a cycle.\n");
            return "Error";
        } else {
            System.out.print(queue);
            return "OK";
        }
    }
}