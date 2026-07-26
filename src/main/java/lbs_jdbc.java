import java.sql.*;
import java.util.Scanner;

public class lbs_jdbc {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        try(Connection conn = dB.getConnetion()) {
            System.out.println("DATABASE is Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            int x;
            System.out.println("1. Create and add more  book");
            System.out.println("2. Create and add more member");
            System.out.println("3. Create and add more data of borrow");
            System.out.println("4. Show Book");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Search Book");
            System.out.println("8. Sort Book");
            System.out.println("9. QUIT");
            System.out.print("Choose number: ");
            if(!scanner.hasNextInt()) {
                System.out.println("Invalid, enter a number");
                scanner.nextLine();
                continue;
            }
            x=scanner.nextInt();
            scanner.nextLine();
            if (x == 1) {
                bookData();
            } else if(x==2) {
                dataMember();
            } else if (x==3) {
                borrowBook();
            } else if (x==4) {
                showBook();
            } else if(x==5) {
                updateBook();
            } else if (x==6) {
                deleteBook();
            } else if (x == 7) {
                searchBook();
            } else if (x==8) {
                sortBook();
            } else if (x == 9) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }

    static void bookData() {
        try (Connection conn = dB.getConnetion()) {
            while(true) {
                System.out.println("Write 'done' in book's title if you're finish");
                System.out.print("Book's title: ");
                String title = scanner.nextLine();
                if (title.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Book's author: ");
                String author = scanner.nextLine();
                Date publish_date;
                System.out.print("Publish Date (yyyy-MM-dd): ");
                try {
                    publish_date= Date.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("INVALID format!, use yyyy-mm-dd");
                    System.out.println("start over");
                    continue;
                }
                System.out.print("Quantity: ");
                int quantity=scanner.nextInt();
                scanner.nextLine();
                String SQL= "INSERT INTO books(title, author, publish_date, quantity) VALUES(?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setString(1, title);
                ps.setString(2, author);
                ps.setDate(3, publish_date);
                ps.setInt(4, quantity);
                ps.executeUpdate();
                System.out.println("Book added");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void dataMember() {
        try(Connection conn = dB.getConnetion()) {
            while(true) {
                System.out.println("Write 'done' in full name if you're finish");
                System.out.print("Full name: ");
                String name=scanner.nextLine();
                if(name.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Email: ");
                String email=scanner.nextLine();
                System.out.print("Phone number: ");
                String phone=scanner.nextLine();
                String sql = "INSERT INTO members(full_name, email, phone) values(?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.executeUpdate();
                System.out.println("Member added sucsesfully");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void borrowBook() {
        try(Connection conn = dB.getConnetion()) {
            while(true) {
                System.out.println("Write 'done' in member ID if you're finish");
                System.out.print("Member ID: ");
                String mID=scanner.nextLine();
                if(mID.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Book ID: ");
                String bID=scanner.nextLine();
                System.out.print("Borrow Date yyyy-mm-dd: ");
                Date bDate;
                try {
                    bDate=Date.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid, enter yyyy-mm-dd");
                    System.out.println("Start Over");
                    continue;
                }
                System.out.print("Return Date yyyy-mm-dd: ");
                Date rDate;
                try {
                    rDate=Date.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid, enter yyyy-mm-dd");
                    System.out.println("Start Over");
                    continue;
                }
                String sql = "INSERT INTO borrow(member_id, book_id, borrow_date, return_date) values(?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, mID);
                ps.setString(2, bID);
                ps.setDate(3, bDate);
                ps.setDate(4, rDate);
                ps.executeUpdate();
                System.out.println("Borrow data added sucsesfully");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void showBook() {
        try(Connection conn = dB.getConnetion()) {
            String SQL = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Publish Date: " + rs.getDate("publish_date"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("-----------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void updateBook() {
        try(Connection conn =dB.getConnetion()) {
            while(true) {
                System.out.println("Write 'done' in book's title if you're finish");
                System.out.print("Book's title: ");
                String title = scanner.nextLine();
                if (title.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Book's author: ");
                String author = scanner.nextLine();
                Date publish_date;
                System.out.print("Publish Date (yyyy-MM-dd): ");
                try {
                    publish_date = Date.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("INVALID format!, use yyyy-mm-dd");
                    System.out.println("start over");
                    continue;
                }
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Where book ID: ");
                String ID = scanner.nextLine();
                String SQL = "UPDATE books " +
                        "SET  title= ?, author=?, publish_date=?, quantity=? " +
                        "WHERE book_id = ?";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setString(1, title);
                ps.setString(2, author);
                ps.setDate(3, publish_date);
                ps.setInt(4, quantity);
                ps.setString(5, ID);
                int rows = ps.executeUpdate();
                if (rows>0) {
                    System.out.println("Book updated succesfully");
                } else {
                    System.out.println("Book ID not Found");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    static void deleteBook() {
        try(Connection conn = dB.getConnetion()) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            String sql = "DELETE FROM books WHERE title = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            int rows = ps.executeUpdate();
            if(rows >0) {
                System.out.println("Book deleted succesfully");
            } else {
                System.out.println("Book not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void searchBook() {
        try(Connection conn = dB.getConnetion()) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            String sql = "SELECT * FROM books WHERE title = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("-----------------------------------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Publish Date: " + rs.getDate("publish_date"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("-----------------------------------------------------");
            }
            if (!found) {
                System.out.println("Book not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void sortBook() {
        try(Connection conn = dB.getConnetion()) {
            String sql = "SELECT * FROM books ORDER BY quantity DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("---------------------SORT BY QUANTITY DESC----------------------");
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Publish Date: " + rs.getDate("publish_date"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
