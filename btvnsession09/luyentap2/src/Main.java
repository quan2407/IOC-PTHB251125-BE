import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("A","A author",209));
        books.add(new Book("B","B author",209));
        books.add(new Book("C","C author",209));
        for (Book book : books) {
            book.printInfo();
        }
    }
}