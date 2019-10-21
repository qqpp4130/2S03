import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SymbolCalculator {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<String> dataList = changeToArrayList(input);
        if (!isCharValid(input)) {
            System.out.println("INVALID CHARACTERS");
        } else if (!isValid(input)) {
            System.out.println("INVALID EXPRESSION");
        } else {
            try {
                System.out.println(data(dataList));
            } catch (NumberFormatException e) {
                System.out.println("INVALID EXPRESSION");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("INVALID EXPRESSION");
            }
        }

    }
    public static int data(ArrayList<String> input) {
        Stack<String> stack = new Stack<String>();
        String temporaryString = "";
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("(")) {
                stack.push(input.get(i));

            } else if (input.get(i).equals(")")) {
                ArrayList<String> arraylist = new ArrayList<String>();
                while (!(stack.peek().equals("("))) {
                    arraylist.add(stack.pop());
                }
                stack.pop();
                stack.push(Operation(arraylist));
            } else
                stack.push(input.get(i));
        }
        stack.pop();
        if (stack.size() != 1) {
            ArrayList<String> arr = new ArrayList<String>();
            while (!stack.empty()) {
                arr.add(stack.pop());
            }
            stack.push(Operation(arr));
        }
        return Integer.parseInt(stack.peek());
    }

    public static ArrayList<String> changeToArrayList(String input) {
        ArrayList<String> arraylist = new ArrayList<String>();
        String temporaryString = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                temporaryString += input.charAt(i);
            } else {
                if (!temporaryString.equals("")) {
                    arraylist.add(temporaryString);
                    temporaryString = "";

                }
            }
            if (temporaryString.equals(""))
                arraylist.add(Character.toString(input.charAt(i)));
        }
        arraylist.add(temporaryString);
        return arraylist;
    }

    public static String Operation(ArrayList<String> input) {

        int result = 0;
        ArrayList<String> temporaryInput = input;

        while (temporaryInput.size() != 1) {
            if (((String) temporaryInput.get(temporaryInput.size() - 2)).equals("@")) {
                result = Math.min(Integer.parseInt(temporaryInput.get(temporaryInput.size() - 1)), Integer.parseInt(temporaryInput.get(temporaryInput.size() - 3)));
            } else if (((String) temporaryInput.get(temporaryInput.size() - 2)).equals("&")) {
                result = Math.max(Integer.parseInt(temporaryInput.get(temporaryInput.size() - 1)), Integer.parseInt(temporaryInput.get(temporaryInput.size() - 3)));
            }
            temporaryInput.remove(temporaryInput.size() - 3);
            temporaryInput.remove(temporaryInput.size() - 2);
            temporaryInput.remove(temporaryInput.size() - 1);
            temporaryInput.add(Integer.toString(result));
        }
        return temporaryInput.get(0);
    }

    public static String BracketCollector(String input) {
        String brackets = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == ')') {
                brackets += input.charAt(i);
            }
        }
        return brackets;
    }

    static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            switch (input.charAt(currentIndex)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.empty())
                        return false;
                    if (stack.pop() != '(')
                        return false;
                    break;
            }
        }
        return stack.empty();
    }

    static boolean isCharValid(String input) {
        boolean checker = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == ')' || input.charAt(i) == '@' || input.charAt(i) == '&')
                checker = true;
            else if (Character.isDigit(input.charAt(i)))
                checker = true;
            else {
                checker = false;
                break;
            }
        }
        return checker;
    }

}


