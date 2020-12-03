package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.BookRespository;

@Controller
public class BookController {

	private BookRespository bookRespository;

	public BookController(BookRespository bookRespository) {
		this.bookRespository = bookRespository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books",bookRespository.findAll());
		return "books/list";
	}

}
