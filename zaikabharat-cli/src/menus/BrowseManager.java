package menus;

import models.Recipe;
import services.RecipeManager;
import utils.InputHelper;

import java.util.List;

public class BrowseManager {

    private RecipeManager recipeManager;

    public BrowseManager(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;
    }

    public void browseRecipes() {
        List<Recipe> recipes = recipeManager.getAllRecipes();

        if (recipes.isEmpty()) {
            System.out.println("No recipes available!");
            return;
        }

        System.out.println("\nAvailable Recipes:");
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getTotalTime() + ")");
        }

        System.out.println("\nEnter the number of the recipe you want to view (0 to return):");
        int choice = InputHelper.readInt();

        if (choice <= 0 || choice > recipes.size()) {
            System.out.println("Returning to Main Menu...");
            return;
        }

        Recipe selectedRecipe = recipes.get(choice - 1);
        displayRecipeDetails(selectedRecipe);
    }

    private void displayRecipeDetails(Recipe recipe) {
        System.out.println("\n=== " + recipe.getName() + " ===");
        System.out.println("Origin: " + recipe.getOrigin());
        System.out.println("Total Time: " + recipe.getTotalTime());
        System.out.println("Ingredients: " + String.join(", ", recipe.getIngredients()));
        System.out.println("\nPreparation Steps: " + recipe.getPreparationSteps());
        System.out.println("\nRecipe Instructions: " + recipe.getRecipe());
        System.out.println("\nBest Served With: " + recipe.getBestServingWith());
        System.out.println("\nEnjoy your meal!");

        System.out.println("\nPress Enter to go back...");
        InputHelper.readLine();
    }
}
