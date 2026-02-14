package NonKattisImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import KattisImplementation.Edge;

public class MSTree {
    private int totW = 0;

    public List<Edge> MSTOf(List<Edge>[] edgeMatrix) throws Exception {
        boolean[] visited = new boolean[edgeMatrix.length];
        visited[0] = true;
        int visitedCount = 1;
        Queue<Edge> queue = new PriorityQueue<>();
        List<Edge> taken_edges = new ArrayList<>();

        for (Edge t : edgeMatrix[0]) {
            queue.offer(t);
        }

        while (!queue.isEmpty()) {
            Edge head = queue.poll();
            int t = head.target();
            if (!visited[t]) {
                totW += head.weight();
                taken_edges.add(head);
                visited[t] = true;
                visitedCount++;
                for (Edge e : edgeMatrix[t]) {
                    if (!visited[e.target()]) {
                        queue.offer(e);
                    }
                }
            }
        }

        if (visitedCount != edgeMatrix.length) {
            throw new Exception("Impossible MST structure from graph");
        } else {
            return taken_edges;        }
    }

    public int getWeight() {
        return totW;
    }
}