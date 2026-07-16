import java.util.Arrays;
import java.util.function.Predicate;
import java.util.List;

public class GenericCounter{
    public static <T> int countMatching(List<T> list, Predicate<T> condition){
        int count = 0;
        for (T item : list) {
            if(condition.test(item)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        //Example 1 : count odd integers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int oddCount = countMatching(numbers, n-> n%2 !=0);
        System.out.println("odd numbers count: " + oddCount);

        //Example 2 : Count prime Numbers
        int primeCount = countMatching(numbers, GenericCounter::isPrime);
        System.out.println("prime numbers count: " + primeCount);

        //Example 3 : count palindromic strings
        List<String> words = Arrays.asList("level", "hello", "madam", "world", "racecar", "java", "mature", "curry", "kayak", "civic", "redder", "redivider");
        int palindromeCount = countMatching(words, GenericCounter::isPalindrome);
        System.out.println("palindrome count: " + palindromeCount);
    }

    private static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++ ){
            if (n% i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(String s){
        String reversed = new StringBuilder(s). reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }
}