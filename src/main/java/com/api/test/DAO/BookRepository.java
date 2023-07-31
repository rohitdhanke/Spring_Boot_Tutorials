package com.api.test.DAO;

import org.springframework.data.repository.CrudRepository;

import com.api.test.Entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id); 
}
