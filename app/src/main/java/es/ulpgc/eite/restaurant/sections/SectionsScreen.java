package es.ulpgc.eite.restaurant.sections;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurant.menu.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsScreen {

  public static void configure(SectionsContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    /*
    MenuItems data= new MenuItems();
    data.arrayStarters =
        context.get().getResources().getStringArray(R.array.items_starters);
    data.arrayMainCourses =
        context.get().getResources().getStringArray(R.array.items_main_courses);
    data.arrayDesserts =
        context.get().getResources().getStringArray(R.array.items_desserts);

    */

    AppMediator mediator = AppMediator.getInstance();

    SectionsContract.Presenter presenter = new SectionsPresenter(mediator);
    //SectionsContract.Model model = new SectionsModel(data);
    SectionsContract.Model model = new SectionsModel();
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
