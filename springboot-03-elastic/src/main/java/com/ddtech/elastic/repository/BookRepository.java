package com.ddtech.elastic.repository;

import com.ddtech.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    List<Book> findByBookName(String bookName);
}
