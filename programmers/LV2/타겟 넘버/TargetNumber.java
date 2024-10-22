package programmers_targetnumber;

public class TargetNumber {

	public static void main(String[] args) {
		int[] numbers = new int[]{1,1,1,1,1};
		int target = 3;
		solution(numbers, target);
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = dfs(0, 0, numbers, target);
		System.out.println(answer);
        return answer;
    }
	
	public static int dfs(int sum,int idx, int[] numbers, int target) {
		if(numbers.length==idx) { 
			return sum==target ? 1 : 0;
		}
		
		return dfs(sum+numbers[idx], idx +1, numbers, target)+
				dfs(sum-numbers[idx], idx +1, numbers, target);
	}

}
