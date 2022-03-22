package es.ulpgc.eite.restaurantmenu.sections;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.app.MenuItem;
import es.ulpgc.eite.restaurantmenu.app.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsModel implements SectionsContract.Model {

  public static String TAG = SectionsModel.class.getSimpleName();

  private MenuItems data;

  public SectionsModel() {

    List<MenuItem> itemsStarters = new ArrayList<>();

    MenuItem itemStarters = new MenuItem();
    itemStarters.itemName = "First Starter";
    itemStarters.itemPrice = 8;
    itemsStarters.add(itemStarters);

    itemStarters = new MenuItem();
    itemStarters.itemName = "Second Starter";
    itemStarters.itemPrice = 9;
    itemsStarters.add(itemStarters);

    List<MenuItem> itemsMainCourses= new ArrayList<>();

    MenuItem itemMainCourses = new MenuItem();
    itemMainCourses.itemName = "First Main Course";
    itemMainCourses.itemPrice = 15;
    itemsMainCourses.add(itemMainCourses);

    itemMainCourses = new MenuItem();
    itemMainCourses.itemName = "Second Main Course";
    itemMainCourses.itemPrice = 18;
    itemsMainCourses.add(itemMainCourses);

    List<MenuItem> itemsDesserts= new ArrayList<>();

    MenuItem itemDesserts = new MenuItem();
    itemDesserts.itemName = "First Dessert";
    itemDesserts.itemPrice = 10;
    itemsDesserts.add(itemDesserts);

    itemDesserts = new MenuItem();
    itemDesserts.itemName = "Second Dessert";
    itemDesserts.itemPrice = 8;
    itemsDesserts.add(itemDesserts);

    data = new MenuItems();
    data.itemsDesserts = itemsDesserts;
    data.itemsMainCourses=itemsMainCourses;
    data.itemsStarters=itemsStarters;
  }


  @Override
  public MenuItems getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void onRestartScreen(MenuItems data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(MenuItems data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(MenuItems data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
}