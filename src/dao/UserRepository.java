package dao;

import dao.Repository;
import model.User;

// todo check if we need separate repos for Player and Administrator
public interface UserRepository extends Repository<Long, User> {
}
