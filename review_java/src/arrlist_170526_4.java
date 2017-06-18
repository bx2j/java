import java.util.ArrayList;

public class arrlist_170526_4 {
	public static void main(String args[]){
		ArrayList al = new ArrayList(); // ArrayList 선언
		
		al.add("abb"); // Arraylist 항목 추가 할 때 add 사용
		al.add("cdnz");
		al.add("grge");
		al.add("fdqe");
		//al.add(123124);
		// 숫자는 초기에 add로 넣어줄 수는 있는데 sort할 때 안먹힌다
		al.add("adsf");
		al.add("1234");
		//al.add(123);
		System.out.printf("*********************\n");
		System.out.printf("시작 ArraySize [%d] \n",al.size());
		// 배열과 다르게 ArrayList 는 .size() 로 길이 확인가능
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.set(3, "llll"); // 3번 ArrayList 의 내용을 변경
		System.out.printf("*********************\n");
		System.out.printf("내용변경 ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.sort(null); // 
		System.out.printf("*********************\n");
		System.out.printf("sort ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.clear(); // ArrayList 초기화
		System.out.printf("*********************\n");
		System.out.printf("clear_all ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
	}
}
