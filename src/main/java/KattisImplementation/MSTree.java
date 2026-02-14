package KattisImplementation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MSTree {
    private final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


    public void MSTOf(List<Edge>[] edgeMatrix) {
        boolean[] visited = new boolean[edgeMatrix.length];
        visited[0] = true;
        int totW = 0;
        int visitedCount = 1;
        Queue<Edge> queue = new PriorityQueue<>();
        List<Edge> taken_edges = new ArrayList<>();

        for (Edge t : edgeMatrix[0]) {
            queue.offer(t);
        }

        while (!queue.isEmpty()) {
            Edge head = queue.poll();
            int w = head.weight();
            int s = head.source();
            int t = head.target();
            if (!visited[t]) {
                totW += w;
                taken_edges.add(new Edge(w,
                        Math.min(s, t),
                        Math.max(s, t)
                ));
                visited[t] = true;
                visitedCount++;
                for (Edge e : edgeMatrix[t]) {
                    if (!visited[e.target()]) {
                        queue.offer(e);
                    }
                }
            }
        }

        boolean complete = visitedCount == edgeMatrix.length;
        if (!complete) {
            out.println("Impossible");
        } else {
            out.println(totW);
            taken_edges.sort((a,b) -> {
                int diff = a.source() - b.source();
                if (diff == 0) {
                    return a.target() - b.target();
                } else {
                    return diff;
                }
            });
            for (Edge e : taken_edges) {
                out.print(e.source());
                out.print(" ");
                out.print(e.target());
                out.print("\n");
            }
        }
    }

    public void print() {out.flush();}
}