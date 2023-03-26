import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums =new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(9);
        System.out.println("nums' length is "+nums.size());
        nums.removeIf(next -> next.equals(3));
        System.out.println("nums' length is "+nums.size());
    }
}