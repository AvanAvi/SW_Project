package com.libmgmt.library.repository;

import com.libmgmt.library.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide");
        book.setIsbn("978-0345391803");

        Book savedBook = bookRepository.save(book);

        assertNotNull(savedBook.getId());
        assertEquals("The Hitchhiker's Guide", savedBook.getTitle());
        assertEquals("978-0345391803", savedBook.getIsbn());
    }
}