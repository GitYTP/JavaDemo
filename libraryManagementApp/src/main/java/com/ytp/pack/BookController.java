package com.ytp.pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BookController {

	@Autowired  
	BookService bookService;  
	
	@GetMapping("/getBook")  
	private List<Book> getAllBooks()   
	{  
		return bookService.getAllBooks();  
	} 
	
	@GetMapping("/getBook/{book_id}")  
	private Book getBooks(@PathVariable("book_id") int book_id)   
	{  
		return bookService.getBooksById(book_id);  
	}  
	
	@DeleteMapping("/removeBook/{book_id}")  
	private void deleteBook(@PathVariable("book_id") int book_id)   
	{  
		bookService.delete(book_id);  
	} 
	
	@PostMapping("/addBooks")  
	public List<Book> saveAll(@RequestBody List<Book> book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping("/updateBook")  
public  Book update(@RequestBody Book book)   
	{  
		bookService.update(book);  
		return book;  
	}
	@PostMapping("/addbook")  
public Book save(@RequestBody Book book)   
	{  
		return bookService.save(book);
		 
	}
}


