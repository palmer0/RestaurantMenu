package es.ulpgc.eite.restaurantmenu;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Luis on mayo, 2022
 */
@RunWith(RobolectricTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestaurantMenuTests {

  RestaurantMenuSteps steps = new RestaurantMenuSteps();


  @Test
  public void T01ChooseStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Starters");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("10 euros", "First Starter");
    steps.appShowPriceOnItem("9 euros", "Second Starter");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T02ChooseMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Main Courses");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("15 euros", "Main Courses");
    steps.appShowPriceOnItem("18 euros", "Main Courses");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T03ChooseDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Desserts");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("7 euros", "First Starter");
    steps.appShowPriceOnItem("8 euros", "Second Starter");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T04ChooseFirstStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");
    steps.userPressSection("Starters");
    // And app start "Menu Items" screen
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("10 euros", "First Starter");
    steps.appShowPriceOnItem("9 euros", "Second Starter");

    // When
    steps.userPressItem("First Starter");

    // Then
    steps.appResumeMainScreen();
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("10 euros", "Total Price");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T05ChooseSecondStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("10 euros", "First Starter");
    steps.appShowPriceOnItem("9 euros", "Second Starter");

    // When
    steps.userPressItem("Second Starter");

    // Then
    steps.appResumeMainScreen();
    steps.appShowTextOnSection("Second Starter", "Starters");
    steps.appShowPriceOnSection("9 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("9 euros", "Total Price");

    // Reset
    steps.resetTest();
  }
}
