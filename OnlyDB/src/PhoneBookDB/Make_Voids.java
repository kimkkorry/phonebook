package PhoneBookDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Make_Voids {
public static void InputPhone() {
Scanner scanner = new Scanner(System.in);
	DButill db = new DButill();
System.out.println("추가하실 분의 이름을 입력해 주세요. : ");	
	String name = scanner.nextLine();
	System.out.println("추가하실 분의 주소를 입력해 주세요. : ");	
	String address = scanner.nextLine();
	System.out.println("추가하실 분의 전화번호를 양식에 맞게 입력해 주세요. : \n ex) 010-8251-6374");	
	String phonenumber = scanner.nextLine();
	
	System.out.println("추가하실 정보가 아래와 같은지 확인해주세요.");
	System.out.println("============================");
	System.out.println("이름\t전화번호\t\t주소");
	System.out.printf("%s\t%s\t%s\n", name, phonenumber, address);
	System.out.println("맞다면 '1'번, 잘못 입력하셨다면 '2'번을 입력해주세요.");
	try {
	int num = scanner.nextInt();
	switch(num) {
	case 1:
		db.insertAddressStringBuffer(name, address, phonenumber);
		System.out.println("전화번호 등록이 완료되었습니다.");
		break;
	case 2:
		System.out.println("전화번호 등록이 취소되었습니다.");
		break;
		default:
			System.out.println("볼바른 번호를 입력해주세요.");
			break;
	}
	}catch (Exception e) {
		System.out.println("올바른 '숫자'를 입력해 주세요.");
		scanner.next();
	}
}
public static void DeletePhone() {
	Scanner scanner = new Scanner(System.in);
	DButill db = new DButill();
	System.out.println("현재 저장된 전화번호 입니다");
	LookPhone();
	System.out.println("삭제하실 분의 이름을 입력해주세요.");
	String delname = scanner.nextLine();
	ArrayList<Addr> a = db.getAddress();
	int namecount = 0;
	int delid = 0;
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)) 
			namecount +=1;
	}
	if (namecount >1) {
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)) 
			System.out.printf("%s.%s\t%s\t%s\n", a.get(i).getId(),a.get(i).getName(), a.get(i).getPhone(), a.get(i).getAddress());
		}
	System.out.println("위 번호 중 지우실 분의 숫자를 입력해주세요.\nex) 1 : ");
	delid = scanner.nextInt();
	}
	else {
		for (int i=0; i<a.size();i++) {
			if (a.get(i).getName().equals(delname)) {
				System.out.printf("%s\t%s\t%s\n",a.get(i).getName(), a.get(i).getPhone(), a.get(i).getAddress());
			delid = a.get(i).getId();
			}
		}
	}
	System.out.println("정말 삭제하시겠습니까?\n삭제하시려면 '1'번, 취소하시려면 '2'번을 눌러주세요.");
int num = scanner.nextInt();
switch(num) {
case 1:
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)&&delid == a.get(i).getId())
			db.deleteAddress(a.get(i).getId());
	}
	System.out.println("전화번호 삭제가 완료되었습니다.");
	break;
case 2:
	System.out.println("전화번호 삭제가 취소되었습니다.");
	break;
	default:
		System.out.println("올바른 숫자를 입력해주세요.");
		break;
}
}

public static void ChangePhone() {
	Scanner scanner = new Scanner(System.in);
	DButill db = new DButill();
	System.out.println("현재 저장된 전화번호 입니다");
	LookPhone();
	System.out.println("수정하실 분의 이름을 입력해주세요.");
	String delname = scanner.nextLine();
	ArrayList<Addr> a = db.getAddress();
	int namecount = 0;
	int delid = 0;
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)) 
			namecount +=1;
	}
	if (namecount >1) {
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)) 
			System.out.printf("%s.%s\t%s\t%s\n", a.get(i).getId(),a.get(i).getName(), a.get(i).getPhone(), a.get(i).getAddress());
		}
	System.out.println("위 번호 중 수정하실 분의 숫자를 입력해주세요.\nex) 1 : ");
	delid = scanner.nextInt();
	}
	else {
		for (int i=0; i<a.size();i++) {
			if (a.get(i).getName().equals(delname)) {
				System.out.printf("%s\t%s\t%s\n",a.get(i).getName(), a.get(i).getPhone(), a.get(i).getAddress());
			delid = a.get(i).getId();
			}
		}
	}
	System.out.println("정말 수정하시겠습니까?\n수정하시려면 '1'번, 취소하시려면 '2'번을 눌러주세요.");
int num = scanner.nextInt();
scanner.nextLine();
switch(num) {
case 1:
	System.out.println("이름을 다시 입력해주세요.");
	String chaname = scanner.nextLine();
	System.out.println("전화번호를 다시 입력해주세요.");
	String chaphonenum = scanner.nextLine();
	System.out.println("주소를 다시 입력해주세요.");
	String chaaddress = scanner.nextLine();
	for (int i=0; i<a.size();i++) {
		if (a.get(i).getName().equals(delname)&&delid == a.get(i).getId())
			db.updateAddress(a.get(i).getId(), chaname, chaaddress, chaphonenum);
	}
	System.out.println("전화번호 수정이 완료되었습니다.");
	break;
case 2:
	System.out.println("전화번호 삭제가 취소되었습니다.");
	break;
	default:
		System.out.println("올바른 숫자를 입력해주세요.");
		break;
}
}
public static void LookPhone() {
	DButill db = new DButill();
ArrayList<Addr> a = db.getAddress();

System.out.println("이름\t전화번호\t\t주소");
System.out.println("============================");
	for (int i=0; i<a.size();i++)
		System.out.printf("%s\t%s\t%s\n", a.get(i).getName(), a.get(i).getPhone(), a.get(i).getAddress());
System.out.println();
}
}
