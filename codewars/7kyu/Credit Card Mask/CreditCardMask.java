package codewars_7kyu;

public class CreditCardMask {

	public static void main(String[] args) {
		System.out.println(maskify("4556364607935616"));
	}
	
	public static String maskify(String str) {
		if(str.length()<=4) {
	        return str;
	    }
	    
	    int poundSignLen = str.length()-4;
	   
	    return str.substring(poundSignLen)+"#".repeat(poundSignLen);
	}

}
