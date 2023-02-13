package com.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.entity.Users;
import com.mp.mapper.UsersMapper;
import com.mp.service.IUsersService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
}
