import java.util.*;

//그래프 구현은 인접행렬 or 인접 리스트로 구현할수있음.

class Player {

    static HashMap<Integer, ArrayList<Integer>> graphList = new HashMap<>();
    static HashMap<Integer, Integer> childParent = new HashMap<>();
    static ArrayList<Integer> endPoint = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();
        calculate();
    }

    public static void initialize() {
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            if (graphList.get(N1) == null)
                graphList.put(N1, new ArrayList());
            if (graphList.get(N2) == null)
                graphList.put(N2, new ArrayList<>());

            graphList.get(N1).add(N2);
            graphList.get(N2).add(N1);

            childParentInitial(N1);
            childParentInitial(N2);
        }

        endPointInitial(E);

    }

    public static void childParentInitial(int num) {
        if (childParent.get(num) == null)
            childParent.put(num, Integer.MAX_VALUE);
    }

    public static void endPointInitial(int E) {
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            endPoint.add(EI);
        }

    }

    public static void calculate() {
        while (true) {
            int SI = in.nextInt();
            bfs(SI);
            System.err.println(graphList);
            removeConnect();
        }

    }

    public static void bfs(int index) {
        LinkedList<Integer> que = new LinkedList();
        Set<Integer> set = new HashSet();
        que.add(index);

        childParent.put(index, -1);

        while (!que.isEmpty()) {
            int pollValue = que.poll();
            set.add(pollValue);
            if (graphList.get(pollValue) != null && !graphList.isEmpty())
                for (Integer i : graphList.get(pollValue))
                    if (!set.contains(i)) {
                        que.add(i);
                        set.add(i);
                        childParent.put(i, pollValue);
                    }
        }

        System.err.println(childParent);
    }

    public static void removeConnect() {
        ArrayList<Integer> shortPath = calculateShortPath(shortLengthValue());
        System.out.println(shortPath.get(1) + " " + shortPath.get(0));

        graphList.get(shortPath.get(1)).remove(shortPath.get(0));
        graphList.get(shortPath.get(0)).remove(shortPath.get(1));

    }

    public static int shortLengthValue() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < endPoint.size(); i++)
            if (min > shortPathSize(endPoint.get(i))) {
                min = shortPathSize(endPoint.get(i));
                minIndex = i;
            }
        return endPoint.get(minIndex);
    }

    public static int shortPathSize(int endPoint) {
        return calculateShortPath(endPoint).size();
    }

    public static ArrayList<Integer> calculateShortPath(int endPoint) {
        ArrayList<Integer> shortPath = new ArrayList();
        LinkedList<Integer> que = new LinkedList<>();

        que.add(endPoint);

        while (!que.isEmpty()) {
            int pollValue = que.poll();
            shortPath.add(pollValue);
            if (childParent.get(pollValue) != -1)
                que.add(childParent.get(pollValue));
        }
        return shortPath;
    }

}