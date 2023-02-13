package com.mp;

import com.mp.entity.Users;
import com.mp.mapper.UsersMapper;
import com.mp.service.IUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author xstoop
 * @date 2022/1/25 下午3:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private IUsersService usersService;

    @Test
    public void save() {
        // mapper 新增一条
        Users user1 = new Users();

        user1.setAge(22);
        user1.setName("user1");
        user1.setCreateTime(LocalDateTime.now());

        int rows = usersMapper.insert(user1);
        System.out.println(rows);

        // service 新增一条
        Users user2 = new Users();

        user2.setAge(22);
        user2.setName("user2");
        user2.setCreateTime(LocalDateTime.now());

        boolean save = usersService.save(user2);
        System.out.println(save);
    }

    @Test
    public void saveBatch() {
        // service 新增多条

        Users users1 = new Users();
        users1.setAge(23);
        users1.setName("user1");
        users1.setCreateTime(LocalDateTime.now());

        Users users2 = new Users();
        users2.setAge(25);
        users2.setName("user2");
        users2.setCreateTime(LocalDateTime.now());

        List<Users> usersList = Arrays.asList(users1, users2);

        usersService.saveBatch(usersList);
        usersService.saveBatch(usersList,1);
    }

    @Test
    public void saveOrUpdate() {
        Users users1 = new Users();
        users1.setAge(23);
        users1.setName("user1");
        users1.setCreateTime(LocalDateTime.now());

        usersService.saveOrUpdate(users1);
    }
}
