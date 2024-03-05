package com.example.awsservice.serviceTests;

import com.example.awsservice.models.BookSql;
import com.example.awsservice.repository.SqlRepo;
import com.example.awsservice.service.ServiceSql;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceSqlTests {

    @Mock
    private SqlRepo sqlRepo;

    @InjectMocks
    private ServiceSql serviceSql;

    @Test
    public void testGetBooks() {
        List<BookSql> books = new ArrayList<>();

        // Add some dummy books to the list
        books.add(new BookSql("Book 1", "Author 1"));
        books.add(new BookSql("Book 2", "Author 2"));

        // Mock the behavior of the findAll method to return the list of dummy books
        when(sqlRepo.findAll()).thenReturn(books);

        // Call the method to get the books
        List<BookSql> result = serviceSql.getBooks();

        // Asserts to verify that the method has returned the correct result
        System.out.println("book: " + books.get(0).getAuthor() + "\n" + "result: " + books.get(0).getAuthor());
        assertEquals(books.get(0).getAuthor(), result.get(0).getAuthor());
    }

    @Test
    public void testAddBook() {
        // Create a dummy book
        BookSql book = new BookSql("Book 1", "Author 1");

        // Mock the behavior of the save method to return the dummy book
        when(sqlRepo.save(book)).thenReturn(book);

        // Call the method to get the added book returned and stored in the result variable
        BookSql result = serviceSql.addBook(book);

        // Asserts to verify that the method has returned the correct result
        assertEquals(book.getAuthor(), result.getAuthor());
    }

    @Test
    public void testDeleteBook() {
        // Create a list of dummy books
        ArrayList<BookSql> books = new ArrayList<>();
        books.add(new BookSql(1L,"Book 1", "Author 1"));
        books.add(new BookSql(2L,"Book 2", "Author 2"));

        // Mock the behavior of findById to return the book with ID 2L
        when(sqlRepo.findById(2L)).thenReturn(Optional.of(books.get(1)));

        // Call the delete method
        BookSql result = serviceSql.deleteBook(2L);

        // Verify that the book was deleted
        verify(sqlRepo, times(1)).delete(books.get(1));
    }


    @Test
    public void testDeleteBook_BookNotFound() {
        // Create a dummy book ID
        Long bookId = 1L;

        // Mock the behavior of findById to return null
        when(sqlRepo.findById(bookId)).thenReturn(Optional.empty());

        // Call the deleteBook method
        BookSql deletedBook = serviceSql.deleteBook(bookId);

        // Verify that delete was not called
        verify(sqlRepo, never()).delete(any());

        // Verify that null was returned
        assertNull(deletedBook);
    }

    @Test
    public void testUpdateBook() {
        Long bookId = 1L;
        BookSql book = new BookSql(bookId, "Book 1", "Author 1");

        // Mock the behavior of findById to return the dummy book
        when(sqlRepo.findById(bookId)).thenReturn(Optional.of(book));

        // Mock the behavior of save
        when(sqlRepo.save(book)).thenReturn(book);

        // Create a new book with updated values
        BookSql updatedBook = new BookSql(bookId, "Updated Book 1", "Updated Author 1");

        // Call the update method
        BookSql result = serviceSql.updateBook(bookId, updatedBook);


        // Verify that the book was updated
        assertEquals(updatedBook.getTitle(), result.getTitle());
        assertEquals(updatedBook.getAuthor(), result.getAuthor());
    }
}
