package Navi.repository;

import Navi.model.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Blen on 5/6/2017.
 */
public interface UserDao extends CrudRepository<User,Long> {
        public User findUserByFirstNameAndLastName(String firstName, String lastName);
        public User findByDeviceId(String deviceId);
        public User findByFirstName(String firstName);
}
