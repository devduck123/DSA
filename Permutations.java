import java.util.Scanner;
import java.util.ArrayList;

public class Permutations {

   // TODO: Write function to create and output all permutations of the list of names.
   public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {

      // get size of nameList
      int size = nameList.size();
      
      // base case -> very last line
      if (size == 0) {
         for (int i = 0; i < permList.size(); ++i) {
            System.out.print(permList.get(i) + " ");
         }
         System.out.println();
      }
      else {
         for (int i = 0; i < size; ++i) {
            
            // create newPerms list with permList values
            ArrayList<String> newPerms = new ArrayList<String>(permList);
            
            // add current name to newPerms list
            newPerms.add(nameList.get(i));
            
            // create newNames list with nameList values
            ArrayList<String> newNames = new ArrayList<String>(nameList);
            
            // remove current name from newNames list
            newNames.remove(i);
            
            // recurse function passing modified lists
            allPermutations(newPerms, newNames);
         }
      }
   }

   public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;
      
      // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
      boolean readNames = true;
      while (readNames) {
         name = reader.next();        
         
         // break out of loop
         if (name.equals("-1")) {
            break; 
         }
         
         nameList.add(name);
         
      }
      reader.close();
      
      // lambda expression (replaces enhanced forloop to print)
      // nameList.forEach(part -> System.out.println(part));
      
      allPermutations(permList, nameList);
   }
}
