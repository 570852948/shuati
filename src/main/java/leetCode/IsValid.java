package leetCode;

import java.util.Stack;

public class IsValid {
    String s = "";

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }


    //牛人
    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }






    //栈  简直就是消消乐
    public static boolean stackMethod(String s) {

        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {


            //如果发现当前字符在栈中找到配对则移除栈中配对字符

                if (!stack.isEmpty()){
                    if (judgePair((char)stack.peek(),s.charAt(i)))
                        stack.pop();
                    else stack.push(s.charAt(i));
                }else {
                    stack.push(s.charAt(i));
                }

        }
        return stack.isEmpty();

    }




    //判断是否配对
    public static boolean judgePair(char a,char b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        } else return a == '{' && b == '}';
    }



    //没成
    public void DiGui(int left,int right) {

        if (s.charAt(left) == '(' && s.charAt(right) == ')') {
            DiGui(left,right);
        }

    }
}
