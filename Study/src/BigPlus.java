import java.util.Scanner;

public class BigPlus {

	public static void main(String[] args){

		char inputNum1[] = new char[10];
		char inputNum2[] = new char[10];

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.println("first input number : ");
		inputNum1 = sc1.nextLine().toCharArray();

		System.out.println("second input number : ");
		inputNum2 = sc2.nextLine().toCharArray();
		
		numCipher(inputNum1, inputNum2);//자릿수 계산 
		
		sc1.close();
		sc2.close();
	}
	
	private static void numCipher(char[] inputNum1, char[] inputNum2){
		
		String input1 = new String(inputNum1);
		String input2 = new String(inputNum2);
		int maxLength = 0;
		int minLength = 0;
		String temp = "";
		boolean isBig = true;
		
		//입력 자릿수가 다른 경우 큰 숫자 기준으로 덧셈 for문 동작 
		if(inputNum1.length > inputNum2.length){
			maxLength = inputNum1.length;
			minLength = inputNum2.length;
			isBig = true;
		}else{
			maxLength = inputNum2.length;
			minLength = inputNum1.length;
			isBig = false;
		}
		
		//자릿수가 작은 배열에 임의로 0입력
		for (int i = 0; i < maxLength-minLength; i++) {
			temp += '0';
		}
		
		if(isBig){ //처음 입력한 숫자가 더 클 경우 
			input2 = temp + input2;
		}else{ //두번째 입력한 숫자가 더 클 경우 
			input1 = temp + input1;
		}
		
		inputNum1 = input1.toCharArray();
		inputNum2 = input2.toCharArray();
		
		BigPlusResult(inputNum1, inputNum2, maxLength);//최종 합
		
	}

	private static void BigPlusResult(char[] inputNum1, char[] inputNum2, int maxLength) {

		int iTempResult = 0;
		String sReverseResult = "";
		String sResult = "";
		int carry = 0;
		
		int num1 = 0;
		int num2 = 0;
		int rem = 0;
		
		for (int i = maxLength-1; i >= 0 ; i--) {//자릿수가 다른경우 작은 숫자 배열에 값이 없을 때 error 발생
			num1 = Integer.parseInt(String.valueOf(inputNum1[i]));
			num2 = Integer.parseInt(String.valueOf(inputNum2[i]));
			iTempResult = num1 + num2 + carry; 
			carry = iTempResult / 10; 
			rem = iTempResult % 10;  
			sReverseResult += String.valueOf(rem);
		}
		
		if(carry != 0)
			sReverseResult += String.valueOf(carry);
		
		for (int j = sReverseResult.length()-1; j >= 0; j--) {
			sResult += sReverseResult.charAt(j);
		}
		System.out.println( "result : " + sResult);
	}
}
