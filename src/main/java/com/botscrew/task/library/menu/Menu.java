package com.botscrew.task.library.menu;

import com.botscrew.task.library.util.NumberScanner;

public class Menu {
    private  MenuController menuController = new MenuController();
    private NumberScanner numberScanner = NumberScanner.getInstance();

    public void start(){
        int choice =0;
        while (choice!=5){
            System.out.println("\n1. Get books\n"+
            "2. Add book\n"+
            "3. Remove book\n"+
            "4. Edit book\n"+
            "5. Exit\n");
            choice = numberScanner.nextInt();
            switch (choice){
                case 1: menuController.getBooks();
                break;
                case 2: menuController.addBook();
                break;
                case 3: menuController.removeBook();
                break;
                case 4: menuController.editBook();
                break;
                case 5: System.exit(0);
                break;
                default: System.out.println("Please, enter correct number!");
            }
        }
    }
}
