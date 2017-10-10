/**
 * Created by ellie on 2/23/2017.
 */
public class PostfixArithmetic {
    public static void main(String input){
        //abc^* = a*b^c
        intStack stack = new intStack();

        for (int i = 0; i <input.length(); i++){
            char op = input.charAt(i);
            if ( op == '*') {
                int a =  stack.pop();
                int b = stack.pop();
                int z = b * a;
                stack.push(z);
            }
            else if (op == '/'){
                int a =  stack.pop();
                int b = stack.pop();
                int z = b / a;
                stack.push(z);
            }
            else if (op == '+'){
                int a =  stack.pop();
                int b = stack.pop();
                int z = b + a;
                stack.push(z);
            }
            else if(op == '-'){
                int a =  stack.pop();
                int b = stack.pop();
                int z = b + a;
                stack.push(z);
            }

            else{
                stack.push(op);
            }
        }

    }
}
