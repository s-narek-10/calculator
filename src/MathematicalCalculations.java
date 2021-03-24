import java.util.List;
import java.util.Stack;

public class MathematicalCalculations {
    public Double Calculat(List<String> stack){
        Stack<String> stack1 = new Stack<>();
        Stack<Double> stack2 = new Stack<>();
        for (int i = 0; i<stack.size();i++){
            if (prioritet(stack.get(i))==0) {
                stack2.push(Double.parseDouble(stack.get(i)));
            }else if (prioritet(stack.get(i))==1){
                stack1.push(stack.get(i));
            }else if(prioritet(stack.get(i))== -1){
                while (prioritet(stack1.peek())!=1){
                    stack2.push(calc(stack2.pop(),stack2.pop(),stack1.pop()));
                }
                stack1.pop();
            }else {
                if (!stack1.empty()){
                    while (prioritet(stack1.peek())>=prioritet(stack.get(i))){
                        stack2.push(calc(stack2.pop(),stack2.pop(),stack1.pop()));
                        if (stack1.empty()){
                            break;
                        }
                    }
                }
                stack1.push(stack.get(i));
            }
        }

        while (!stack1.empty()) {
            stack2.push(calc(stack2.pop(), stack2.pop(), stack1.pop()));
        }
        Double d = stack2.peek();
        return d;
    }
    public static int prioritet(String i){
        if(i.equals("*")) return 3;
        if(i.equals("/")) return 3;
        if(i.equals("+")) return 2;
        if(i.equals("-")) return 2;
        if(i.equals("(")) return 1;
        if(i.equals(")")) return -1;
        return 0;
    }
    public static double calc(double i, double j, String s){
        double k = 0;
        if(s.equals("+")){
            k = j + i;
        }else if (s.equals("-")){
            k = j - i;
        }else if (s.equals("*")){
            k = j * i;
        }else if (s.equals("/")){
            if (i==0){
                throw new NullPointerException("Деление на ноль...");
            }else {
                k = j / i;
            }
        }
        return k;
    }
}
