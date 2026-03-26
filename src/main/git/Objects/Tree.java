package main.git.Objects;

import java.util.List;

import git.Tree.TreeEntry;
public record Tree(List<TreeEntry>entries) implements GitObj {
}
