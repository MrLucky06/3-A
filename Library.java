import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Library {

    public void addBook(Book book) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO books (id, title, author, available) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setBoolean(4, book.isAvailable());
            stmt.executeUpdate();
            System.out.println("Book added to the database.");
        } catch (SQLException e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    public void updateBookAvailability(int bookId, boolean availability) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE books SET available = ? WHERE id = ?");
            stmt.setBoolean(1, availability);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
            System.out.println("Book availability updated.");
        } catch (SQLException e) {
            System.err.println("Error updating availability: " + e.getMessage());
        }
    }
}
