package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Book;

public class BookServiceImpl implements BookService {
	static List <Book> blist = new ArrayList<>();
	
	@Override
	public void addBook(Book b) {
		blist.add(b);
		System.out.println("Book added");
			
	}

	@Override
	public void deleteBook(int index) {
		blist.remove(index);
		System.out.println("Book deleted");
	}

	@Override
	public List<Book> getBook() {
		System.out.println("The books are:  ");
		return blist;
	}

}
