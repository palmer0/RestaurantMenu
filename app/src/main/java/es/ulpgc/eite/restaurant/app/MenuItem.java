package es.ulpgc.eite.restaurant.app;

import androidx.annotation.NonNull;

/**
 * Created by Luis on marzo, 2022
 */
public class MenuItem {

  public String itemName;
  public Integer itemPrice;


  @NonNull
  @Override
  public String toString() {
    return "{" + itemName + "," + itemPrice + "}";
  }
}
