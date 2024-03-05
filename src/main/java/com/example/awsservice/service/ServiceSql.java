package com.example.awsservice.service;

import com.example.awsservice.controller.BookControllerSql;
import com.example.awsservice.models.BookSql;
import com.example.awsservice.repository.SqlRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSql {

    private SqlRepo sqlRepo;
    public ServiceSql(SqlRepo sqlRepo) {
        this.sqlRepo = sqlRepo;
    }

    // Find all books
    public List<BookSql> getBooks(){
        return sqlRepo.findAll();
    }

    // Add a book
    public BookSql addBook(BookSql booksql){
        return sqlRepo.save(booksql);
    }

    // Delete a book
    public BookSql deleteBook(Long id){
        BookSql bookSql = sqlRepo.findById(id).orElse(null);
        if (bookSql != null){
            sqlRepo.delete(bookSql);
        }
        return bookSql;
    }


    // Update a book
    public BookSql updateBook(Long id, BookSql booksql){
        BookSql bookSql = sqlRepo.findById(id).orElse(null);
        if (bookSql != null){
            bookSql.setAuthor(booksql.getAuthor());
            bookSql.setTitle(booksql.getTitle());
            sqlRepo.save(bookSql);
        }
        return bookSql;
    }


}
