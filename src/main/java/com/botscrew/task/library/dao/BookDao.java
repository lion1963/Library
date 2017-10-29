package com.botscrew.task.library.dao;

import com.botscrew.task.library.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getBooks();
    public void addBook(Book book);
    public void removeBook(long id);
    public void editBook(Book book);
    public  Book getBookById(long id);

}
