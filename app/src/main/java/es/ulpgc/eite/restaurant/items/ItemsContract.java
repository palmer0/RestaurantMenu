package es.ulpgc.eite.restaurant.items;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.restaurant.menu.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public interface ItemsContract {

  interface View {
    void navigateToPreviousScreen();

    void injectPresenter(Presenter presenter);

    void onDataUpdated(ItemsViewModel viewModel);

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onSecondBtnClicked();

    void onFirstBtnClicked();
  }

  interface Model {
    List<MenuItem> getStoredData();

    void onDataFromNextScreen(List<MenuItem> data);

    void onRestartScreen(List<MenuItem> data);

    void onDataFromPreviousScreen(List<MenuItem> data);
  }

}
