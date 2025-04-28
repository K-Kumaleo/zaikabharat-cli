// By Jay Gupta
// By Kaavya K. Yadav

package services;

import db.DatabaseManager;
import models.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        recipes = new ArrayList<>();
        loadRecipes();
    }

    private void loadRecipes() {
        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM recipes");

            while (rs.next()) {
                Recipe recipe = new Recipe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("info"),
                        rs.getString("origin"),
                        rs.getString("total_time"),
                        Arrays.asList(rs.getString("ingredients").split(",")),
                        Arrays.asList(rs.getString("tags").split(",")),
                        rs.getString("preparation_steps"),
                        rs.getString("recipe"),
                        rs.getString("best_serving_with"),
                        rs.getString("type"),
                        rs.getBoolean("isVeg")
                );
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }
}
