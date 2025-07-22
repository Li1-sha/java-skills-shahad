public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("More Than This","Patrick Ness",480);
        Book book2 = new Book("Dark Matter","Blake Crouch",368);
        Textbook textbook1 = new Textbook("Introduction to Algorithms","Thomas H. Cormen",1312,"Computer Science",3);

        book1.displayInfo();
        book1.borrowBook();
        book1.returnBook();
        System.out.println();

        book2.displayInfo();
        book2.borrowBook();
        System.out.println();

        textbook1.displayInfo();
        textbook1.borrowBook();
        System.out.println();

        book1.displayInfo();
        book2.displayInfo();
        textbook1.displayInfo();
    }
}
