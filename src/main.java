package git;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.zip.DataFormatException;
public class main{
    public static final Path HERE = Paths.get(".");

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException,  DataFormatExceptio{
        final var command =args[0];
        switch (command){
            case "Initialize"-> init(args[2]);
            case "CatFile"->CatFile(args[2]);
            case "HashObj"-> HashObj(args[2]);
            case "LsTree"->LsTree(args[2]);
            case "WriteTree"-> WriteTree();
            case "CommitTree"->CommitTree(args[1], args[3], args[5]);
            case "Copy"-> Clone(args[1], args[2]);
            default-> System.out.println("Unknown command: " + command);
         }
    }
}