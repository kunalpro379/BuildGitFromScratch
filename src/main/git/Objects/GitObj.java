package main.git.Objects;
/* 
Blob → file content
Tree → directory
Commit → snapshot
*/
public sealed interface GitObj permits  Blob, Commit, Tree {
    
}
