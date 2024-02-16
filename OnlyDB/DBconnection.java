package Phone_Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DBconnection {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	DButill db = new DButill();
	Make_Voids make = new Make_Voids();
	
String Prompt = """
		===========================
		=                         =
		=         전화번호부         =
		=                         =
		=      1. 전화번호 등록       =
		=      2. 전화번호 변경       =
		=      3. 전화번호 삭제       =
		=    4. 전제 전화번호 보기     =
	 =   5. 전화번호 및 정보 조회    =
	 =        6. 끝내기          =
  =                         =
	 ===========================
		""";

outer:
while (true) {
	System.out.println(Prompt);
	System.out.println("원하는 메뉴의 번호를 선택해 주세요. : ");
	try {
	int num = scanner.nextInt();
	switch(num) {
	case 1:
		make.InputPhone();
		break;
	case 2:
		make.ChangePhone();
		break;
	case 3:
		make.DeletePhone();
		break;
	case 4:
		make.LookPhone();
		break;
	case 5:
		System.out.println("전화번호부가 종료됩니다.");
		break;
	case 6:
		System.out.println("전화번호부가 종료됩니다.");
		break outer;
	default:
		System.out.println("올바른 숫자를 입력해주세요.");
		break;
	}
	} catch (InputMismatchException e) {
		System.out.println("올바른 '숫자'를 입력해 주세요.");
		scanner.next();
	}
}
}
}
