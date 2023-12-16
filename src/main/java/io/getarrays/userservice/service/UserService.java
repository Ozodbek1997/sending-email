/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 11:39 AM
 * Project Name: userservice
 */

package io.getarrays.userservice.service;


import io.getarrays.userservice.model.User;

public interface UserService {

    User saveUser(User user);

    Boolean verifyToken(String token);

}
