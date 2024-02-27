package com.example.awsservice.Repository;

import com.example.awsservice.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends org.springframework.data.mongodb.repository.MongoRepository<Book, String>{




}
