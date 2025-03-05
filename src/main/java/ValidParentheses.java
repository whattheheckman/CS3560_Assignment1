import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            /*
            * For lines 12-14, if the string reads a bracket character
            * then it pushes a matching character to the stack
            * */

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
            /*
            if the stack is empty (means all the characters we matched have been popped off)
            or the top of the stack doesn't match the current character in the string
            we know the string is invalid
             */
        }
        return stack.isEmpty();
        /*
        * If the Stack is empty, then we matched every parenthesis and the string is valid.
        *  */
    }
}