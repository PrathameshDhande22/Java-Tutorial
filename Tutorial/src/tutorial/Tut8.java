package tutorial;

//loops
public class Tut8 {
	public static void main(String[] args) {
		//for loops
		for(int i=0;i<5;i++) {
			System.out.println(i);
		}
		System.out.println("Printing Reverse Number");
		//printing reverse nu
		for(int i=5;i>0;i--) {
			System.out.println(i);
		}
		System.out.println("While Loop");
		//while loop
		int no=5;
		while(no>=1) {
			if(no==0)
				break;
			System.out.println(no);
			no--;
		}
		System.out.println("Do while loop");
		no=1;
		do {
			System.out.println(no);
			no++;
		}
		while(no<=5);
	}
}

/*
Output:
0
1
2
3
4
Printing Reverse Number
5
4
3
2
1
While Loop
5
4
3
2
1
Do while loop
1
2
3
4
5
*/