package com.grj.hellospringboot.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Book,User关联查询对象", description="")
public class BookUserVO implements Serializable {

    @ApiModelProperty(value = "书籍主键ID")
    private String bid;

    @ApiModelProperty(value = "书籍编号")
    private String bookNum;

    @ApiModelProperty(value = "数据名称")
    private String bookName;

    @ApiModelProperty(value = "作者")
    private String bookAuthor;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户主键ID")
    private String uid;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

}
