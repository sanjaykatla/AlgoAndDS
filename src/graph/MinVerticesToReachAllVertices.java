package graph;

import java.util.LinkedList;
import java.util.List;

public class MinVerticesToReachAllVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> result = new LinkedList<>();
        int[] inD = new int[n];

        for(int i=0; i<edges.size(); i++){
            List<Integer> edge = edges.get(i);
            int u = edge.get(0);
            int v = edge.get(1);

            inD[v]++;
        }

        for(int i=0; i<n; i++){
            if(inD[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}
