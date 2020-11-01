import java.util.List;

public class Main {

    /*
    public static void main (String[] args){
        String str = "1";
        System.out.println("0: " + str);
        for(int i = 0; i < 32; i++)
        {
            str = recurse(str, 0);
            System.out.println((i + 1) + ": " + str);
        }
    }

    private static String recurse(String str, int start) {
        StringBuilder out = new StringBuilder();
        char cur = str.charAt(start);
        int i;
        for (i = start; i < str.length(); i++) {
            if (str.charAt(i) != cur) {
                break;
            }
        }
        out.append(i - start);
        out.append(cur);
        if (i < str.length()) {
            out.append(recurse(str, i));
        }
        return out.toString();
    }
    */

    public static void main(String[] args) {
        double[] L = {0, 2, 3, 5, 1, 5, 11, 7};
        double[] R = {3, 3.5, 8, 6, 2, 12, 12, 15};
        Main m = new Main();
        List<Integer> cover = m.Driver(L, R);
        m.doubleBubbleSort(L, R);
        for (int i : cover) {
            System.out.println("L: " + L[i] + "   R: " + R[i]);
        }
    }
}
