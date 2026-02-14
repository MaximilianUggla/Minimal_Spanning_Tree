public record Edge(int weight, int source, int target) implements Comparable<Edge> {

    @Override
    public String toString() {
        return weight + " " + source;
    }

    @Override
    public int compareTo(Edge other) {
        return weight - other.weight;
    }
}
