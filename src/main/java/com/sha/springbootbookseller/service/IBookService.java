package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Book;

import java.util.List;

public interface IBookService  {
    Book bookSave(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
