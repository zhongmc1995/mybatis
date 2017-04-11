package com.zmc.homework;

import java.util.List;
import java.util.Map;




public interface BookMapper {
	void addABook(Book book);
	Book findBookByName(String bookName);
	Book findBookById(Integer id);
	List<Book> findAllBooks();
	List<String> findAllBooksName();
	List<Map<String,Object>> findBookNameAndAuthor();
	int findCountOfBook();
	
	void updateBook(Book book);
	
	void removeBook(Integer id);
}
