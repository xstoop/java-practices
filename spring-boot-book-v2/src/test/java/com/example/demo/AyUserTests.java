package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class AyUserTests {

    @Resource
    private AyUserService ayUserService;

    @Test
    void contextLoads() {
    }

    @Test
    public void ayUserServiceTest() {
        // 新增
//        create();
        // findAll
//        List<AyUser> users = ayUserService.findAll();
        // 模糊查询
//        List<AyUser> users = ayUserService.findByNameLike("%小%");
        // 查询多个id
//        Collection<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//        List<AyUser> users = ayUserService.findByIdIn(ids);
//        System.out.println(users.size());

        // 分页
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        Page<AyUser> users = ayUserService.findAll(pageRequest);
//        System.out.println(users.getTotalPages());

//        for (AyUser user : users) {
//            System.out.println(user);
//        }
        // 修改
//        AyUser user = ayUserService.findById(1);
//        user.setName("小明改了名字");
//        ayUserService.save(user);
//        System.out.println(ayUserService.findById(1));
//        ayUserService.deleteById(1);
    }

    private void create() {
        List<String> names = List.of("小明", "小红", "大神", "二明", "卡卡", "码码", "元元", "下下下下", "换");

        for (String name : names) {
            AyUser user = new AyUser();
            user.setName(name);
            user.setPassword("111222333");
            AyUser user1 = ayUserService.save(user);
            System.out.println(user1);
        }
    }
}
