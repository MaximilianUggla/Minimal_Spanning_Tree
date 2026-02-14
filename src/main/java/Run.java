import java.util.*;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MSTree tree = new MSTree();

        while (true) {
            String[] arr = scanner.nextLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);

            if (N == 0) {
                break;
            }

            List<Edge>[] edgeMatrix = new List[N];

            for (int index = 0; index < N; index++) {
                edgeMatrix[index] = new ArrayList<>();
            }

            for (int e = 0; e < M; e++) {
                String[] edge = scanner.nextLine().split(" ");
                int U = Integer.parseInt(edge[0]);
                int V = Integer.parseInt(edge[1]);
                int W = Integer.parseInt(edge[2]);

                edgeMatrix[U].add(new Edge(W, U, V));
                edgeMatrix[V].add(new Edge(W, V, U));
            }

            tree.MSTOf(edgeMatrix);
        }
        tree.print();
    }
}