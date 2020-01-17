package com.example.sharding;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sharding.dto.TestShardingA;
import com.example.sharding.mapper.TestShardingAMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 分片表测试
 *
 * @author zhangJun
 * @Date 2020/1/9
 */
@Slf4j
public class ShardingATest extends BaseTest {

    @Autowired
    private TestShardingAMapper mapper;

    @Test
    public void testDeleteAll() {
        mapper.delete(null);
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            TestShardingA test = new TestShardingA();
            test.setSdName("iphone-" + i);
            test.setId(Long.parseLong(i + ""));
            mapper.insert(test);
        }

    }

    @Test
    public void testSelectOneById() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 1L);
        TestShardingA userList = mapper.selectOne(queryWrapper);
        log.info(userList.toString());
    }

    @Test
    public void testSelectOneByName() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sd_Name", "iphone-2");
        TestShardingA userList = mapper.selectOne(queryWrapper);
        log.info(userList.toString());
    }

    @Test
    public void testSelectListOrderBy() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("id");
        List<TestShardingA> userList = mapper.selectList(queryWrapper);
        Assert.assertEquals(10, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        Page<TestShardingA> page = new Page<>(2, 3);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("id");
        IPage<TestShardingA> userListPage = mapper.selectPage(page, queryWrapper);
        List<TestShardingA> userList = userListPage.getRecords();
        log.info("page size=" + userList.size());
        for (TestShardingA mycatTestShardingA : userList) {
            log.info(mycatTestShardingA.toString());
        }
    }


}
