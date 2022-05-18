package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;
import es.ulpgc.eite.restaurantmenu.data.MenuSection;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsPresenter implements SectionsContract.Presenter {

  public static String TAG = SectionsPresenter.class.getSimpleName();

  private WeakReference<SectionsContract.View> view;
  private SectionsState state;
  private SectionsContract.Model model;
  private AppMediator mediator;

  public SectionsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getSectionsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state 
    //state = new SectionsState();

    // call the model and update the state
    //MenuItems menuItems = model.getStoredData();

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model if is necessary
    //model.onRestartScreen(state.itemStarters);

    /*
    Log.e(TAG, "menuSection:" + state.menuSection);
    Log.e(TAG, "itemStarters:" + state.itemStarters);
    Log.e(TAG, "itemMainCourses:" + state.itemMainCourses);
    Log.e(TAG, "itemDesserts:" + state.itemDesserts);
    */
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    ItemsToSectionsState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      //model.onDataFromNextScreen(savedState.itemSection);

      // update the state if is necessary
      MenuItem itemSection = savedState.itemSection;

      if(state.menuSection == MenuSection.Starters) {
        state.itemStarters = itemSection;
      }

      if(state.menuSection == MenuSection.Desserts) {
        state.itemDesserts = itemSection;
      }

      if(state.menuSection == MenuSection.MainCourses) {
        state.itemMainCourses = itemSection;
      }

      //state.priceMenu += itemSection.itemPrice;

    }

    state.priceMenu = (state.itemStarters != null ? state.itemStarters.itemPrice : 0)
        + (state.itemMainCourses != null ? state.itemMainCourses.itemPrice : 0)
        + (state.itemDesserts != null ? state.itemDesserts.itemPrice : 0);



    Log.e(TAG, "menuSection:" + state.menuSection);
    Log.e(TAG, "itemStarters:" + state.itemStarters);
    Log.e(TAG, "itemMainCourses:" + state.itemMainCourses);
    Log.e(TAG, "itemDesserts:" + state.itemDesserts);


    // call the model and update the state
    //MenuItems menuItems = model.getStoredData();


    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    Log.e(TAG, "menuSection:" + state.menuSection);
    Log.e(TAG, "itemStarters:" + state.itemStarters);
    Log.e(TAG, "itemMainCourses:" + state.itemMainCourses);
    Log.e(TAG, "itemDesserts:" + state.itemDesserts);
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onStartersBtnClicked() {
    SectionsToItemsState newState = new SectionsToItemsState();
    state.menuSection = MenuSection.Starters;
    MenuItems menuItems = model.getStoredData();
    newState.itemsSection = menuItems.itemsStarters;
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
  }

  @Override
  public void onMainCoursesBtnClicked() {
    SectionsToItemsState newState = new SectionsToItemsState();
    state.menuSection = MenuSection.MainCourses;
    MenuItems menuItems = model.getStoredData();
    newState.itemsSection = menuItems.itemsMainCourses;
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
  }

  @Override
  public void onDessertsBtnClicked() {
    SectionsToItemsState newState = new SectionsToItemsState();
    state.menuSection = MenuSection.Desserts;
    MenuItems menuItems = model.getStoredData();
    newState.itemsSection = menuItems.itemsDesserts;
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
  }

  private ItemsToSectionsState getStateFromNextScreen() {
    return mediator.getItemsToSectionsState();
  }

  private void passStateToNextScreen(SectionsToItemsState state) {
    mediator.setSectionsToItemsState(state);
  }


  @Override
  public void injectView(WeakReference<SectionsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SectionsContract.Model model) {
    this.model = model;
  }

}
