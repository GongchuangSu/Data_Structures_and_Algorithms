/*
 * �ڽӱ�����ͼ�����ṩ������
 * ����˵����vexs  --  ��������
 * 		   edges  --  ������
 * ���˵�����ڽӱ�����ÿ������vi������һ������ΪviΪ��β�ı�
 */
package test;
public class ListDG {
    int vlen; // �������
    int elen; // �߸���
    VertexNode[] vertexNodeList; // ��������
    EdgeNode edgeNode;

    /**
     * ���캯��
     * @param vexs
     * @param edges
     */
    public ListDG(char[] vexs, char[][] edges) {
        vlen = vexs.length;
        elen = edges.length;

        // ��ʼ������,���������
        vertexNodeList = new VertexNode[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexNodeList[i] = new VertexNode();
            vertexNodeList[i].vertex = vexs[i];
            vertexNodeList[i].firstedge = null;
        }

        // ��ʼ���ߣ�����ͷ�巨�����ڽӱ�
        for (int i = 0; i < elen; i++) {
            EdgeNode edgeNode = new EdgeNode();
            int vi = getPosition(edges[i][0], vexs);
            int vj = getPosition(edges[i][1], vexs);
             
            edgeNode.adjvex = edges[i][1];
            edgeNode.next = vertexNodeList[vi].firstedge;
            vertexNodeList[vi].firstedge = edgeNode;
        }
    }

    /**
     *  �������
     */
    private class VertexNode {
        char vertex; // �����򣬴洢������Ϣ
        EdgeNode firstedge; // �߱�ͷָ��
    }

    /**
     *  �߱���
     */
    private class EdgeNode {
        char adjvex; // �ڽӵ��򣬴洢�ö����Ӧ���±�
        EdgeNode next; // ����ָ����һ���ڽӵ�
    }

    /**
     *  ����chλ��
     */
    private int getPosition(char ch, char[] vexs) {
        for (int i = 0; i < vlen; i++)
            if (vexs[i] == ch)
                return i;
        return -1;
    }

    /**
     *  ��ӡ�ڽӱ�
     */
    public void print() {
        System.out.printf("AdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "-->");
            if (vertexNodeList[i].firstedge != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstedge;
                System.out.print(mEdgeNode.adjvex);
                while (mEdgeNode.next != null) {
                    mEdgeNode = mEdgeNode.next;
                    System.out.print(mEdgeNode.adjvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * ������
     * @param args
     */
    public static void main(String args[]) {
    	// ��������
        char[] vexs = {
            'A', 'B', 'C', 'D'
        };
        // ������
        char[][] edges = new char[][] {
            {
                'A', 'B'
            }, {
                'A', 'C'
            }, {
                'A', 'D'
            }, {
                'B', 'D'
            }, {
                'C', 'D'
            }
        };

        ListDG listDG = new ListDG(vexs, edges);
        listDG.print();
    }
}
