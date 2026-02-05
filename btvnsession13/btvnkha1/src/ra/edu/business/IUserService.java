package ra.edu.business;

import ra.edu.model.User;

public interface IUserService extends IBaseService<User,Integer> {
    int getMaxId();

    void deleteByEmail(String email);
}
