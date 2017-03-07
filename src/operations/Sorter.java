package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
  // the sorter class that sorts the Author's names by alphabetical order
  public static ArrayList<String> SortName(ArrayList<String> list) {
    // uses the collections utility to sort the list of names
    Collections.sort(list);
    return list;

  }
}
