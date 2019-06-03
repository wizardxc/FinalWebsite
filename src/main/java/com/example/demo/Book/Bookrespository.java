package com.example.demo.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface Bookrespository  extends JpaRepository<Book,String> {
        public Book findByBid(int id);
}
