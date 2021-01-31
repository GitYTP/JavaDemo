package com.ytp.pack;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class BookControllerTest {
	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;
	@Test
	public void getAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream.of(new Book(101,"java","john"),new Book(102,"c++","alex")).collect(Collectors.toList()));
		assertEquals(2,bookService.getAllBooks().size());
	}
	
	@Test
	public void saveTest()
	{
		Book book=new Book(100,"aaa","aaa");
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book,bookService.save(book));
	}
	@Test		
	public void deleteTest()
	{
		int book_id=100;
		bookService.delete(book_id);
		verify(bookRepository,times(1)).deleteById(book_id);
	}
	@Test
	public void saveBooksTest()
	{
		List<Book> book= new ArrayList<>(Arrays.asList(
				new Book(101,"alex","aaa"),
				new Book(102,"jasmin","bbb")
				));
		when(bookRepository.saveAll(book)).thenReturn(book);
		assertEquals(book,bookService.saveBook(book));
	}	  
	
}