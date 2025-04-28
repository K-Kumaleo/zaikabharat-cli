package src;

import menus.MenuManager;
import menus.WelcomeScreen;
import services.RecipeManager;

public class Main {
    public static void main(String[] args) {
        WelcomeScreen.display();
        RecipeManager recipeManager = new RecipeManager();
        MenuManager menuManager = new MenuManager(recipeManager);
        menuManager.start();
    }
}
