package com.mm.zb.service.impl;

import com.google.gson.Gson;
import com.mm.zb.dataObject.Users;
import com.mm.zb.repository.UserRepository;
import com.mm.zb.service.UserService;
import com.mm.zb.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Creat by ZB
 * 2019-02-23 20:52
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserRepository repository;

    @Autowired
    private Gson gson = new Gson();

    @Override
    public Users findByUserName(String userName) {
        Users thisUser = repository.findByUserName(userName);
        return thisUser;
    }

    @Override
    public void save(Users users) {
        repository.save(users);
    }

    @Override
    public void R_save(Users users) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        String J_users = gson.toJson(users);
        operations.set(users.getUserId(), J_users, 3, TimeUnit.HOURS);
    }

    @Override
    public Users R_get(String userId) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String users = valueOperations.get(userId);
        Users users1 = gson.fromJson(users, Users.class);
        return users1;
    }
}
