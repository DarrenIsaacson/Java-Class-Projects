package Exceptions;

import java.io.*;

public class nameWriter {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("Hello Darren.txt");
        BufferedWriter bufWrite = new BufferedWriter(writer);

        bufWrite.write("Hi my name is Darren\n");
        bufWrite.write("My favorite color is black\n");
        bufWrite.write(2545);


        try(BufferedReader bufRead = new BufferedReader(new FileReader("Hello Darrenm.txt"));){

            String line = bufRead.readLine();

            while(line != null){
                System.out.println(line);

                line = bufRead.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Error ");
        }


    }
}
