package VectorCollection;

import java.util.*;

public class MapTry {
  static void main() {
    Library library = new Library();
    Book book = new Book("1", "Arambam", "Thareathu");
    library.add("1", book);
    book = new Book("3", "Kavalan", "Meendum Thareathu");
    library.add("3", book);
    book = new Book("4", "Matta", "Yar");
    library.add("4", book);
    book = new Book("2", "Billa", "Again Thareathu");
    library.add("2", book);

    library.displayAllBooksInInsertionOrder();
    library.displayAllBooksSortedByTitle();
  }
}


  record Book(String isbn, String title, String author) {
}

class Library {
  private final LinkedHashMap<String, Book> books = new LinkedHashMap<String, Book>();

  public void add(String isbn, Book book) {
    this.books.put(isbn, book);
  }

  public Book getBookByIsbn(String isbn) {
    return this.books.get(isbn);
  }

  public void displayAllBooksInInsertionOrder() {
    Set<Map.Entry<String, Book>> set = this.books.entrySet();
    Iterator<Map.Entry<String, Book>> itr = set.iterator();
    System.out.println("Books printed in insertion order");
    while(itr.hasNext()) {
      Book book = itr.next().getValue();
      System.out.printf("ISBN: %s, Title: %s, Author: %s%n", book.isbn(),
          book.title(), book.author());
    }
  }

  public void displayAllBooksSortedByTitle() {
    Set<Map.Entry<String, Book>> set = this.books.entrySet();
    Iterator<Map.Entry<String, Book>> itr = set.iterator();
    TreeMap<String, String> titleSortedBooks = new TreeMap<>();
    System.out.println("Books printed by Title sorting");
    while(itr.hasNext()) {
      Book book = itr.next().getValue();
      titleSortedBooks.put(book.title(), book.isbn());
    }

    titleSortedBooks.forEach((key, value) -> {
      System.out.printf("Title: %s, ISBN: %s%n", key, value);
    });
  }
}
