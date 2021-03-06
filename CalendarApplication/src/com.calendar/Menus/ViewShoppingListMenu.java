package com.calendar.Menus;

import com.calendar.DashBoard;
import com.calendar.ToDo.ShoppingItem;
import com.calendar.ToDo.ShoppingList;
import com.calendar.ToDo.TaskList;

import java.util.Scanner;

public class ViewShoppingListMenu extends Menu {
    private ShoppingList shoppingList;

    private Scanner in = new Scanner(System.in);

    public ViewShoppingListMenu(DashBoard dashBoard, ShoppingList shoppingList) {
        super(dashBoard);
        this.shoppingList = shoppingList;
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 6) {
            printMenu();
            option = in.nextInt();
        }
        switch (option) {
            case 1:
                getDashBoard().addShoppingItem(shoppingList);
                selectOptions();
                break;
            case 2:
                new EditMenu(getDashBoard(), shoppingList).selectOptions();
                break;
            case 3:
                getDashBoard().getCurrentUser().delete(shoppingList);
                System.out.println(shoppingList.getName() + " deleted successfully");
                new MainMenu(getDashBoard()).selectOptions();
                break;
            case 4:
                shoppingList.markDone();
                break;
            case 5:
                getDashBoard().markItemAsBought(shoppingList);
                selectOptions();
                break;
            case 6:
                new MainMenu(getDashBoard()).selectOptions();
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Add new item");
        System.out.println("Option 2: Edit shopping list");
        System.out.println("Option 3: Delete shopping list");
        System.out.println("Option 4: Mark as done");
        System.out.println("Option 5: Mark shopping item as bought");
        System.out.println("Option 6: Back to Main menu");
    }
}
