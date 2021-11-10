package programmers_정렬_가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		return (a+a).compareTo(b+a);
        	}
        });

        if(arr[0].equals("0")) return "0";
        
        for(String a: arr) answer += a;
        
        return answer;
    }
}
