// By Jagriti Shukla

package models;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private String info;
    private String origin;
    private String totalTime;
    private List<String> ingredients;
    private List<String> tags;
    private String preparationSteps;
    private String recipe;
    private String bestServingWith;
    private String type;
    private boolean isVeg;

    public Recipe(int id, String name, String info, String origin, String totalTime,
                  List<String> ingredients, List<String> tags,
                  String preparationSteps, String recipe, String bestServingWith, String type, boolean isVeg) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.origin = origin;
        this.totalTime = totalTime;
        this.ingredients = ingredients;
        this.tags = tags;
        this.preparationSteps = preparationSteps;
        this.recipe = recipe;
        this.bestServingWith = bestServingWith;
        this.type = type;
        this.isVeg = isVeg;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getInfo() { return info; }
    public String getOrigin() { return origin; }
    public String getTotalTime() { return totalTime; }
    public List<String> getIngredients() { return ingredients; }
    public List<String> getTags() { return tags; }
    public String getPreparationSteps() { return preparationSteps; }
    public String getRecipe() { return recipe; }
    public String getBestServingWith() { return bestServingWith; }
    public String getType() { return type; }
    public boolean isVeg() { return isVeg; }
}
