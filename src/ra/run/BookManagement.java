package ra.run;
import ra.bussiness.Book;
import java.util.Scanner;
public class BookManagement {
    private static Book[] Book = new Book[1000];
    private static Scanner scanner = new Scanner(System.in);
    private static int currentIndex = 0;
    public static void main(String[] args) {
        do {
            System.out.println("========MENU=======");
            System.out.println("1.Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2.Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3.Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4.Xóa sách theo mã sách");
            System.out.println("5.Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6.Thay đổi thông tin sách theo mã sách");
            System.out.println("7.Thoát");
            int menu = Integer.parseInt(scanner.nextLine());
            switch (menu){
                case 1:
                    System.out.print("Nhập số lượng sách cần thêm mới: ");
                    int numBooksToAdd = Integer.parseInt(scanner.nextLine());
                    if(numBooksToAdd + currentIndex < 1000){
                        for (int i = currentIndex; i < numBooksToAdd; i++) {
                            Book[currentIndex] = new Book();
                            Book[currentIndex].inputData(scanner);
                            currentIndex++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        Book[i].displayData();
                    }
                    break;
                case 3:
                    sortInterest();
                    for (int i = 0; i < currentIndex; i++) {
                        Book[i].displayData();
                    }
                    break;
                case 4:
                    deleteBook();
                    currentIndex--;
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    updateBook(scanner);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("yêu cầu nhập từ 1--- 7");
            }
        }while (true);
    }
    public static void sortInterest(){
        for (int i = 0; i < currentIndex -1; i++) {
            for (int j = i+1; j < currentIndex; j++) {
                if(Book[i].getInterest() < Book[j].getInterest()){
                    Book temp = Book[j];
                    Book[j] = Book[i];
                    Book[i] = temp;
                }

            }

        }
    }
    public static void deleteBook(){
        System.out.println("Nhập mã sách cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if(Book[i].getBookId() == deleteId){
                index = i;
                break;
            }
        }
        if(index == -1 ){
            System.out.println("Mã sách không tìm thấy");
        }else {
            for (int i = 0; i < currentIndex; i++) {
                for (int j = deleteId; j < currentIndex - 1; j++) {
                    Book[j] = Book[j + 1];
                }
            }

        }
    }
    public static void search(){
        System.out.println("Nhập tên sách tìm kiếm");
        String searchName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if(Book[i].getBookName().toLowerCase().contains(searchName.toLowerCase()) || Book[i].getDescriptions().toLowerCase().contains(searchName.toLowerCase())){
                Book[i].displayData();
            }
        }
    }

    private static void updateBook(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Thư viện sách đang trống.");
            return;
        }

        System.out.print("Nhập mã sách cần cập nhật: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        for (Book book : Book) {
            if (book.getBookId() == bookId) {
                book.inputData(scanner);
                book.getInterest();
                System.out.println("Thông tin sách đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy sách có mã " + bookId);
    }
}