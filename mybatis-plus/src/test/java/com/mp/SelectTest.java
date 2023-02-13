package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mp.entity.Users;
import com.mp.mapper.UsersMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xstoop
 * @date 2022/1/25 下午3:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void mapperSelectAll() {
        // 查询所有
        // SELECT id,age,name,avatar,status,create_time,update_time FROM users
        List<Users> usersList = usersMapper.selectList(null);
        usersList.forEach(System.out::println);
    }

    @Test
    public void mapperSelectById() {
        // 按id查询
        // SELECT id,age,name,avatar,status,create_time,update_time FROM users WHERE id=?
        Users users = usersMapper.selectById(1);
        System.out.println(users);
    }

    @Test
    public void mapperSelectByIds() {
        // 查询多个id
        // SELECT id,age,name,avatar,status,create_time,update_time FROM users WHERE id IN ( ? , ? , ? , ? )
        List<Integer> ids = Arrays.asList(1, 2, 3, 4);
        List<Users> users = usersMapper.selectBatchIds(ids);
        System.out.println(users);
    }

    @Test
    public void mapperSelectByMap() {
        // 按map来查询，只能设置‘='等号的查询条件
        // SELECT id,age,name,avatar,status,create_time,update_time FROM users WHERE name = ? AND status = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "user1");
        map.put("status", "normal");

        List<Users> users = usersMapper.selectByMap(map);

        System.out.println(users);
    }

    @Test
    public void mapperSelectByWrapper() {
        // 使用条件构造器查询: like between > >= < <= in and or 多条件
        // SELECT id,age,name,avatar,status,create_time,update_time FROM users WHERE (id = ? AND name LIKE ? AND age BETWEEN ? AND ? AND age < ? AND age >= ? OR id = ?)
        // lt < 、le <= 、gt > 、ge >=
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1)
                .like("name", "user")
                .between("age", 10, 20)
                .lt("age", 10)
                .ge("age", 20)
                .or()
                .eq("id", 2);


        List<Users> users = usersMapper.selectList(queryWrapper);
        System.out.println(users);

        QueryWrapper<Users> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id", 1).or(true).eq("id", 2).eq("id", 3);
        List<Users> users1 = usersMapper.selectList(queryWrapper1);
        System.out.println(users1);

    }
}
