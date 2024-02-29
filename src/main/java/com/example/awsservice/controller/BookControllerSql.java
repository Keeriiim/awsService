package com.example.awsservice.controller;


import com.example.awsservice.Repository.SqlRepo;
import com.example.awsservice.models.BookSql;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sqlbooks")
public class BookControllerSql {


        private final SqlRepo sqlRepo;

        public BookControllerSql(SqlRepo sqlRepo) {
            this.sqlRepo= sqlRepo;
        }

        @PostMapping("")
        public ResponseEntity<BookSql> addBook (@RequestBody BookSql booksql){

            return ResponseEntity.ok(sqlRepo.save(booksql));
        }

        @GetMapping("")
        public ResponseEntity<List<BookSql>> getBooks(){
            return ResponseEntity.ok(sqlRepo.findAll());
        }


}

