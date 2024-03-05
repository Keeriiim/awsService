package com.example.awsservice.controller;



import com.example.awsservice.models.BookSql;
import com.example.awsservice.service.ServiceSql;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sqlbooks")
public class BookControllerSql {


        private final ServiceSql serviceSql;

        public BookControllerSql(ServiceSql serviceSql) {
            this.serviceSql = serviceSql;
        }

        @PostMapping("")
        public ResponseEntity<BookSql> addBook (@RequestBody BookSql booksql){
             BookSql bookSql = serviceSql.addBook(booksql);
            return ResponseEntity.ok(bookSql);
        }

        @GetMapping("")
        public ResponseEntity<List<BookSql>> getBooks(){
            List<BookSql> books = serviceSql.getBooks();
            return ResponseEntity.ok(books);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<BookSql> deleteBook(@PathVariable Long id){
            BookSql bookSql = serviceSql.deleteBook(id);
            return ResponseEntity.ok(bookSql);
        }

        @PutMapping("/{id}")
        public ResponseEntity<BookSql> updateBook(@PathVariable Long id, @RequestBody BookSql booksql){
            BookSql bookSql = serviceSql.updateBook(id, booksql);
            return ResponseEntity.ok(bookSql);
        }


}

