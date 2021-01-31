package com.ytp.pack;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired  
	 private BookRepository bookRepository;  

	public List<Book> getAllBooks()   
	{  
		List<Book> book = new ArrayList<Book>();  
		bookRepository.findAll().forEach(book1 -> book.add(book1));  
		return book;  
	}  

	public Book getBooksById(int book_id)   
	{  
		return bookRepository.findById(book_id).get();  
	}  

	public List<Book> saveBook(List<Book> book) {
		return (List<Book>) bookRepository.saveAll(book);
	}

	public void delete(int book_id)   
	{  
		bookRepository.deleteById(book_id);  
	}  

	public void update(Book book)   
	{  
		bookRepository.save(book);  
	}  
	
	public Book save(Book book)   
	{  
		return bookRepository.save(book); 
		 
	}

}
