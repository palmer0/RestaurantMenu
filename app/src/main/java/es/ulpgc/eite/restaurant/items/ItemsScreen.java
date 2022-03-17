package es.ulpgc.eite.restaurant.items;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurant.menu.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsScreen {

  public static void configure(ItemsContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    AppMediator mediator = AppMediator.getInstance();

    ItemsContract.Presenter presenter = new ItemsPresenter(mediator);
    ItemsContract.Model model = new ItemsModel();
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
