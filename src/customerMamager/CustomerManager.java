package customerMamager;

import java.util.Scanner;

public class CustomerManager {
	
	static final int MAX =100;
	
	static String[] nameList = new String[MAX];
	static char[] genderList = new char[MAX];
	static String[]  emailList = new String[MAX];
	static int[] birthList = new int[MAX];
	
	static int count =0;
	
	static int index = -1;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		while(true) {
			System.out.println("\n[INFO]고객수 :" +count+",인덱스 : "+index);
			System.out.println("(I)nsert, (P)revious," 
			+"(N)ext, (C)urrent, (U)pdate,"+"(D)elete,(Q)uit");
			System.out.println("메뉴 입력:");
			String menu = sc.next();
			menu = menu.toLowerCase();
			char m = menu.charAt(0);
			
			switch(m) {
			case'i':
			case 'ㅑ':
			     System.out.println("\n고객의 정보입력을 시작합니다");
			     insertDate();
			     System.out.println("고객의 정보가 정상적으로 입력 되었습니다");
			     break;
			case'p':
			case 'ㅔ':
				System.out.println("\n이전에 고객 정보를 출력합니다");
				if(index <=0) {
					System.out.println("이전 고객 정보가 존재하지 않습니다");
				}else {
					index --;
					printDate(index);
				}
				break;
			case'n':
			case 'ㅜ':
				System.out.println("\n이전에 고객 정보를 출력합니다");
				if(index >=count-1) {
					System.out.println("이전 고객 정보가 존재하지 않습니다");
				}else {
					index ++;
					printDate(index);
				}
				break;
			case'c':
			case 'ㅊ':
				System.out.println("\n이전에 고객 정보를 출력합니다");
				if(index <=0 && index < count) {
					printDate(index);
				}else {
					System.out.println("이전 고객 정보가 존재하지 않습니다");			
				}
				break;
			case'u':
			case 'ㅕ':
				if (index >= 0&& index <count) {
					System.out.println(nameList[index]+"님의 정보를 수정합니다");
					updateDate(index);
					System.out.println("고객 정보가 정상적으로  수정되었습니다");
				}else {
					System.out.println("수정할 데이터 가 존재하지 않습니다");
				}
				break;
			case'd':
			case 'ㅇ':
				if (index >= 0&& index <count) {
					System.out.println(nameList[index]+"님의 정보를 수정합니다");
					deletDate(index);
					System.out.println("고객 정보가 정상적으로  수정되었습니다");
				}else {
					System.out.println("수정할 데이터 가 존재하지 않습니다");
				}
				break;
			case'q':
			case 'ㅂ':
					System.out.println("\n님의 정보를 수정합니다");
					sc.close();
					System.exit(0); 	
				    break;
				    
	        default:
	        	System.out.println("메뉴를 잘못입력했습니다");
				
			     
			}
		}
	}
	
	static void insertDate() {
		System.out.println("===고객 정보 입력===");
		System.out.println("이름 :");
		String name = sc.next();
		
		System.out.println("성별(M/F):");
		String str = sc.next();
		char gender = str.charAt(0);
		
		System.out.println("이메일:");
		String email = sc.next();
		
		System.out.println("출생연도:");
		int birth = sc.nextInt();
		
		System.out.println("==================");
		
		nameList[count] = name;
		genderList[count] = gender;
		emailList[count] = email;
		birthList[count] = birth;
		
		count++;
	}
	
	static void printDate(int index) {
		System.out.println("\n===고객 정보===");
		System.out.println("이름:"+nameList[index]);
		System.out.println("성별:"+genderList[index]);
		System.out.println("이메일:"+emailList[index]);
		System.out.println("출생년도:"+birthList[index]);
		System.out.println("===================");
	}
	
	static void updateDate(int index) {
		System.out.println("\n===고객 정보 수정===");
		System.out.println("이름("+nameList[index]+"):");
		nameList[index] = sc.next();
		System.out.println("성별("+genderList[index]+"):");
		genderList[index] = sc.next().charAt(0);
		System.out.println("이메일("+emailList[index]+"):");
		emailList[index] = sc.next();
		System.out.println("출생연도("+birthList[index]+"):");
		birthList[index] = sc.nextInt();
		
	}
	static void deletDate(int index) {
		for(int i = index; i<count-1; i++) {
			nameList[i] = nameList[i+1];
			genderList[i] = genderList[i+1];
			emailList[i] = emailList[i+1];
			birthList[i] = birthList[i+1];			
		}
		count--;
		
	}
}
