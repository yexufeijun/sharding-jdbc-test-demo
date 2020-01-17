package com.example.sharding.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("TEST_SHARDING_A")
public class TestShardingA {
    @TableId
    private Long id;

    private String sdName;


}
