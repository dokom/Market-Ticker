package systems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import operations.Reader;
import operations.SWriter;

public class Parser {
  // SWriter new_write = new SWriter();

  public Parser(String input_string) throws IOException {

    // String inputFiles[] = input_string[0].split(",");
    // for (String html : inputFiles) {
    ExtractValues(input_string);
    // }

    // if (input_string.length == 2) {
    // new_write.WriteOut(input_string[1]);
    // } else if (input_string.length == 1) {
    // new_write.WriteOut();
    // }

  }

  private void ExtractValues(String googleScholarURL) throws IOException {
    int buy = 0;
    int sell = 0;
    float buyr = 0;
    float buym = 0;
    float sellm = 0;
    float sellr = 0;
    ArrayList<String> extractedValues = new ArrayList<String>();
    ArrayList<String> coAuthors = new ArrayList<String>();
    URL url = new URL(googleScholarURL);
    BufferedReader in =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String inputLine;
    String strip;
    ArrayList<String[]> valuesarray = new ArrayList<String[]>();
    String[] lst;
    while ((inputLine = in.readLine()) != null) {
      strip =
          inputLine.replaceAll("\"", "").replaceAll("\\{", "")
              .replaceAll("\\}", "");
      lst = strip.split(",");
      for (String i : lst) {
        String[] temp = i.split(":");
        valuesarray.add(temp);
      }
    }
    for (int i = 0; i < valuesarray.size(); i++) {
      if (valuesarray.get(i)[0].equals("lasttradeprice"))
        System.out.print(valuesarray.get(i)[1]);
      if (valuesarray.get(i)[0].equals("type")) {
        if (valuesarray.get(i)[1].equals("Buy")) {
          buy += 1;
          buyr +=
              Float.parseFloat(valuesarray.get(i + 2)[1])
                  / Float.parseFloat(valuesarray.get(i + 1)[1]);
          buym += Float.parseFloat(valuesarray.get(i + 2)[1]);
        } else {
          sell += 1;
          sellr +=
              Float.parseFloat(valuesarray.get(i + 2)[1])
                  / Float.parseFloat(valuesarray.get(i + 1)[1]);
          sellm += Float.parseFloat(valuesarray.get(i + 2)[1]);
        }
      }
    }
    if (buy >= sell) {
      System.out.print(" buy" + "\n");

    } else {
      System.out.print(" sell" + "\n");

    }

    if (buyr / buy >= sellr / sell)
      System.out.print("Actually buy| ratio:" + Float.toString(buyr / buy)
          + " amount: " + Float.toString(buym) + "\n" + " sell| ratio:"
          + Float.toString(sellr / sell) + " amount: " + Float.toString(sellm)
          + "\n");
    else {
      System.out.print("Actually sell| ratio:" + Float.toString(sellr / sell)
          + " amount: " + Float.toString(sellm) + "\n" + " buy| ratio:"
          + Float.toString(buyr / buy) + " amount: " + Float.toString(buym)
          + "\n");
    }
    try {
      Thread.sleep(5000);
      System.out.print("\n\n\n\n\n");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    in.close();
  }
}
