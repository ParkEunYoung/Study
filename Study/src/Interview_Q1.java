import java.util.Scanner;

/*
 * 1부터 100까지의 수 중에서 3으로 나뉘어 떨어지면 fizz라고 출력하고 5로 나뉘어 떨어지면 Buzz라고 출력합니다.     
 * 만약 3으로도 나뉘어 떨어지고 5로도 나뉘어 떨어지면 fizzbuzz 라고 출력합니다. 
 * 그렇지 않으면 즉 3으로도 나뉘어 떨어지지 않고 5로도 나뉘어 떨어지지 않으면 그 수를 출력합니다. 
 */

public class Interview_Q1 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 100까지의 숫자를 입력하세요 : ");
		int number = scan.nextInt();
		
		if(number % 3 == 0 && number % 5 == 0)
			System.out.println("fizzbuzz");
		else if(number % 3 == 0)
			System.out.println("fizz");
		else if(number % 5 == 0)
			System.out.println("buzz");
		else{
			System.out.println(number + " % 3 = " + number % 3);
			System.out.println(number + " % 5 = " + number % 5);
		}
	}
}
