package programmers_정렬_가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println("답: "+solution(numbers));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		System.out.println((b+a).compareTo(a+b)+" "+a+" "+b);
        		return (b+a).compareTo(a+b);
        	}
        });

        if(arr[0].equals("0")) return "0";
        
        for(String a: arr) answer += a;
        
        return answer;
    }
}
