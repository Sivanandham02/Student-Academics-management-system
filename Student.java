package com.ty;
	import java.util.Scanner;
	public class Student {
		public static void main(String[] args) {
			try(Scanner scanner= new Scanner(System.in)){
			StudentInterface si=new StudentImplementation();
			while(true) {
				System.err.println("Welcome to Student Database Management system");
				System.err.println("--------------");
				System.err.println("This is ypur options");
				System.err.println("1:Add student\n2:Delete Student\n3:Update Student\n4:GetAll Student\n5:Getstudent ByMarks\n6.DeleteAll Students\n7.Exit\n");
				System.err.println("Enter your choice");
				int choice=scanner.nextInt();
				switch(choice) {
				case 1:
					si.addstudent();
					break;
				case 2:
					si.deletestudent();
					break;
				case 3:
					si.updatestudent();
					break;
				case 4:
					si.getAllstudent();
					break;
				case 5:
					si.getstudentByMarks();
					break;
				case 6:
					si.deleteAllstudent();
					break;
				case 7:
					System.out.println("thank you");
					break;
					default:
						System.out.println("invalid choice");
				}
			}
		}

	}
	}
