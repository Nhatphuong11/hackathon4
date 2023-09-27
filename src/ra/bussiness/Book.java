package ra.bussiness;
import java.util.Scanner;
public class Book {
        public static int nextId = 1;
        private int bookId;
        private String bookName;
        private String author;
        private String descriptions;
        private double importPrice;
        private double exportPrice ;
        private float interest;
        private boolean bookStatus = true ;
        public Book() {
            this.bookId = nextId++;
        }
        public Book( String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
            this.bookName = bookName;
            this.author = author;
            this.descriptions = descriptions;
            this.importPrice = importPrice;
            this.exportPrice = exportPrice;
            this.interest = interest;
            this.bookStatus = bookStatus;
        }
        public int getBookId() {
            return bookId;
        }
        public void setBookId(int bookId) {
            this.bookId = bookId;
        }
        public String getBookName() {
            return bookName;
        }
        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public String getDescriptions() {
            return descriptions;
        }
        public void setDescriptions(String descriptions) {
            this.descriptions = descriptions;
        }
        public double getImportPrice() {
            return importPrice;
        }
        public void setImportPrice(double importPrice) {
            this.importPrice = importPrice;
        }
        public double getExportPrice() {
            return exportPrice;
        }
        public void setExportPrice(double exportPrice) {
            this.exportPrice = exportPrice;
        }
        public float getInterest() {
            return interest;
        }
        public void setInterest(float interest) {
            this.interest = (float) (this.exportPrice - this.importPrice);
        }
        public boolean isBookStatus() {
            return bookStatus;
        }
        public void setBookStatus(boolean bookStatus) {
            this.bookStatus = bookStatus;
        }
        public void inputData(Scanner scanner){
            boolean isExit = true;
            System.out.println("Nhập vào tên sách");
            do {
                this.bookName = scanner.nextLine();
                if(this.bookName.length() > 0){
                    break;
                }else {
                    System.out.println("Tên không được bỏ trống");
                }
            }while (isExit);


            System.out.println("nhập vào tác giả");
            do {
                this.author = scanner.nextLine();
                if(this.author.length() > 0){
                    break;
                }else {
                    System.out.println("Tác giả không được bỏ trống");
                }
            }while (isExit);


            System.out.println("Mô tả sản phẩm");
            do {
                this.descriptions = scanner.nextLine();
                if(this.descriptions.length() > 10){
                    break;
                }else {
                    System.out.println("Mô tả ít nhất 10 kí tự");
                }
            }while (isExit);

            System.out.println("Giá nhập");
            do {
                this.importPrice = Double.parseDouble(scanner.nextLine());
                if(this.importPrice > 0){
                    break;
                }else {
                    System.out.println("Giá nhập phải lớn hơn 0");
                }
            }while (isExit);

            System.out.println("Giá bán");
            do {
                this.exportPrice = Double.parseDouble(scanner.nextLine());
                if(this.exportPrice >= this.importPrice*1.2){
                    break;
                }else {
                    System.out.println("Giá bán yêu cầu cao hơn 20% giá nhập");
                }
            }while (isExit);

            this.interest = (float) (this.exportPrice - this.importPrice);

            System.out.println("Nhập trạng thái");
            this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
        }
        public void displayData(){
            System.out.printf("Mã sách: %d - Tên sách: %s - Tác giả: %s - Mô tả: %s\n", this.bookId, this.bookName, this.author, this.descriptions);
            System.out.printf("Giá nhập: %f - Giá bán: %f - Lợi nhuận: %f - Trạng thái: %b\n", this.importPrice, this.exportPrice, this.interest, this.bookStatus);
        }
}
