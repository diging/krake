package edu.asu.diging.krake.users;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import edu.asu.diging.krake.db4o.DatabaseManager;

@Component
public class UserDatabaseClient {

    private ObjectContainer client;

    @Autowired
    @Qualifier("userDatabaseManager")
    private DatabaseManager userDatabase;

    @PostConstruct
    public void init() {
        client = userDatabase.getClient();
    }

    public User getUser(String name, String pw) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(pw);

        ObjectSet<User> results = client.queryByExample(user);

        // there should only be exactly one object with this id
        if (results.size() == 1)
            return results.get(0);

        return null;
    }

    /**
     * Finds a user by its user id.
     * 
     * @param name
     *            user id.
     * @return found user or null
     */
    public User findUser(String name) {
        ObjectSet<User> results = client.query(new Predicate<User>() {

            @Override
            public boolean match(User arg0) {
                if (arg0.getUsername().equals(name)) {
                    return true;
                }
                return false;
            };
        });

        // there should only be exactly one object with this id
        if (results.size() >= 1) {
            return results.get(0);
        }

        return null;
    }

    public List<User> findUsers(User exampleUser) {
        ObjectSet<User> results = client.queryByExample(exampleUser);
        return results;
    }

    public User[] getAllUser() {
        ObjectSet<User> results = client.query(User.class);
        return results.toArray(new User[results.size()]);
    }

    public User addUser(User user) {
        client.store(user);
        client.commit();
        return user;
    }

    public void deleteUser(String name) {
        User user = new User();
        user.setUsername(name);

        ObjectSet<User> results = client.queryByExample(user);
        for (User res : results) {
            client.delete(res);
            client.commit();
        }
    }

    public void update(User user) {
        client.store(user);
        client.commit();
    }

}