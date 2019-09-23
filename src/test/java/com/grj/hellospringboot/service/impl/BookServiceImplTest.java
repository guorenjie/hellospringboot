package com.grj.hellospringboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.ApplicationTest;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImplTest extends ApplicationTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getBookUserMap() {
        Page<Map> page = bookService.getBookUserMap(new Page<>(1, 2));
        List list = page.getRecords();
        System.out.println("总记录数"+page.getTotal());
        list.forEach(System.out::println);
    }
}