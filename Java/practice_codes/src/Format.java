public class Format {

    public static void main(String[] args) {
        System.out.println("================================");

        // Hard-coded input values
        String[] strings = {"java", "cpp", "python"};
        int[] numbers = {100, 65, 50};

        for (int i = 0; i < 3; i++) {
            // Access each string and corresponding number
            String s1 = strings[i];
            int x = numbers[i];
            
            // Print the formatted output
            System.out.printf("%-15s%03d%n", s1, x);
        }

        System.out.println("================================");
    }
}
