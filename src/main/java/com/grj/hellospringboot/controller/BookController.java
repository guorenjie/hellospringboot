package com.grj.hellospringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.mapper.BookMapper;
import com.grj.hellospringboot.service.BookService;
import com.grj.hellospringboot.vo.BookUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private BookMapper bookMapper;

    @ApiOperation("获取所有书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页",dataType = "long",defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数",dataType = "long", defaultValue = "5", required = true)
    })
    @RequestMapping("/getAll")
    public IPage<Book> getAll(long currentPage,long pageSize){
        return bookService.page(new Page<Book>(currentPage,pageSize));
    }
    @ApiOperation("查询书籍详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页",dataType = "long", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数",dataType = "long", defaultValue = "5", required = true)
    })
    @RequestMapping("/getBookInfo")
    public IPage<BookUserVO> getBookInfo(long currentPage,long pageSize){
        return bookService.getBookUserVO(new Page<BookUserVO>(currentPage,pageSize));
    }
    @ApiOperation("添加书籍")
    @ApiImplicitParam(name = "book", value = "book对象",dataType = "Book",defaultValue = "book", required = true)
    @RequestMapping("/addBook")
    public boolean addBook(Book book){
        return bookService.save(book);
    }
}
