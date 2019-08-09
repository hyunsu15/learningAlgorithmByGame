import java.util.*;

class Solution {

    static String startId;
    static String endId;
    static Graph graph = new Graph();

    public static void main(String args[]) {
        initialize();
        calculate();
    }

    public static void initialize() {

        Scanner in = new Scanner(System.in);

        startId = in.nextLine();
        endId = in.nextLine();

        int N = in.nextInt();
        modifyErrorScanner(in);

        for (int i = 0; i < N; i++) {
            String stopName = in.nextLine();
            String[] stopInfo = stopName.split(",");
            graph.insert(stopInfo[0], new Node(stopInfo));
        }

        int M = in.nextInt();
        modifyErrorScanner(in);

        for (int i = 0; i < M; i++) {
            String route = in.nextLine();
            String[] routeArray = route.split(" ");
            graph.connect(routeArray[0], routeArray[1]);
        }

    }

    public static void calculate() {
        ArrayList<String> shortPath = graph.findShortPath(startId, endId);
        if (shortPath.size() > 0)
            for (int i = 0; i < shortPath.size(); i++)
                System.out.println(shortPath.get(i));
        else
            System.out.println("IMPOSSIBLE");

    }

    public static void modifyErrorScanner(Scanner in) {
        if (in.hasNextLine())
            in.nextLine();
    }

    private static class Node {
        String id;
        String name;
        double latitude;// 위도
        double longitude;// 경도
        double instance;

        Node parent;
        ArrayList<Node> children;

        public Node() {
        }

        public Node(String[] nodeInfo) {
            id = nodeInfo[0];
            name = nameInitial(nodeInfo[1]);
            latitude = Double.parseDouble(nodeInfo[3]);
            longitude = Double.parseDouble(nodeInfo[4]);
            instance = Double.MAX_VALUE;

            parent = null;
            children = new ArrayList<>();
        }

        public static void connect(Node current, Node neighbor) {
            current.children.add(neighbor);
        }

        private String nameInitial(String nodeInfo) {
            StringBuffer buffer = new StringBuffer(nodeInfo);
            buffer.deleteCharAt(0);
            buffer.deleteCharAt(buffer.length() - 1);
            return buffer.toString();
        }
    }

    private static class Graph {
        static HashMap<String, Node> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }

        public static void insert(String id, Node node) {
            nodes.put(id, node);
        }

        public static void connect(String area1, String area2) {
            Node.connect(nodes.get(area1), nodes.get(area2));
        }

        public static double getInstance(Node current, Node neighbor) {
            double instance;
            double x = Math.toRadians(neighbor.longitude - current.longitude)
                    * Math.cos(Math.toRadians((neighbor.latitude + current.latitude) / 2));
            double y = Math.toRadians(neighbor.latitude - current.latitude);
            instance = x * x + y * y;
            return Math.pow(instance, 0.5) * 6371;
        }

        public static ArrayList<String> findShortPath(String startId, String endId) {
            LinkedList<Node> que = new LinkedList<>();
            HashSet<Node> set = new HashSet<>();

            Node startNode = nodes.get(startId);
            Node endNode = nodes.get(endId);

            startNode.instance = 0.0;
            que.add(startNode);

            while (!que.isEmpty()) {
                Node current = que.poll();
                set.add(current);

                if (current.id.equals(endId)) {
                    ArrayList<String> shortPath = new ArrayList();
                    while (!current.id.equals(startId)) {
                        shortPath.add(current.name);
                        current = current.parent;
                    }
                    shortPath.add(startNode.name);
                    Collections.reverse(shortPath);

                    return shortPath;
                }

                for (Node neighbor : current.children) {
                    if (que.contains(neighbor)) {
                        double newValue = current.instance + Graph.getInstance(current, neighbor);
                        if (newValue < neighbor.instance) {
                            neighbor.instance = newValue;
                            neighbor.parent = current;
                        }

                    }

                    else if (!set.contains(neighbor)) {
                        neighbor.instance = current.instance + getInstance(current, neighbor);
                        neighbor.parent = current;
                        que.add(neighbor);
                    }
                }
                Collections.sort(que, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if (o1.instance == o2.instance)
                            return 0;
                        return o1.instance > o2.instance ? 1 : -1;
                    }
                });
            }

            return new ArrayList();
        }

    }

}