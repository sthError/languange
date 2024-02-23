import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

@Slf4j
public class StackPractice {

    private Stack<String> initStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("c");
        stack.push("f");
        return stack;
    }

    @Test
    public void 遍历() {
        Stack<String> stack = initStack();

        for (String ele : stack) {
            System.out.println("ele = " + ele);
        }
//        Iterator<String> iterator = stack.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println("next = " + next);
//        }
    }

    @Test
    public void 出栈(){
        Stack<String> stack = initStack();
        String pop = stack.pop();
        for (String s : stack) {
            System.out.println("s = " + s);
        }
    }

}
