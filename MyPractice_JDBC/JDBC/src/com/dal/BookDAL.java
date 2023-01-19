package com.dal;

import java.util.List;

import com.pojo.Book;

public interface BookDAL {
	
	List<Book> getAllBooks();
	
	//CRUD
	//select * from book;
	int addBook(Book b);
	
	int deleteBook(int id);
	
	int updateBook(Book b);
	
}
