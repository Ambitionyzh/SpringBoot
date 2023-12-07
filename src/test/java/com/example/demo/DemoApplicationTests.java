package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        book.setName("wuhu");
        book.setType("wuhu");
        book.setDescription("wuhu");
        mongoTemplate.save(book);
    }

}
