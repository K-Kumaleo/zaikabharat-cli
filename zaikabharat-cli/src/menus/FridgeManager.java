package menus;

import models.Recipe;
import services.RecipeManager;
import utils.InputHelper;

import java.util.*;
import java.util.stream.Collectors;

public class FridgeManager {

    private RecipeManager recipeManager;

    public FridgeManager(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;
    }

    public void start() {
        List<String> allIngredients = getAllUniqueIngredients();

        if (allIngredients.isEmpty()) {
            System.out.println("No ingredients found in the database!");
            return;
        }

        System.out.println("\n=== My Fridge ===");
        System.out.println("Select the ingredients you have:");
        for (int i = 0; i < allIngredients.size(); i++) {
            System.out.println((i + 1) + ". " + allIngredients.get(i));
        }

        System.out.println("\nEnter ingredient numbers separated by space (e.g., 1 5 9), or 0 to cancel:");
        String input = InputHelper.readLine().trim();

        if (input.equals("0")) {
            System.out.println("Returning to Main Menu...");
            return;
        }

        List<Integer> selectedIndexes = parseInputIndexes(input, allIngredients.size());

        if (selectedIndexes.isEmpty()) {
            System.out.println("Invalid input. Returning to Main Menu...");
            return;
        }

        List<String> selectedIngredients = selectedIndexes.stream()
                .map(i -> allIngredients.get(i - 1))
                .collect(Collectors.toList());

        findRecipesWithIngredients(selectedIngredients);
    }

    private List<String> getAllUniqueIngredients() {
        Set<String> ingredientSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        List<String> commonItems = Arrays.asList(
                "water", "salt", "oil", "ghee", "sugar", "spices",
                "black salt", "cumin", "coriander powder", "turmeric",
                "red chili powder", "cardamom", "cloves", "black pepper", "mustard seeds"
        );

        for (Recipe r : recipeManager.getAllRecipes()) {
            for (String ingredient : r.getIngredients()) {
                String cleaned = ingredient.trim().toLowerCase();
                if (!commonItems.contains(cleaned)) {
                    ingredientSet.add(ingredient.trim());
                }
            }
        }
        return new ArrayList<>(ingredientSet);
    }

    private List<Integer> parseInputIndexes(String input, int maxIndex) {
        List<Integer> indexes = new ArrayList<>();
        try {
            String[] parts = input.split("\\s+");
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num > 0 && num <= maxIndex) {
                    indexes.add(num);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format!");
        }
        return indexes;
    }

    private void findRecipesWithIngredients(List<String> selectedIngredients) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipeManager.getAllRecipes()) {
            long matchedCount = recipe.getIngredients().stream()
                    .filter(ing -> selectedIngredients.stream()
                            .anyMatch(sel -> sel.equalsIgnoreCase(ing.trim())))
                    .count();
            if (matchedCount > 0) {
                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {
            System.out.println("\nNo recipes found with your selected ingredients!");
            return;
        }

        System.out.println("\nRecipes you can try:");
        for (int i = 0; i < matchingRecipes.size(); i++) {
            Recipe r = matchingRecipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getTotalTime() + ")");
        }

        System.out.println("\nEnter number to view recipe, or 0 to go back:");
        int choice = InputHelper.readInt();

        if (choice <= 0 || choice > matchingRecipes.size()) {
            return;
        }

        Recipe selectedRecipe = matchingRecipes.get(choice - 1);
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

        System.out.println("\nPress Enter to return...");
        InputHelper.readLine();
    }
}
