package com.yczuoxin.demo.eurekaclient1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("product")
@Data
public class ProductEntity {
    @TableId
    private Long id;

    @TableField
    private String name;

    @TableField
    private String description;

}
