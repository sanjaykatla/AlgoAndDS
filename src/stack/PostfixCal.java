package stack;

import java.util.Stack;

public class PostfixCal {

    public static void main(String[] args){
        PostfixCal pc = new PostfixCal();
        final String[] strings = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(pc.evalRPN(strings));
    }
    public int evalRPN(String[] tokens) {

        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String s = tokens[i];
            if (isOperator(s)) {
                int op1 = operands.pop();
                int op2 = operands.pop();

                final int evaluate = evaluate(op2, op1, s);
                operands.push(evaluate);
            } else {
                operands.push(Integer.parseInt(s));
            }
        }
        return operands.peek();
    }

    private int evaluate(int m, int n, String operator) {

        int result = 0;
        if (operator.equals("+")) {
            result =  m + n;
        }
        if (operator.equals("-")) {
            result =  m - n;
        }
        if (operator.equals("*")) {
            result =  m * n;
        }

        if( operator.equals("/")){
            result = m/n;
        }
        System.out.println("m: "+ m+" n: "+n+" operantor:" +operator+ " result: "+ result);
        return result;
    }

    private boolean isOperator(String s) {
        char c = s.charAt(0);
        return s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/');
    }
}
