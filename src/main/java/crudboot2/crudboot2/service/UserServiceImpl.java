package crudboot2.crudboot2.service;

import crudboot2.crudboot2.dao.UserDao;
import crudboot2.crudboot2.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

       @Override
    public void create(User user) {
        userDao.create(user);
    }

       @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

        @Override
    public void update(User user) {
        userDao.update(user);
    }

        @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

       @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}