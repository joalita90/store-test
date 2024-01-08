package com.lite.thinking.store.services;

import java.util.List;
import com.lite.thinking.store.model.User;

public interface UserService {
	
	List<User> getAllUsers();
    User save(final User user);
    User getById(final int id);
    User update(final int id, final User user);
    void delete(final int id);

}
