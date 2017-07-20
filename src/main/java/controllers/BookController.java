package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.MockBookService;
import models.Book;

@RestController // to jest połączenie controller i responseBody - łączy te dwie
				// i nie korzysta się z widoków
@RequestMapping("/book") // robię to tu bo chce miec najpierw nazwę zasobu a
							// potem na nich jakieś operację
public class BookController {
	
	@Autowired	//wstrzykuję obiket MockBookService
	private MockBookService bookService;

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@GetMapping("/all")
	public List<Book> getList() {
		
		List<Book> list = this.bookService.getList();
		
		return list;
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "Thiniking	in Java", "Bruce Eckel", "Helion", "programming");
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return this.bookService.getById(id);
	}
	
	// dodawanie książki - POST służy do dodawania nowego zasobu	// to na razie nie działa
	@PostMapping("/")
	public void postBook(HttpServletRequest request) {
//		request.get
		try {
			String bookJason = request.getHeaderNames().toString();
			Book book = new ObjectMapper().readValue(bookJason, Book.class);
			this.bookService.add(book);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id){
		this.bookService.deleteById(id);
	}
	
	
	
	
}
