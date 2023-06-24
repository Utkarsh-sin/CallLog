import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  public static void main(String[] args) {
    List<String> start=new ArrayList<>();
    List<String> end=new ArrayList<>();
    try {
      File myObj = new File("callLog.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] data2=data.split(":");
        start.add(data2[0]);
        end.add(data2[1]);
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error : File not found");
    }
    System.out.println(start);
    System.out.println(end);
    Scanner sc=new Scanner(System.in);
    Long timestamp = sc.nextLong();
    int countActive=0;
    for(int i=0;i<start.size();i++){
      try {
        Long getStart = Long.valueOf(start.get(i).trim());
        Long getend = Long.valueOf(start.get(i).trim());
        if(timestamp>=getStart && timestamp<=getend) countActive++;
      }
      catch(NumberFormatException e) {
        System.out.println(e);
      }
    }
    System.out.println(countActive);

  }
}