package ra.edu.business.ra.business.impl;

import ra.edu.business.IUserService;
import ra.edu.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void delete(Integer integer) {
        User user = findById(integer);
        if (user != null) {
            users.remove(user);
        }
    }

    @Override
    public void update(User user, Integer integer) {
        int index = users.indexOf(findById(integer));
        users.set(index, user);
    }

    @Override
    public User findById(Integer integer) {
        for (User user : users) {
            if (user.getId() == integer) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void sort() {

    }

    @Override
    public int getMaxId() {
        int maxId = users.getFirst().getId();
        for (User user : users) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        return 0;
    }

    @Override
    public void deleteByEmail(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }
}
