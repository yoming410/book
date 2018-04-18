//  資工系1B 106021153 郭又銘
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> BookArray = new  ArrayList<>();
        String name;
        String isbn;
        String price;
        String category;
        String publisher;
        String totalPages;

        boolean bool = true;
        while (bool){
            System.out.println("\n *** 書籍管理系統 ***\n==========================");
            System.out.println("1.新增書籍");
            System.out.println("2.查詢書名");
            System.out.println("3.查詢ISBN");
            System.out.println("4.查詢分類");
            System.out.println("5.查詢書籍數量");
            System.out.println("6.結    束");

            int function = sc.nextInt();
            switch (function){
                case 1:  //新增書籍
                    if (BookArray.size() >= 5){
                        System.out.println("書籍數量已達上限(5本)，不能再輸入。");
                        break;
                    }
                    System.out.print("書籍名稱:\t");
                    name = sc.next();
                    System.out.print("ISBN:\t");
                    isbn = sc.next();
                    System.out.print("價格:\t");
                    price = sc.next();
                    System.out.print("分類:\t");
                    category = sc.next();
                    System.out.print("出版社:\t");
                    publisher = sc.next();
                    System.out.print("頁數:\t");
                    totalPages = sc.next();

                    Book book_temp = new Book(name,isbn,price,category,publisher,totalPages);
                    BookArray.add(book_temp);
                    break;

                case 2: //查詢書籍
                    System.out.print("請輸入書名:\t");
                    name = sc.next();
                    for (int i = 0;i < BookArray.size() ;i++){
                        String x = BookArray.get(i).getName();
                        if (x.equals(name)){
                            BookArray.get(i).showInfo();
                            break;
                        }
                    }
                    break;

                case 3: //查詢ISBN
                    System.out.print("請輸入ISBN:\t");
                    isbn = sc.next();
                    for (int i = 0;i < BookArray.size() ;i++){
                        String x = BookArray.get(i).getISBN();
                        if (x.equals(isbn)){
                            BookArray.get(i).showInfo();
                            break;
                        }
                    }
                    break;

                case 4: //查詢分類
                    category = sc.next();
                    for (int i = 0;i < BookArray.size() ;i++) {
                        String x = BookArray.get(i).getCategory();
                        if (x.equals(category)) {
                            BookArray.get(i).showInfo();
                        }
                    }
                    break;

                case 5: //查詢書籍數量
                    for (int i = 0;i < BookArray.size() ;i++){
                        // System.out.println(BookArray.get(i).name+", ISBN:"+BookArray.get(i).isbn+","+BookArray.get(i).price+"元, "+BookArray.get(i).category+", "+BookArray.get(i).publisher+","+BookArray.get(i).totalPages+"頁");
                        BookArray.get(i).showInfo();
                    }
                    System.out.println("系統現在有" + BookArray.size() + "本書");
                    break;

                case 6: //結    束
                    System.out.println("Bye-Bye!");
                    System.exit(0);
                    break;

                default:
                    bool = false;
                    break;
            }
        }
    }
}
// = = = = = = = = = = = = = =
class Book {
    String name;
    String isbn;
    String price;
    String category;
    String publisher;
    String totalPages;

    Book(String name, String isbn, String price, String category, String publisher, String totalPages) {
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
        this.publisher = publisher;
        this.totalPages = totalPages;
    }

    public String getName(){
        return this.name;
    }

    public String getISBN(){
        return this.isbn;
    }

    public String getPrice(){
        return this.price;
    }

    public String getCategory(){
        return this.category;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public String getTotalPages(){
        return this.totalPages;
    }

    public void showInfo(){
        System.out.println(this.name+","+this.publisher+",(ISBN:"+this.isbn+",$"+this.price+")");
    }
}
