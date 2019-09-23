package com.grj.hellospringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grj.hellospringboot.vo.BookUserVO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
public interface BookService extends IService<Book> {
    /**
     * 多表分页
     * @param page
     * @return
     */
    Page<Map> getBookUserMap(Page<Map> page);

    /**
     * 多表分页
     * @param page
     * @return
     */
    Page<BookUserVO> getBookUserVO(Page<BookUserVO> page);
}
