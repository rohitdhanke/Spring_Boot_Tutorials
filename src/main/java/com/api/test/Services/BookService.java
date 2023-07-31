package com.api.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.test.DAO.BookRepository;
import com.api.test.Entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//private static List<Book> list = new ArrayList<>();
	
	static {
//		list.add(new Book(11,"Java Complete References","Rohit"));
//		list.add(new Book(12,"Android Complete References","SAM"));
//		list.add(new Book(13,"React JS Complete References","ABC"));
	}
	
	// get all books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	// get single book by id
	public Book getBookById(int id) {
		
		// Book book2 = list.stream().filter(e->e.getId()==id).findFirst().get();
		Book book2 = this.bookRepository.findById(id);
		return book2;
	}
	
	//Adding the book
	public Book addBook(Book book) {
		//list.add(book);
		Book result = bookRepository.save(book);
		return result;
	}
	
	
	// Delete book
	public void deleteBook(int id) {
	
		bookRepository.deleteById(id);
		
		
//		Book book = list.stream().filter(e-> e.getId()==id).findFirst().get();
//		list.remove(book);
//		System.out.println("Deleted book"+book);
		//return book;
	}
	
}
