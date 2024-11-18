import java.util.Arrays;

public class Array_2 {
    public static void main(String[] args) {
        int[] numbers = {35, 12, 44, 78, 23, 56, 10, 89, 34, 50};

        // Sorting the array in ascending order
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Finding the largest element
        int largest = numbers[numbers.length - 1];
        System.out.println("Largest element: " + largest);

        // Calculating the average
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);
    }
}
