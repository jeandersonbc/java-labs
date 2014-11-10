import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.BufferedInputStream;

class Main {
    static class AdjacencyList {
        private Set<String> vertices;
        private Map<String, List<String>> adjacencyList;

        public AdjacencyList() {
            this.vertices = new LinkedHashSet<String>();
            this.adjacencyList = new HashMap<String, List<String>>();
        }
        void addEntry(String[] entry) {
            if (entry != null) {
                String vertexLabel = entry[0];

                vertices.add(vertexLabel);
                List<String> adjacentVertices = new ArrayList<String>();
                for (int i = 1; i < entry.length; i++) {
                    adjacentVertices.add(entry[i]);
                }
                adjacencyList.put(vertexLabel, adjacentVertices);
            }
        }
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (String vertex : vertices) {
                str.append(String.format("[%3s] => ", vertex));
                str.append(adjacencyList.get(vertex)).append('\n');
            }
            return str.toString();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        AdjacencyList repr = new AdjacencyList();
        while (in.hasNext()) {
            String[] listEntry = in.nextLine().split("\t");
            repr.addEntry(listEntry);
        }
        System.out.println(repr);
        in.close();
    }
}
