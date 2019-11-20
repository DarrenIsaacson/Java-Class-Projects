package Exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class exceptionsTest {

    public static void main(String[] args)  throws IOException {

        FileWriter writer = new FileWriter("hello.txt");
        BufferedWriter bufwriter = new BufferedWriter(writer);

        bufwriter.write("Hello\n");
        bufwriter.write("Data here\n");
        bufwriter.write("Goodbye\n");
        bufwriter.close();

    }
    

}
