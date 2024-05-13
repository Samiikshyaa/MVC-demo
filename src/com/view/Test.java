package com.view;

import java.util.List;
import java.util.Scanner;

import javax.print.event.PrintJobListener;

import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

public class Test {
	public static void main(String[] args) {
		add();
		print();
		delete();
		print();
	}
	
	static void add() {
		BookService bs = new BookServiceImpl();
		char choice = 'y';
		
		Scanner sc = new Scanner(System.in);
		do {
		Book boo = new Book();
			boo.setName("Harry Potter");
			boo.setAuthor("Jk Rowling");
			boo.setEdition(4);
			boo.setPublication("ABC publication");
			
			bs.addBook(boo);
			
			System.out.println("Do you want to add more books? ");
			choice = sc.next().charAt(0);
			
		}while(choice == 'y');
		
		
	}
	
	static void delete() {
		BookService bs = new BookServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index to delete: ");
		int  i = sc.nextInt();
		bs.deleteBook(i);
	}
	
	static void print() {
		BookService bs = new BookServiceImpl();

		List <Book> books = bs.getBook();
		System.out.println(books);
	}
}
