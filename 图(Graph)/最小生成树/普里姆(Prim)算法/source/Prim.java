/**
 * @description ��С������֮����ķ(Prim)�㷨
 *              ���� --> ����Ȩ��ͼ����ʼ�����±�
 *              ��� --> ��С����������
 * @author GongchuangSu
 * @since 2016.04.13
 * @version v1.0
 */
public class Prim {
    public int[] prim(WeightedGraph G, int s) {
        final int[] dist = new int[G.size()];            // ��ض����ߵ�Ȩֵ
        final int[] pred = new int[G.size()];            // prim��С�������������
        final boolean[] visited = new boolean[G.size()]; // ������ʱ������
        // ��ʼ��
        for(int i = 0; i < dist.length; i++){
        	dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0; // ����ʼ���Ӧ����СȨֵ����Ϊ0
        
        for(int i = 0; i < dist.length; i++){
        	final int next = minVertex(dist, visited); // ��dist��Ѱ��δ�����ʵ�����Ӧ����СȨֵ�������ظö�������
        	visited[next] = true;                      // ���ö�������Ϊ�ѷ���
        	
        	final int[] n = G.neighbors(next);         // ȡ����ö������ڽӵĵ�
        	for(int j = 0; j < n.length; j++){       
        		final int v = n[j];
        		final int d = G.getWeight(next, v);
        		if(dist[v] > d){
        			dist[v] = d;    // ����СȨֵ������dist������
        			pred[v] = next; // ������ǰ��㱣����pred������
        		}
        	}
        }
        	
        return pred; // ������С�������������
    }
    
    /**
     * ���ܣ���δ��������Ѱ�Ҿ�����С�ĵ㣬�����ظõ�λ��
     */
    private static int minVertex(int[] dist, boolean[] v){
    	int x = Integer.MAX_VALUE;
    	int y = -1;
    	for(int i = 0; i < dist.length; i++){
    		if(!v[i] && dist[i] < x){
    			y = i;
    			x = dist[i];
    		}
    	}
    	return y;
    }
}