import java.util.*;

public class SumIntegersAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers separated by space:");
        String[] inputs = sc.nextLine().trim().split("\\s+");

        for (String s : inputs) {
            int value = Integer.parseInt(s);
            numbers.add(value);
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Total Sum: " + sum);
        sc.close();
    }
}
