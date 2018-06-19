import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class fileread {
static Scanner input = new Scanner(System.in);
static File file;
private static void readfile(){
System.out.print("Please enter the name of the file: ");
String newfile = input.nextLine();
file = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/" + newfile);
}


public static void main(String[] args){
readfile();
while(file.exists()){
System.out.println();
System.out.println("file Already exists! Type another file!");
System.out.println();
System.out.println("Size of the file: " +  file.length() + " bytes");
System.out.println();
readfile();
}


}


}
