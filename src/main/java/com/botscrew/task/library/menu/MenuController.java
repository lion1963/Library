package com.botscrew.task.library.menu;

import com.botscrew.task.library.dao.BookDaoImpl;
import com.botscrew.task.library.model.Book;
import com.botscrew.task.library.util.NumberScanner;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class MenuController {

    NumberScanner numberScanner = NumberScanner.getInstance();
    BookDaoImpl bookDao = new BookDaoImpl();
    Scanner scanner = new Scanner(System.in);

    private static final Logger LOG = Logger.getLogger(MenuController.class);

    public void getBooks(){
        List<Book> list =  bookDao.getBooks();
        LOG.info("All books get");
        printList(list);
    }

    public void addBook() {
        System.out.println("Please enter name of  new book");
        String name=scanner.nextLine();
        System.out.println("Please enter author of  new book");
        String author=scanner.nextLine();
        Book book = new Book(name, author);
        bookDao.addBook(book);
        System.out.println("Book was added");
        LOG.info("Book "+book.toString()+" added");
    }

    public void removeBook(){
        System.out.println("Enter name of  book which will be removed(without quotes): ");
        String name=scanner.nextLine();
        List<Book> list = bookDao.getBooks(name);
        if(list.isEmpty()) {
            System.out.println("Sorry! Book not found.");
            LOG.error("Book "+name+" not found");
        }
        else if(list.size()==1) {
            bookDao.removeBook(list.get(0).getId());
            System.out.println("Book was removed");
            LOG.info("Book "+name+" removed");
        } else{
            printList(list);
            System.out.println("Enter number of book which will be removed: ");
            int number = chooseNumber(list.size());
            bookDao.removeBook(list.get(number-1).getId());
            System.out.println("Book was removed");
            LOG.info("Book "+name+" removed");
        }
    }

    public  void editBook(){
        System.out.println("Enter name of  book which will be edited(without quotes): ");
        String name=scanner.nextLine();
        List<Book> list = bookDao.getBooks(name);
        if(list.isEmpty()) {
            System.out.println("Sorry! Book not found.");
            LOG.error("Book "+name+" not found");
        }else if(list.size()==1) {
            System.out.println("Enter new name of the book");
            String newName = scanner.nextLine();
            Book book = list.get(0);
            book.setName(newName);
            bookDao.editBook(book);
            System.out.println("Book was edited");
            LOG.info("Book "+name+" edited");
        } else {
            printList(list);
            System.out.println("Enter number of book which will be edited: ");
            int number = chooseNumber(list.size());
            Book book = bookDao.getBookById(list.get(number-1).getId());
            System.out.println("Enter new name of the book");
            String newName = scanner.nextLine();
            book.setName(newName);
            bookDao.editBook(book);
            System.out.println("Book was edited");
            LOG.info("Book "+name+" edited");

        }

    }
    private int chooseNumber(int size){
        int number = numberScanner.nextInt();
        while (number<1 || number>size){
            System.out.println("Enter correct number!");
            number = numberScanner.nextInt();
        }
        return number;
    }

    private  void printList(List<Book> list){
        int i=1;
        for (Book book: list){
            System.out.println(""+i+". "+book.toString());
            i++;
        }
    }

}
