/**
 * @description ��С������֮��³˹����(Kruskal)�㷨
 *              ���� --> ������Ȩͼ
 *              ��� --> ��ӡ��С�������߼����Ӧ��Ȩ��
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Kruskal {
	int vlen;      // �������
	int elen;      // �߸���
	Edge[] edges;  // �߼�����
	Edge[] result; // ��С����������
	int[] parent;  // �����жϱ�����Ƿ��γɻ�·
	WeightedGraph G;
	
	public void kruskal(WeightedGraph G){
	    vlen = G.size();           
	    elen = G.getEdgNum();      
		edges = new Edge[elen];
		result = new Edge[vlen-1];
		parent = new int[vlen];
		this.G = G;
		
		edges = getEdges();  // ��ȡͼ�����еı�
		sortEdges(edges);    // �Ա߽�������
		
		// ��ʼ������ֵΪ0
		for(int i = 0; i < vlen; i++){
			parent[i] = 0;
		}
				
		// ѭ��ÿһ����
		int index = 0;
		for(int i = 0; i < elen; i++){               
			int n = getEnd(parent, edges[i].source);
			int m = getEnd(parent, edges[i].target);
			// ���n��m����ȣ�˵���˱�û���������������γɻ�·
			if(n != m){ 
				parent[n] = m;
				result[index++] = new Edge(edges[i].source, edges[i].target, edges[i].weight);
			}
		}
		
		// ��ӡ���
		print();
	}
	
	/**
	 * ���ܣ��߼��ṹ��
	 */
	private static class Edge{
		int source;
		int target;
		int weight;
		public Edge(int source, int target, int weight){
			this.source = source;
			this.target = target;
			this.weight = weight;
		}
	}
	
	/**
	 * ���ܣ���ȡͼ�����еı�
	 */
	private Edge[] getEdges(){
		int index = 0;
		Edge[] edges = new Edge[elen];
		for(int i = 0; i < vlen; i++){
			for(int j = i + 1; j < vlen; j++)
				if(G.getWeight(i, j) != 0)
					edges[index++] = new Edge(i, j, G.getWeight(i, j));
		}
		return edges;
	}
	
	/**
	 * ���ܣ����߰���Ȩֵ��С��С�����������
	 */
	private void sortEdges(Edge[] edges){
		for(int i = 0; i < elen; i++)
			for(int j = i + 1; j < elen; j++)
				if(edges[i].weight > edges[j].weight){
					Edge temp = edges[i];
					edges[i] = edges[j];
					edges[j] = temp;
				}
	}
	
	/**
	 * ���ܣ����Ҷ����ڸ���С���е��յ��±�
	 */
	private int getEnd(int[] parent, int i) {
		while( parent[i] > 0 )
			i = parent[i];
		return i;
	}
	
	/**
	 * ���ܣ���ӡ���
	 */
	private void print() {
		System.out.print("Kruskal:\n");
		for(int i = 0; i < vlen - 1; i++)
			System.out.printf("(%d, %d) %d \n",result[i].source, result[i].target, result[i].weight);
	}
}
