import java.util.*;

class Solution {
    private Set<Integer> combinations = new HashSet<>();
    private List<Integer> results = new ArrayList<>();

    private void isPrimeNumber(){
        for(Integer elem : combinations) {
            boolean isPrime = true;
            for (int i = 2; i < elem; i++) {
                if(elem % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) results.add(elem);
        }
    }

    private void generateCombinations(int[] counts, String current) {
        if(!current.isEmpty()){
            combinations.add(Integer.parseInt(current));
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                counts[i]--;
                generateCombinations(counts, current + i);
                counts[i]++;
            }
        }
    }

    public int solution(String numbers) {
        int[] counts = new int[10]; // 10 digits from 0 to 9
        for (char c : numbers.toCharArray()) {
            counts[c - '0']++;
        }
        generateCombinations(counts, "");
        if(combinations.contains(1)) {
            combinations.remove(1);
        }
        if(combinations.contains(0)) {
            combinations.remove(0);
        }
        isPrimeNumber();
        System.out.println(results);
        return results.size();
    }

}