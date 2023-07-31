package com.api.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.Entities.Book;
import com.api.test.Services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> list = bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/books/{id}")   
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		try {
			Book book = bookService.getBookById(id);			 
			return ResponseEntity.of(Optional.of(book));
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 
	}
	
	@PostMapping("/saveBooks")
	public Book addBook(@RequestBody Book book) {
		
		return this.bookService.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity deleteBook(@PathVariable("id") int id) {
		
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
