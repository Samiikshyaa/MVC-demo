package com.service;

//import java.util.ArrayList;
//import java.util.List;

import com.model.Book;

public interface BookService {
	void addBook(Book b);
	void deleteBook(int index);
//	List<Book> getBook(); (when list is used instead of jdbc) 
	void getBook();
	void countBooks();
}
