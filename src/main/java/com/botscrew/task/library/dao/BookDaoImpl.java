package com.botscrew.task.library.dao;

import com.botscrew.task.library.model.Book;
import com.botscrew.task.library.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    public List<Book> getBooks(){
        List<Book> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        list = session.createQuery("FROM Book").list();
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
        return list;
    }

    public List<Book> getBooks(String name){
        List<Book> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        list = session.createQuery("FROM Book WHERE name=\'"+name+"\'").list();
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
        return list;
    }

    public Book getBookById(long id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Book book = (Book)session.get(Book.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
        return book;
    }

    public  void addBook(Book book){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
    }

    public void editBook(Book book){
        Book newBook = new Book();
        newBook.setId(book.getId());
        newBook.setAuthor(book.getAuthor());
        newBook.setName(book.getName());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(newBook);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
    }

    public void removeBook(long id){
        Book book = getBookById(id);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        HibernateUtil.closeSession(session);
    }
}
