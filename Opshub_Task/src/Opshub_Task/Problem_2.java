package Opshub_Task;
import java.util.*;

public class Problem_2 {

	private static int sum = 0;
    private static int min = Integer.MAX_VALUE;
    
    static class Node 
    {
        public int index;
        public int vertex;
        public List<Node> edges = new ArrayList<Node>();
        public boolean visited = false;

        Node(int index, int vertex) 
        {
            this.index = index;
            this.vertex = vertex;
        }
    }


    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Node nodes[] = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, input.nextInt());
            sum += nodes[i].vertex;
        }

        for (int i = 0; i < n - 1; i++) {
            int from = input.nextInt();
            int to = input.nextInt();

            nodes[from - 1].edges.add(nodes[to - 1]);
            nodes[to - 1].edges.add(nodes[from - 1]);
        }

        minimumDifference(nodes[0]);
        System.out.println(min);
    }

    private static int minimumDifference(Node node) {
        node.visited = true;

        int temp = node.vertex;
        for (Node n : node.edges) 
        {
            if (!n.visited) 
            {
                int val = minimumDifference(n);
                temp += val;
                if (Math.abs(sum - 2 * val) < min)
                    min = Math.abs(sum - 2 * val);
            }
        }
        return temp;
    }
	
	
}
