package com.grj.hellospringboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.mapper.BookMapper;
import com.grj.hellospringboot.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grj.hellospringboot.vo.BookUserVO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    /**
     * 多表分页
     *
     * @param page
     * @return
     */
    @Override
    public Page<Map> getBookUserMap(Page<Map> page) {
        return page.setRecords(this.baseMapper.getBookUserMap(page));
    }

    /**
     * 多表分页
     *
     * @param page
     * @return
     */
    @Override
    public Page<BookUserVO> getBookUserVO(Page<BookUserVO> page) {
        return page.setRecords(this.baseMapper.getBookUserVO(page));
    }
}
