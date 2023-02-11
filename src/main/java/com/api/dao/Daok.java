package com.api.dao;

import java.util.List;

import com.api.entity.Book;

public interface Daok {
	
	
	void saveBook(Book book);

	Book getBookById(long id);

	List<Book> getAllBooks();

	int updateBook(int id,Book Book);

	int deleteBookById(int id);

}
