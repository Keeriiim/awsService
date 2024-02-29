package com.example.awsservice.Repository;

import com.example.awsservice.models.BookSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlRepo extends JpaRepository<BookSql, Long> {
}
