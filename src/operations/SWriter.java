package operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SWriter {
  private ArrayList<String> Authors = new ArrayList<String>();
  private ArrayList<ArrayList<String>> Values =
      new ArrayList<ArrayList<String>>();

  public SWriter() {
    // empty constructor for this class
  }

  public void AddAuthors(ArrayList<String> Authors) {
    // setter method for the authors
    this.Authors.addAll(Authors);
  }

  public void AddValues(ArrayList<String> Values) {
    // setting method for the list of values
    this.Values.add(Values);
  }

  public void WriteOut() {
    // the writer method to write out to console
    for (int x = Values.size() - 1; x >= 0; x--) {
      // using a backwards for loop to print out the data
      ArrayList<String> value = new ArrayList<String>(Values.get(x));
      // prints the data to console
      System.out
          .println("-----------------------------------------------------------"
              + "------------");
      System.out.println("1. Name of Author:");
      System.out.println("      " + value.get(0));
      System.out.println("2. Number of All Citations:");
      System.out.println("      " + value.get(1));
      System.out.println("3. Number of i10-index after 2009:");
      System.out.println("      " + value.get(2));
      System.out.println("4. Title of the first 3 publications:");
      for (int i = 0; i < 3; i++) {
        System.out.println("      " + (i + 1) + "- " + value.get(i + 2));
      }
      System.out.println("5. Total paper citation (first 5 papers):");
      System.out.println("      " + value.get(6));
      System.out.println("6. Total Co-Authors:");
      System.out.println("      " + value.get(7));
    }
    System.out
        .println("\n-------------------------------------------------------------"
            + "----------");
    System.out.println("7. Co-Author list sorted (Total: 29):");
    Authors = Sorter.SortName(Authors);
    for (String value : Authors) {
      // a for loop for authors and prints to console
      System.out.println(value);
    }
  }

  public void WriteOut(String FName) throws IOException {
    try {
      // write to file with bufferedwriter
      File file = new File(FName + ".txt");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      for (int x = Values.size() - 1; x >= 0; x--) {
        // backwards loop for writing to file
        ArrayList<String> value = new ArrayList<String>(Values.get(x));
        // writes to file
        output
            .write("-----------------------------------------------------------"
                + "------------");
        output.newLine();
        output.write("1. Name of Author:");
        output.newLine();
        output.write("      " + value.get(0));
        output.newLine();
        output.write("2. Number of All Citations:");
        output.newLine();
        output.write("      " + value.get(1));
        output.newLine();
        output.write("3. Number of i10-index after 2009:");
        output.newLine();
        output.write("      " + value.get(2));
        output.newLine();
        output.write("4. Title of the first 3 publications:");
        output.newLine();
        for (int i = 0; i < 3; i++) {
          output.write("      " + (i + 1) + "- " + value.get(i + 2));
          output.newLine();
        }
        output.write("5. Total paper citation (first 5 papers):");
        output.newLine();
        output.write("      " + value.get(6));
        output.newLine();
        output.write("6. Total Co-Authors:");
        output.newLine();
        output.write("      " + value.get(7));
        output.newLine();
      }
      output
          .write("-----------------------------------------------------------"
              + "------------");
      output.newLine();
      output.write("7. Co-Author list sorted (Total: 29):");
      output.newLine();
      // sorts the authors list
      Authors = Sorter.SortName(Authors);
      for (String value : Authors) {
        // for loop for authors and writes to file
        output.write(value);
        output.newLine();
      }
      // closes the file stream
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
