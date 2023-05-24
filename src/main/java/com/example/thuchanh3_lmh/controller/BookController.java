package com.example.thuchanh3_lmh.controller;

import com.example.thuchanh3_lmh.entity.Book;
import com.example.thuchanh3_lmh.services.BookService;
import com.example.thuchanh3_lmh.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("book", new Book());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            // Handle book not found error
            return "error";
        }
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book updatedBook) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            // Handle book not found error
            return "error";
        }

        // Update the book with the new values
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setCategory(updatedBook.getCategory());

        bookService.updateBook(book);
        return "redirect:/books";
    }



    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


}



