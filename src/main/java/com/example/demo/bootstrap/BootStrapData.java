package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repositories.AuthorRepositry;
import com.example.demo.repositories.BookRespository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepositry authorRepositry;
	private final BookRespository bookRespository;
	
	public BootStrapData(AuthorRepositry authorRepositry, BookRespository bookRespository) {
		super();
		this.authorRepositry = authorRepositry;
		this.bookRespository = bookRespository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design","123122");
	
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepositry.save(eric);
		bookRespository.save(ddd);
		
		System.out.println("Total count = "+bookRespository.count());
		
	}
}
