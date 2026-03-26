package main.git.Tree;

import main.git.Objects.Tree;

public record TreeEntry(
    TreeEntryMode mode,
    String name,
    String hash
) implements Comparable<TreeEntry> {
    @Override
    public int compareTo(TreeEntry other){
        return name.compareTo(other.name);
    }
}
