package edu.asu.diging.krake.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import edu.asu.diging.krake.users.AccountStatus;
import edu.asu.diging.krake.users.IUserManager;
import edu.asu.diging.krake.users.User;

public class KrakeConnectionSignUp implements ConnectionSignUp {

    private IUserManager userManager;

    public KrakeConnectionSignUp(IUserManager userManager) {
        this.userManager = userManager;
    }
 
    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        
        User user = new User();
        user.setUsername(profile.getUsername());
        user.setFirstname(profile.getFirstName());
        user.setLastname(profile.getLastName());
        user.setEmail(profile.getEmail());
        user.setProvider(connection.getKey().getProviderId());
        user.setUserIdOfProvider(connection.getKey().getProviderUserId());
        user.setAccountStatus(AccountStatus.ADDED);
        
        userManager.addUser(user);
        return user.getUsername();
    }

}