package menus;

import services.RecipeManager;
import utils.InputHelper;

public class MenuManager {

    private RecipeManager recipeManager;

    public MenuManager(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Welcome to ZaikaBharat CLI =====");
            System.out.println("1. Browse Recipes");
            System.out.println("2. Browse by Categories");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = InputHelper.readInt();

            switch (choice) {
                case 1:
                    BrowseManager browseManager = new BrowseManager(recipeManager);
                    browseManager.browseRecipes();
                    break;
                case 2:
                    CategoriesManager categoriesManager = new CategoriesManager(recipeManager);
                    categoriesManager.start();
                    break;
                case 3:
                    System.out.println("Thank you for visiting ZaikaBharat. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

}
