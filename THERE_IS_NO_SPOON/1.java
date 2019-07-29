import java.util.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

    static Scanner in = new Scanner(System.in);
    static String[][] array;
    static int width;
    static int height;

    public static void main(String args[]) {
        initialize();
        printArray();
    }

    static void initialize() {
        width = in.nextInt();
        height = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        array = new String[height][width];
        arrayInitial();

    }

    static void arrayInitial() {
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or
            for (int j = 0; j < line.length(); j++)
                array[i][j] = line.charAt(j) == '0' ? "" + j + " " + i : "x";
        }
    }

    static void printArray() {
        for (int i = 0; i < height; i++)// y
            for (int j = 0; j < width; j++)// x
                callGetArray(j, i);
    }

    static void callGetArray(int x, int y) {
        if (!isError(x, y) && !isX(x, y))
            System.out.println(getArray(x, y, 0) + " " + getArray(x + 1, y, 1) + " " + getArray(x, y + 1, 2));
    }

    static String getArray(int x, int y, int isXAdd) {
        String notValue = "-1 -1";
        if (isError(x, y))
            return notValue;
        else if (!array[y][x].equals("x"))
            return array[y][x];
        else if (isXAdd == 1)
            return getArray(x + 1, y, isXAdd);
        else if (isXAdd == 2)
            return getArray(x, y + 1, isXAdd);

        return "";

    }

    static boolean isError(int x, int y) {
        return x >= width || y >= height ? true : false;
    }

    static boolean isX(int x, int y) {
        return array[y][x].equals("x");
    }
}