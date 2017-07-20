package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Author;
import models.Book;

@RestController // to jest połączenie controller i responseBody - łączy te dwie
				// i nie korzysta się z widoków
@RequestMapping("/author") // robię to tu bo chce miec najpierw nazwę zasobu a
							// potem na nich jakieś operację
public class AuthorController {

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@GetMapping("/all")
	public String getList() {
		return "<h1>Lista autorow</h1>";
	}

	@RequestMapping("/helloAuthor")
	public Author helloAuthor() {
		return new Author(1L, "Bruce Eckel", "1964", "white");
	}

	
	
	
	
	
	
}
