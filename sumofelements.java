import java.util.*;
public class sumofelements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}
