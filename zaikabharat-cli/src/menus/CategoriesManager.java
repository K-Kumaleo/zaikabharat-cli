package menus;

import models.Recipe;
import services.RecipeManager;
import utils.InputHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesManager {

    private RecipeManager recipeManager;

    public CategoriesManager(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Browse by Categories ===");
            System.out.println("1. Region");
            System.out.println("2. Cooking Method");
            System.out.println("3. Festival/Occasion");
            System.out.println("4. Taste/Flavor");
            System.out.println("5. Temperature (Hot/Cold)");
            System.out.println("6. Sickness/Health Recovery");
            System.out.println("7. Hosteller Special (Instant/No Cooking)");
            System.out.println("8. Return to Main Menu");
            System.out.print("Choose a category type: ");

            int choice = InputHelper.readInt();

            switch (choice) {
                case 1:
                    browseByRegion();
                    break;
                case 2:
                    browseByCookingMethod();
                    break;
                case 3:
                    browseByFestival();
                    break;
                case 4:
                    browseByTaste();
                    break;
                case 5:
                    browseByTemperature();
                    break;
                case 6:
                    browseBySickness();
                    break;
                case 7:
                    browseByHosteller();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private void browseByRegion() {
        System.out.println("\nRegions:");
        System.out.println("1. North India");
        System.out.println("2. South India");
        System.out.println("3. East India");
        System.out.println("4. West India");
        System.out.println("5. Return");
        System.out.print("Choose a region: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("north_india");
                break;
            case 2:
                showRecipesByTag("south_india");
                break;
            case 3:
                showRecipesByTag("east_india");
                break;
            case 4:
                showRecipesByTag("west_india");
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid region choice.");
        }
    }

    private void browseByCookingMethod() {
        System.out.println("\nCooking Methods:");
        System.out.println("1. Fried");
        System.out.println("2. Steamed");
        System.out.println("3. Grilled");
        System.out.println("4. Baked");
        System.out.println("5. Return");
        System.out.print("Choose a method: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("fried");
                break;
            case 2:
                showRecipesByTag("steamed");
                break;
            case 3:
                showRecipesByTag("grilled");
                break;
            case 4:
                showRecipesByTag("baked");
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid method choice.");
        }
    }

    private void browseByFestival() {
        System.out.println("\nFestivals/Occasions:");
        System.out.println("1. Holi");
        System.out.println("2. Ramadan");
        System.out.println("3. Diwali");
        System.out.println("4. Ganesh Chaturthi");
        System.out.println("5. Return");
        System.out.print("Choose an occasion: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("holi");
                break;
            case 2:
                showRecipesByTag("ramadan");
                break;
            case 3:
                showRecipesByTag("diwali");
                break;
            case 4:
                showRecipesByTag("ganesh_chaturthi");
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid festival choice.");
        }
    }

    private void browseByTaste() {
        System.out.println("\nTaste/Flavor:");
        System.out.println("1. Sweet");
        System.out.println("2. Spicy");
        System.out.println("3. Sour");
        System.out.println("4. Bitter");
        System.out.println("5. Refreshing");
        System.out.println("6. Return");
        System.out.print("Choose a taste: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("sweet");
                break;
            case 2:
                showRecipesByTag("spicy");
                break;
            case 3:
                showRecipesByTag("sour");
                break;
            case 4:
                showRecipesByTag("bitter");
                break;
            case 5:
                showRecipesByTag("refreshing");
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid taste choice.");
        }
    }

    private void browseByTemperature() {
        System.out.println("\nTemperature:");
        System.out.println("1. Hot");
        System.out.println("2. Cold");
        System.out.println("3. Return");
        System.out.print("Choose temperature: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("hot");
                break;
            case 2:
                showRecipesByTag("cold");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void browseBySickness() {
        System.out.println("\nSickness/Health Recovery:");
        System.out.println("1. Cold Remedy");
        System.out.println("2. Period Cramps");
        System.out.println("3. Flu Recovery");
        System.out.println("4. Return");
        System.out.print("Choose a condition: ");
        int choice = InputHelper.readInt();

        switch (choice) {
            case 1:
                showRecipesByTag("cold_remedy");
                break;
            case 2:
                showRecipesByTag("period_cramps");
                break;
            case 3:
                showRecipesByTag("flu_recovery");
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void browseByHosteller() {
        showRecipesByTag("hosteller");
    }


    private void showRecipesByTag(String tag) {
        List<Recipe> matchedRecipes = recipeManager.getAllRecipes().stream()
                .filter(r -> r.getTags().stream().anyMatch(t -> t.trim().equalsIgnoreCase(tag)))
                .collect(Collectors.toList());

        if (matchedRecipes.isEmpty()) {
            System.out.println("\nNo recipes found for this category!");
            return;
        }

        System.out.println("\nRecipes:");
        for (int i = 0; i < matchedRecipes.size(); i++) {
            Recipe r = matchedRecipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getTotalTime() + ")");
        }

        System.out.println("\nEnter number to view recipe, or 0 to go back:");
        int choice = InputHelper.readInt();

        if (choice <= 0 || choice > matchedRecipes.size()) {
            return;
        }

        Recipe selectedRecipe = matchedRecipes.get(choice - 1);
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
