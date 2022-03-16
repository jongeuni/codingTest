package hackerranck_salesbymatch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {

	public static void main(String[] args) throws IOException{
        int n = 10;

        List<Integer> ar = Arrays.asList(new Integer[] {1,1,3,1,2,1,3,3,3,3});

        int result = sockMerchant(n, ar);
        System.out.println(result);
	}
	
	public static int sockMerchant(int n, List<Integer> ar) {
		Collections.sort(ar);
		Map<Integer, Integer> m = new HashMap<>();
		int num=1;
		for(int i = 0; i<n-1; i++) {
			if(ar.get(i)!=ar.get(i+1)) {
				m.put(ar.get(i), num);
				num=1;
			} else {
				m.put(ar.get(i), num);
				num++;
			}
		}
		int result = 0;
		for(int i : m.values()) {
			result += i/2;
		}
		return result;
	}
}
