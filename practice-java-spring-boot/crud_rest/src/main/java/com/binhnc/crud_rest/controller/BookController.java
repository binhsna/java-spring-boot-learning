package com.binhnc.crud_rest.controller;

import com.binhnc.crud_rest.dto.BookRequest;
import com.binhnc.crud_rest.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("OX-13", new Book("OX-13", "Gone with the wind", "Binh", 2001));
        books.put("OX-14", new Book("OX-14", "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest) {
        // Tạo UUID làm key cho đối tượng Book
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return newBook;
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable("id") String id) {
        return books.get(id);
    }

    @PutMapping(value = "/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest) {
        Book updateBook = new Book(id, bookRequest.title(), bookRequest.author(), bookRequest.year());
        //books.put(id, updateBook);
        books.replace(id, updateBook);
        return updateBook;
    }

    @DeleteMapping(value = "/{id}")
    public Book deleteBookById(@PathVariable("id") String id) {
        return books.remove(id);
    }
}
