import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String input = read.nextLine();
        List inputls = Listify(input);
        System.out.println(inputls);
        int out = calc(inputls, inputls.size());
        System.out.println(out);
    }

    private static ArrayList<String> Listify(String input) {
        // initialize
        ArrayList<String> ls = new ArrayList<String>();
        String tmp = "";
        // listify readed string
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                tmp += input.charAt(i);
            } else {
                if (!tmp.equals("")) {
                    ls.add(tmp);
                    tmp = "";
                }
                ls.add(Character.toString(input.charAt(i)));
            }
        }
        return ls;
    }

    private static int min(int arg1, int arg2) {
        if (arg1 < arg2) {return arg1;} else {return arg2;}
    }
    private static int max(int arg1, int arg2) {
        if (arg1 > arg2) {return arg1;} else {return arg2;}
    }

    private static int calc(List ls, int fin) {
        for (int i = 0; i < ls.size(); i++) {
            
        }
        return 0;
    }

    private static int order(List ls, int fin) {
        for (int i = 0; i < ls.size(); i++) {
            
        }
        return 0;
    }

}