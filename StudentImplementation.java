package com.ty;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {
	Scanner scanner=new Scanner(System.in);


	
	@Override
	public void addstudent() {
		System.out.println("Enter student Id");

		int id=scanner.nextInt();

		System.out.println("Enter the student Name");

		String name = scanner.next();

		System.out.println("Enter Student Age");

		int age = scanner.nextInt();

		System.out.println("Enter the student Gender");

		String gender=scanner.next();

		System.out.println("Enter student marks");

		double marks = scanner.nextDouble();

   try {
        
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

		

			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");

			preparedStatement .setInt(1,id);

			preparedStatement.setString(2,name);

			preparedStatement.setInt(3,age);

			preparedStatement.setString(4,gender);

			preparedStatement.setDouble(5,marks);

			preparedStatement.execute();

			connection.close();

			System.err.println("Student data inserted");

		} catch (ClassNotFoundException | SQLException e) {

		 e.printStackTrace();

		}
		
	}

	@Override
	public void deletestudent() {
		System.out.println("Enter the student Id");

	 int id = scanner.nextInt();

	 

	 try {

		 Class.forName("com.mysql.cj.jdbc.Driver");

		 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

		 PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");

		 preparedStatement.setInt(1,id);

		 preparedStatement.execute();

		 connection.close();

		 System.err.println("data deleted");

		 

	 } catch (ClassNotFoundException | SQLException e) {

		 e.printStackTrace();

	 }
		
	}

	@Override
	public void updatestudent() {
		System.out.println("Enter student Id");

		int id=scanner.nextInt();

		System.out.println("Enter the Student Marks");

		double marks=scanner.nextDouble();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

			 PreparedStatement preparedStatement=connection.prepareStatement("update student set marks=? where id=?");

			 preparedStatement.setInt(2,id);

			 preparedStatement.setDouble(1,marks);

			 preparedStatement.execute();

			 System.err.println("data updated");

		} catch (ClassNotFoundException | SQLException e) {

			 e.printStackTrace();

		}

}

	@Override
	public void getAllstudent() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

			 PreparedStatement preparedStatement=connection.prepareStatement("select * from student ");

		    ResultSet resultSet=preparedStatement.executeQuery();

		    while(resultSet.next()) {

		    	System.out.println("the student id is"+resultSet.getInt(1));

		    	System.out.println("the student name is"+resultSet.getString(2));

		    	System.out.println("the student age is"+resultSet.getInt(3));

		    	System.out.println("the student gender is"+resultSet.getString(4));

		    	System.out.println("the student mark is"+resultSet.getDouble(5));

		    	System.out.println("---------------------------------------------");

		 }
		    connection.close();

		    System.err.println("student details printed");

		

		    }catch  (ClassNotFoundException | SQLException e) {

				 e.printStackTrace();

		    }

	}

	@Override
	public void getstudentByMarks() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

			 PreparedStatement preparedStatement=connection.prepareStatement("select name from Student order by marks");

		    ResultSet resultSet= preparedStatement.executeQuery();

		    while(resultSet.next()) {

		    	System.out.println("the student name is :"+resultSet.getString(1));

		    }

		    connection.close();

		    System.err.println("student name printed");

		

		    }catch  (ClassNotFoundException | SQLException e) {

				 e.printStackTrace();

		    }
        }

	@Override
	public void deleteAllstudent() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

			 PreparedStatement preparedStatement=connection.prepareStatement("truncate table student");

			 preparedStatement.execute();

			 connection.close();

			 System.err.println("table deleted");

			

		}catch  (ClassNotFoundException | SQLException e) {

			 e.printStackTrace();

	}
  }
 }
