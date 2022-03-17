package es.ulpgc.eite.restaurant.sections;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurant.menu.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public interface SectionsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(SectionsViewModel viewModel);

    void navigateToNextScreen();
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

    void onStartersBtnClicked();

    void onMainCoursesBtnClicked();

    void onDessertsBtnClicked();
  }

  interface Model {
    MenuItems getStoredData();

    void onDataFromNextScreen(MenuItems data);

    void onRestartScreen(MenuItems data);

    void onDataFromPreviousScreen(MenuItems data);
  }

}
