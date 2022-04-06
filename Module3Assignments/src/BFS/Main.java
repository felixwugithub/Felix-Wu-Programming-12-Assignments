package BFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    private static ArrayList<Node> queue = new ArrayList<>();
    private static ArrayList<Node> explored = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        explore(graph.get(0));

    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void explore(Node node){
            System.out.println("exploring: " + node);
            queue.add(node);
            for (int i = 0; i < node.getNodes().size(); i++) {
                if(!queue.contains(graph.get(node.getNodes().get(i)-1))){
                    queue.add(graph.get(node.getNodes().get(i)-1));
                }
            }
            explored.add(node);

        for(int i = 0; i < queue.size(); i++) {
            if(!explored.contains(queue.get(i))){
                explore(queue.get(i));
            }

        }


    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
