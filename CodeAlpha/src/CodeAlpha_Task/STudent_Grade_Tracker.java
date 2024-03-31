package CodeAlpha_Task;

import java.util.Scanner;

public class STudent_Grade_Tracker {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of subjects: ");
		int tsub=s.nextInt();
		int tmark=0;
		for(int i=0;i<tsub;i++) {
			System.out.println("Enter the marks obtained in subject "+(i+1));
			int mark=s.nextInt();
			tmark +=mark;
		}
		int per=tmark/tsub;
		System.out.println("Results: ");
		System.out.println("Sum of Subjects: "+ tmark);
		System.out.println("Percentage: " + per +"%");
		char grade=calculateGrade(per);
		System.out.println("Grade: "+ grade);
		s.close();
	}

	private static char calculateGrade(int per) {
		if(per>=90) {
			return 'A';
		}else if(per>=80) {
			return 'B';
		}else if(per>=70) {
			return 'C';
		}else if(per>=60) {
			return 'D';
		}else {
			return 'F';
		}
	}
}
