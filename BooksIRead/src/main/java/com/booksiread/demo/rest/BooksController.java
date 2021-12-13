package com.booksiread.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksiread.demo.models.Book;
import com.booksiread.demo.repository.BookRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BooksController {
	
	@Autowired 
	BookRepository bookrepository;
	
	//--------------------------------------GET-----------------------------------------
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		List<Book> books= bookrepository.findAll(); 
		return books; 
	}
	
	@GetMapping("/books/fiction")
	public List<Book> getAllFiction(){
		List<Book> books= bookrepository.findByFiction(true); 
		return books; 
	}
	
	
	//-------------------------------------POST-----------------------------------------
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book book1 = book;
		bookrepository.save(book1);
		return ResponseEntity.ok(book1);
	}
	
	//-------------------------------------DELETE-----------------------------------------
	@DeleteMapping("/books")
	public void deleteAll() {
		bookrepository.deleteAll();
	}
	
	@DeleteMapping("/Books/{id}")
	public void deleteById(@PathVariable ("id") int id) {
		bookrepository.deleteById(id); 
	}
	
}
