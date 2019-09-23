package com.grj.hellospringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.entity.User;
import com.grj.hellospringboot.service.BookService;
import com.grj.hellospringboot.vo.BookUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author guorenjie
 * @since 2019-09-22
 */
@Api(tags = "书籍管理")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @ApiOperation("获取所有书籍")
    @RequestMapping("/getAll")
    public IPage<Book> getAll(){
        IPage<Book> iPage = bookService.page(new Page<Book>(1,2));
        return iPage;
    }
    @ApiOperation("查询书籍详细信息")
    @RequestMapping("/getBookInfo")
    public IPage<BookUserVO> getBookInfo(){
        IPage<BookUserVO> page = bookService.getBookUserVO(new Page<BookUserVO>(1, 2));
        return page;
    }
}
