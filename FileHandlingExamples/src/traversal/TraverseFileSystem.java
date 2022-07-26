package traversal;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class TraverseFileSystem {
  public static void main(String[] args) {
    try {
      // create object of scanner.
      Scanner KB = new Scanner(System.in);

      // enter path here.
      System.out.print("Enter path here : ");
      String A = KB.next();
      Path path = Paths.get(A);
      ListFiles listFiles = new ListFiles();
      Files.walkFileTree(path, listFiles);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class ListFiles extends SimpleFileVisitor < Path > {
  private final int indentionAmount = 3;
  private int indentionLevel;

  public ListFiles() {
    indentionLevel = 0;
  }

  private void indent() {
    for (int i = 0; i < indentionLevel; i++) {
      System.out.print(' ');
    }
  }

  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
    indent();
    System.out.println("Visiting file:" + file.getFileName());
    return FileVisitResult.CONTINUE;
  }

  public FileVisitResult postVisitDirectory(Path directory, IOException e) throws IOException {
    indentionLevel = indentionAmount;
    indent();
    System.out.println("Finished with the directory: " + directory.getFileName());
    return FileVisitResult.CONTINUE;
  }

  public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes) throws IOException {
    indent();
    System.out.println("About to traverse the directory: " + directory.getFileName());
    indentionLevel += indentionAmount;
    return FileVisitResult.CONTINUE;
  }

  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    System.out.println("A file traversal error ocurred");
    return super.visitFileFailed(file, exc);
  }
}