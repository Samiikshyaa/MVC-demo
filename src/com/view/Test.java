package com.view;

import java.util.List;
import java.util.Scanner;



import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

public class Test {
	
	static BookService bs = new BookServiceImpl(); //because add,delete,printing,count every methods need this instance
	//So instead of repeating again and again, I made it single instance.
	
	public static void main(String[] args) {
		
		int ch;
		char flag= 'y';
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Choose :");
			System.out.println("1 -> Add Book");
			System.out.println("2 -> Delete Book");
			System.out.println("3 -> View Books");
			System.out.println("4 -> Count total books");
			System.out.println("5 -> Exit");
			
			ch = sc.nextInt();
			
			switch (ch) {
				case 1:
					add();
					break;
				case 2:
					delete();
					break;
				case 3:
					printing();
					break;
				case 4:
					count();
					break;	
				default:
					flag = 'n';
					break;
			}
//			System.out.println("Do you want to exit?[y/n] ");
		}while (flag == 'y');

	}
	
	static void add() {
		
		char choice = 'y';
		
		Scanner sc = new Scanner(System.in);
		do {
			Book boo = new Book();
			
			System.out.println("Enter the name of the book: ");
			boo.setName(sc.next());
			
			System.out.println("Enter the name of the author: ");
			boo.setAuthor(sc.next());
			
			System.out.println("Enter the edition: ");
			boo.setEdition(sc.nextInt());
			
			System.out.println("Enter the name of the publication");
			boo.setPublication(sc.next());	
			
			bs.addBook(boo);
			
			System.out.println("Do you want to add more books?[y/n] ");
			choice = sc.next().charAt(0);
			
		}while(choice == 'y');
		
		
	}
	
	static void delete() {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index to delete: ");
		int  i = sc.nextInt();
		bs.deleteBook(i);
	}
	
	static void printing() {
		System.out.println("The books are:  ");
		List <Book> books = bs.getBook();	
		System.out.println(books);
	}
	
	static void count() {
		int i = bs.getBook().size();
		System.out.println("Total books= "+ i);
	}
	
}
