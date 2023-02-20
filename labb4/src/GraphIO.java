// Anton Nyström
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {
    static public void main(String[] args) throws IOException {
        GraphIO.readFile(new UndirectedGraph(),"gridgraph");
    }
    
    static public void readFile(Graph g, String filename) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw new IOException();
        }

        int n = Integer.parseInt(scanner.nextLine());
        // Läs in n antal noder
        for(int i = 0; i<n; i++) {
            int id = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g.addNode(id, x, y);
        }

        // Läs in kanter så länge det finns fler heltal
        while(scanner.hasNextInt()) {
            int id1 = scanner.nextInt();
            int id2 = scanner.nextInt();
            int weight = scanner.nextInt();
            g.addEdge(id1, id2, weight);
        }

        scanner.close();
    }
}
