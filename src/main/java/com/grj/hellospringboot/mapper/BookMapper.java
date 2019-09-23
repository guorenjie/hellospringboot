package com.grj.hellospringboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.grj.hellospringboot.vo.BookUserVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
public interface BookMapper extends BaseMapper<Book> {

    /**
     *多表分页，自定义sql
     * @param page 分页对象
     * @return
     */
    @Select("SELECT b.id as bid,u.id as uid,b.*,u.* FROM book b,user u WHERE b.user_id = u.id")
    List<Map> getBookUserMap(Page<Map> page);
    /**
     *多表分页，自定义sql
     * @param page 分页对象
     * @return
     */
    @Select("SELECT b.id as bid,u.id as uid,b.*,u.* FROM book b,user u WHERE b.user_id = u.id")
    List<BookUserVO> getBookUserVO(Page<BookUserVO> page);
}
