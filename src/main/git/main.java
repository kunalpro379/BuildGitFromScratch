package git;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.zip.DataFormatException;
import main.git.GIT;
public class main{
    public static final Path HERE = Paths.get(".");
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, DataFormatException 
    {
        System.out.println("Hello, Kunal!");
        final var command = args[0];
        switch (command){
            case "init" -> init();
            default-> System.out.println("Unknown command: " + command);
        }

    }
    public static void init() throws IOException{

    }
}