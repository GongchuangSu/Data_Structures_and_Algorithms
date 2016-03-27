/*
 * ���ߣ�GongchuangSu
 * ʱ�䣺2016.03.12
 * ���ܣ�ʮ����������ͼ�����ṩ������
 * ����˵����vexs  --  ��������
 * 		   edges  --  ������
 * ���˵����ʮ����������ÿ������vi������һ������ΪviΪ��β�ͻ�ͷ�ı�
 */
package test;
public class OListDG {
    int vlen; // �������
    int elen; // �߸���
    VertexNode[] vertexNodeList; // ��������
    EdgeNode edgeNode;

    /**
     * ���캯��
     * @param vexs
     * @param edges
     */
    public OListDG(char[] vexs, char[][] edges) {
        vlen = vexs.length;
        elen = edges.length;

        // ��ʼ������,���������
        vertexNodeList = new VertexNode[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexNodeList[i] = new VertexNode();
            vertexNodeList[i].vertex = vexs[i];
            vertexNodeList[i].firstIn = null;
            vertexNodeList[i].firstOut = null;
        }

        // ��ʼ���ߣ�����ͷ�巨����ʮ������
        for (int i = 0; i < elen; i++) {
            EdgeNode edgeNode_1 = new EdgeNode();
            EdgeNode edgeNode_2 = new EdgeNode();
            int vi = getPosition(edges[i][0], vexs);
            int vj = getPosition(edges[i][1], vexs);
             
            edgeNode_1.tailvex = vi;
            edgeNode_1.headvex = vj;
            edgeNode_1.taillink = vertexNodeList[vi].firstOut;
            vertexNodeList[vi].firstOut = edgeNode_1;
            
            edgeNode_2.tailvex = vi;
            edgeNode_2.headvex = vj;
            edgeNode_2.headlink = vertexNodeList[vj].firstIn;
            vertexNodeList[vj].firstIn = edgeNode_2;

        }
    }

    /**
     *  ���ܣ��������ṹ
     *  ������vertex --> �����򣬴洢������Ϣ
     *       firstIn --> ��߱�ͷָ�룬ָ��ö������߱��е�һ�����
     *       firstOut --> ���߱�ͷָ�룬ָ��ö���ĳ��߱��е�һ�����
     */
    private class VertexNode {
        char vertex; 
        EdgeNode firstIn;
        EdgeNode firstOut; 
    }

    /**
     *  ���ܣ��߱���
     *  ������tailvex --> ������ڶ������±�
     *        headvex --> ���յ��ڶ������±�
     *        headlink --> ��߱�ָ����,ָ���յ���ͬ����һ����
     *        taillink --> �߱�ָ����ָ�������ͬ����һ����
     */
    private class EdgeNode {
    	int tailvex;
    	int headvex;
    	EdgeNode headlink;
    	EdgeNode taillink;
    }

    /**
     *  ���ܣ�����chλ��
     */
    private int getPosition(char ch, char[] vexs) {
        for (int i = 0; i < vlen; i++)
            if (vexs[i] == ch)
                return i;
        return -1;
    }

    /**
     *  ���ܣ���ӡ�ڽӱ�����ڽӱ�
     */
    public void print() {
        System.out.printf("AdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "-->");
            if (vertexNodeList[i].firstOut != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstOut;
                System.out.print(mEdgeNode.headvex);
                while (mEdgeNode.taillink != null) {
                    mEdgeNode = mEdgeNode.taillink;
                    System.out.print(mEdgeNode.headvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
        
        System.out.print("----------\n");
        
        System.out.printf("InvAdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "<--");
            if (vertexNodeList[i].firstIn != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstIn;
                System.out.print(mEdgeNode.tailvex);
                while (mEdgeNode.headlink != null) {
                    mEdgeNode = mEdgeNode.headlink;
                    System.out.print(mEdgeNode.tailvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * ������
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

        OListDG listUDG = new OListDG(vexs, edges);
        listUDG.print();
    }
}
