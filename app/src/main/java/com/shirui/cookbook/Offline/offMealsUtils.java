package com.shirui.cookbook.Offline;

import com.shirui.cookbook.R;

import java.util.ArrayList;
import java.util.List;

public class offMealsUtils {

    private static final String[] Meal = {"Spicy Arrabiata Penne", "Apple Frangipan Tart", "Apple & Blackberry Crumble",
            "Teriyaki Chicken Casserole", "Bitterballen (Dutch Meatballs)"};

    private static final String[] Category = {"Vegetarian", "Dessert", "Dessert", "Chicken", "Beef"};

    private static final String[] Tag = {"Pasta, Curry", "Tart, Baking, Fruity", "Pudding", "Meat, Casserole",
            "DinnerParty, HangoverFood, Alcoholic"};

    private static final int[] ID = {R.drawable.sap, R.drawable.aft, R.drawable.abc, R.drawable.tcc, R.drawable.bdm};

    private static final String[] Ingredients = {"Penne rigate\nOlive oil\nGarlic\nChopped Tomatoes\nRed Chile Flakes\nItalian Seasoning\nBasil\nParmigiano-Reggiano",
            "Digestive Biscuits\nButter\nBramley Apples\nButter, Softened\nCaster Sugar\nFree-range Eggs, Beaten\nGround Almonds\nAlmond Extract\nFlaked Almonds",
            "Plain Flour\nCaster Sugar\nButter\nBraeburn Apples\nButter\nDemerara Sugar\nBlackberrys\nCinnamon\nIce Cream",
            "Soy Sauce\nWater\nBrown Sugar\nGround Ginger\nMinced Garlic\nCornstarch\nChicken Breasts\nStir-fry Vegetables\nBrown Rice",
            "Butter\nFlour\nBeef Stock\nOnion\nParsley\nBeef\nSalt\nPepper\nNutmeg\nFlour\nBeaten Eggs\nBreadcrumds"};

    private static final String[] Measure = {"1 pound\n1/4 cup\n3 cloves\n1 tin\n1/2 teaspoon\n1/2 teaspoon\n6 leaves\nspinkling",
            "175g/6oz\n75g/3oz\n200g/7oz\n75g/3oz\n75g/3oz\n2\n75g/3oz\n1 tsp\n50g/1¾oz",
            "120g\n60g\n60g\n300g\n30g\n30g\n120g\n¼ teaspoon\nto serve",
            "3/4 cup\n1/2 cup\n1/4 cup\n1/2 teaspoon\n1/2 teaspoon\n4 Tablespoons\n2\n1 (12 oz.)\n3 cups",
            "100g\n150g\n700ml\n30g\n1 tbs\n400g\nPinch\nPinch\nPinch\n50g\n2\n20g"};

    private static final String[] Step = {"Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\n" +
            "In a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\n" +
            "Drain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
            "Preheat the oven to 200C/180C Fan/Gas 6.\n" +
                    "Put the biscuits in a large re-sealable freezer bag and bash with a rolling pin into fine crumbs. Melt the butter in a small pan, then add the biscuit crumbs and stir until coated with butter. Tip into the tart tin and, using the back of a spoon, press over the base and sides of the tin to give an even layer. Chill in the fridge while you make the filling.\n" +
                    "Cream together the butter and sugar until light and fluffy. You can do this in a food processor if you have one. Process for 2-3 minutes. Mix in the eggs, then add the ground almonds and almond extract and blend until well combined.\n" +
                    "Peel the apples, and cut thin slices of apple. Do this at the last minute to prevent the apple going brown. Arrange the slices over the biscuit base. Spread the frangipane filling evenly on top. Level the surface and sprinkle with the flaked almonds.\n" +
                    "Bake for 20-25 minutes until golden-brown and set.\n" +
                    "Remove from the oven and leave to cool for 15 minutes. Remove the sides of the tin. An easy way to do this is to stand the tin on a can of beans and push down gently on the edges of the tin.\n" +
                    "Transfer the tart, with the tin base attached, to a serving plate. Serve warm with cream, crème fraiche or ice cream.",
            "Heat oven to 190C/170C fan/gas 5. Tip the flour and sugar into a large bowl. Add the butter, then rub into the flour using your fingertips to make a light breadcrumb texture. Do not overwork it or the crumble will become heavy. Sprinkle the mixture evenly over a baking sheet and bake for 15 mins or until lightly coloured.\n" +
                    "Meanwhile, for the compote, peel, core and cut the apples into 2cm dice. Put the butter and sugar in a medium saucepan and melt together over a medium heat. Cook for 3 mins until the mixture turns to a light caramel. Stir in the apples and cook for 3 mins. Add the blackberries and cinnamon, and cook for 3 mins more. Cover, remove from the heat, then leave for 2-3 mins to continue cooking in the warmth of the pan.\n" +
                    "To serve, spoon the warm fruit into an ovenproof gratin dish, top with the crumble mix, then reheat in the oven for 5-10 mins. Serve with vanilla ice cream.",
            "Preheat oven to 350° F. Spray a 9x13-inch baking pan with non-stick spray.\n" +
                    "Combine soy sauce, ½ cup water, brown sugar, ginger and garlic in a small saucepan and cover. Bring to a boil over medium heat. Remove lid and cook for one minute once boiling.\n" +
                    "Meanwhile, stir together the corn starch and 2 tablespoons of water in a separate dish until smooth. Once sauce is boiling, add mixture to the saucepan and stir to combine. Cook until the sauce starts to thicken then remove from heat.\n" +
                    "Place the chicken breasts in the prepared pan. Pour one cup of the sauce over top of chicken. Place chicken in oven and bake 35 minutes or until cooked through. Remove from oven and shred chicken in the dish using two forks.\n" +
                    "*Meanwhile, steam or cook the vegetables according to package directions.\n" +
                    "Add the cooked vegetables and rice to the casserole dish with the chicken. Add most of the remaining sauce, reserving a bit to drizzle over the top when serving. Gently toss everything together in the casserole dish until combined. Return to oven and cook 15 minutes. Remove from oven and let stand 5 minutes before serving. Drizzle each serving with remaining sauce. Enjoy!",
            "Melt the butter in a skillet or pan.\n" +
                    "When melted, add the flour little by little and stir into a thick paste.\n" +
                    "Slowly stir in the stock, making sure the roux absorbs the liquid.\n" +
                    "Simmer for a couple of minutes on a low heat while you stir in the onion, parsley and the shredded meat.\n" +
                    "The mixture should thicken and turn into a heavy, thick sauce.\n" +
                    "Pour the mixture into a shallow container, cover and refrigerate for several hours, or until the sauce has solidified.\n" +
                    "Take a heaping tablespoon of the cold, thick sauce and quickly roll it into a small ball.\n" +
                    "Roll lightly through the flour, then the egg and finally the breadcrumbs.\n" +
                    "Make sure that the egg covers the whole surface of the bitterbal.\n" +
                    "When done, refrigerate the snacks while the oil in your fryer heats up to 190C (375F).\n" +
                    "Fry four bitterballen at a time, until golden.\n" +
                    "Serve on a plate with a nice grainy or spicy mustard."};


    public static List<offMealsBean> getAllMealsList() {
        List<offMealsBean> list = new ArrayList<>();
        for (int i = 0; i < Meal.length; i++) {
            offMealsBean bean = new offMealsBean(Meal[i], Category[i], Tag[i], ID[i], Ingredients[i], Measure[i], Step[i]);
            list.add(bean);
        }
        return list;
    }
}
