package main.git.Objects;
//record is a special kind of class whose main purpose is to store immutable data.
public record Blob(byte[] data)implements GitObj {
    
}
