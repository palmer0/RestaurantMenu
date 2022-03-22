package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsPresenter implements ItemsContract.Presenter {

  public static String TAG = ItemsPresenter.class.getSimpleName();

  private WeakReference<ItemsContract.View> view;
  private ItemsState state;
  private ItemsContract.Model model;
  private AppMediator mediator;

  public ItemsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getItemsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state 
    //state = new ItemsState();

    // call the model and update the state
    //state.itemsSection = model.getStoredData();

    // use passed state if is necessary
    SectionsToItemsState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      //model.onDataFromPreviousScreen(savedState.itemsSection);

      // update the state if is necessary
      state.itemsSection = savedState.itemsSection;

    }
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model if is necessary
    //model.onRestartScreen(state.itemsSection);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // call the model and update the state
    //state.itemsSection = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }


  @Override
  public void onFirstBtnClicked() {
    ItemsToSectionsState newState= new ItemsToSectionsState();
    newState.itemSection = state.itemsSection.get(0);
    passStateToPreviousScreen(newState);
    view.get().navigateToPreviousScreen();
  }

  @Override
  public void onSecondBtnClicked() {
    ItemsToSectionsState newState= new ItemsToSectionsState();
    newState.itemSection = state.itemsSection.get(1);
    passStateToPreviousScreen(newState);
    view.get().navigateToPreviousScreen();
  }


  private void passStateToPreviousScreen(ItemsToSectionsState state) {
    mediator.setItemsToSectionsState(state);
  }

  private SectionsToItemsState getStateFromPreviousScreen() {
    return mediator.getSectionsToItemsState();
  }

  @Override
  public void injectView(WeakReference<ItemsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemsContract.Model model) {
    this.model = model;
  }

}
