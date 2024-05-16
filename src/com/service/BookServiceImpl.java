package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.util.ArrayList;
//import java.util.List;

import com.model.Book;
import com.mysql.cj.jdbc.Driver;

public class BookServiceImpl implements BookService {
//	static List <Book> blist = new ArrayList<>();
	
	@Override
	public void addBook(Book b) {
//		blist.add(b);

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "12345");
			
			String sql = "Insert into books(bookname, author, edition, publication) values ('"+b.getName()+"','"+b.getAuthor()+"','"+b.getEdition()+"','"+b.getPublication()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Book added");	
	}

	@Override
	public void deleteBook(int index) {
//		blist.remove(index);  before jdbc
//		System.out.println("Book deleted");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "12345");
			
			String sql = "Delete from books where id = '"+index+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Book deleted");	
}
		

//	@Override  (when list is used instead of jdbc) 
//	public List<Book> getBook() {
//		return blist;		
//	}
	
	@Override
	public void getBook() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "12345");
			
			String sql = "Select * from books";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Book Id: "+rs.getInt("id"));
				System.out.println("Book Name: "+rs.getString("bookname"));
				System.out.println("Author: "+rs.getString("author"));
				System.out.println("Edition: "+rs.getInt("edition"));
				System.out.println("Publication"+rs.getString("publication"));
				System.out.println("-----------------------------------------");
			}	  

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void countBooks() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "12345");
			
			String sql = "select count(*) from books";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			rs.next();
			int count = rs.getInt(1);
			System.out.println("Total number of books is "+ count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
