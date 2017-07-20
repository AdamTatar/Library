package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Book;

@RestController // to jest połączenie controller i responseBody - łączy te dwie
				// i nie korzysta się z widoków
@RequestMapping("/book") // robię to tu bo chce miec najpierw nazwę zasobu a
							// potem na nich jakieś operację
public class BookController {

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@GetMapping("/all")
	public String getList() {
		return "<h1>Lista ksiazek</h1>";
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "Thiniking	in Java", "Bruce Eckel", "Helion", "programming");
	}

	// zrobic model autor i kontroller do tego
	
	
	
	
	
	
}
